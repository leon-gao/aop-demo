package com.gaolong.working.annotation;

import com.gaolong.aopdemo.enums.OperationType;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkInterceptorAnnotation {

    /**
     * 方法描述,可使用占位符获取参数:{{tel}}
     */
    String detail() default "";

    /**
     * 日志等级:自己定，此处分为1-9
     */
    int level() default 0;

    /**
     * 业务类型(enum):主要是meeting,vocation，message等
     */
    OperationType bussinessType() default OperationType.UNKNOWN;


}
