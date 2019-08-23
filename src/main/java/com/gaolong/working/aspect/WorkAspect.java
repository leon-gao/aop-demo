package com.gaolong.working.aspect;

import com.alibaba.fastjson.JSON;
import com.gaolong.aopdemo.annotation.OperationLogDetail;
import com.gaolong.aopdemo.logs.OperationLog;
import com.gaolong.aopdemo.producer.OrderSender;
import com.gaolong.aopdemo.producer.RabbitOrderSender;
import com.gaolong.working.producer.WorkSender;
import com.gaolong.working.vo.ReserveConferenceInfoVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Aspect
@Component
public class WorkAspect {

    /**
     * 引入RabbitMQ生产则
     */
    @Autowired
    private WorkSender workSender;

    /**
     * 定义切面，按照WorkInterceptorAnnotation注解进行切面
     */
    @Pointcut("@annotation(com.gaolong.working.annotation.WorkInterceptorAnnotation)")
    public void intercept(){}

    /**
     * 环绕增强
     */
    @Around("intercept()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object res = null;
        long time = System.currentTimeMillis();
        try {
            res =  joinPoint.proceed();
            time = System.currentTimeMillis() - time;
            return res;
        } finally {
            try {
                //方法执行完成后增加日志
//                for (int i = 0 ; i<10; i++) {
                    addOperationLog(joinPoint,res,time);
//                }

            }catch (Exception e){
                System.out.println("LogAspect 操作失败：" + e.getMessage());
                e.printStackTrace();
            }
        }
    }


    private void addOperationLog(JoinPoint joinPoint, Object res, long time){

        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        OperationLog operationLog = new OperationLog();
        // 执行时间
        operationLog.setRunTime(time);
        // 返回信息
        operationLog.setReturnValue(JSON.toJSONString(res));
        // 随机UUID
        operationLog.setId(UUID.randomUUID().toString());
        // 请求参数


        String args = JSON.toJSONString(joinPoint.getArgs());

        args = args.substring(1, args.length()-1);

        ReserveConferenceInfoVO dto = JSON.parseObject(args, ReserveConferenceInfoVO.class);
        System.out.println(dto.toString());

        operationLog.setArgs(args);
        // 创建时间
        operationLog.setCreateTime(new Date());

        // 操作人
        operationLog.setUserId("gaol");
        operationLog.setUserName("gaol");
        OperationLogDetail annotation = signature.getMethod().getAnnotation(OperationLogDetail.class);
        if(annotation != null) {
            operationLog.setDescribe(annotation.detail());
            operationLog.setOperationType(annotation.operationType().getValue());
        }
        System.out.println("将拦截信息发送到MQ:" + operationLog.toString());

//        workSender.sendOrder(operationLog);

    }

//    /**
//     * 对当前登录用户和占位符处理
//     * @param argNames 方法参数名称数组
//     * @param args 方法参数数组
//     * @param annotation 注解信息
//     * @return 返回处理后的描述
//     */
//    private String getDetail(String[] argNames, Object[] args, OperationLogDetail annotation){
//
//        Map<Object, Object> map = new HashMap<>(4);
//        for(int i = 0;i < argNames.length;i++){
//            map.put(argNames[i],args[i]);
//        }
//
//        String detail = annotation.detail();
//        try {
//            detail = "'" + "#{currentUserName}" + "'=》" + annotation.detail();
//            for (Map.Entry<Object, Object> entry : map.entrySet()) {
//                Object k = entry.getKey();
//                Object v = entry.getValue();
//                detail = detail.replace("{{" + k + "}}", JSON.toJSONString(v));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return detail;
//    }

    @Before("intercept()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        System.out.println("进入方法前先执行doBeforeAdvice().....");

    }

    /**
     * 处理完请求，返回内容
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "intercept()")
    public void doAfterReturning(Object ret) {
        System.out.println("处理完请求调用doAfterReturning().....,方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing("intercept()")
    public void throwss(JoinPoint jp){
        System.out.println("方法异常时执行throwss().....");
    }


    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("intercept()")
    public void after(JoinPoint jp){
        System.out.println("不管是抛出异常或者正常退出都会执行after().....");
    }

}
