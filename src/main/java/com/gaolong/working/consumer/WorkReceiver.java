package com.gaolong.working.consumer;

import com.gaolong.aopdemo.logs.OperationLog;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

@Component
public class WorkReceiver {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    //配置监听的哪一个队列，同时在没有queue和exchange的情况下会去创建并建立绑定关系
    @RabbitListener(bindings = {
        @QueueBinding(
        value = @Queue(value = "work-queue",durable = "true"),//arguments = @Argument(name = "x-message-ttl", value = "5000", type = "java.lang.Integer"),
        exchange = @Exchange(name="order-exchange",durable = "true",type = ExchangeTypes.FANOUT)
        ,key = "order.*"
        ),
        @QueueBinding(
        value = @Queue(value = "work-queue",durable = "true"),//arguments = @Argument(name = "x-message-ttl", value = "5000", type = "java.lang.Integer"),
        exchange = @Exchange(name="second-exchange",durable = "true",type = ExchangeTypes.FANOUT)
        ,key = "order.*")
    })
    @RabbitHandler//如果有消息过来，在消费的时候调用这个方法
    public void onOrderMessage(@Payload OperationLog operationLog, @Headers Map<String,Object> headers, Channel channel) throws IOException, InterruptedException {


//        List<String> parseList = JSON.parseArray(operationLog.getArgs(), String.class);

        /**
         * Delivery Tag 用来标识信道中投递的消息。RabbitMQ 推送消息给 Consumer 时，会附带一个 Delivery Tag，
         * 以便 Consumer 可以在消息确认时告诉 RabbitMQ 到底是哪条消息被确认了。
         * RabbitMQ 保证在每个信道中，每条消息的 Delivery Tag 从 1 开始递增。
         */
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        try {
//            String agrs = operationLog.getArgs();
////            System.out.println("输出参数"+agrs);
//            agrs = agrs.replace("\"", "").replace("[","").replace("]","").replace("{","").replace("}","");
//
//
//            String[] strsArray = agrs.split(",");
//            for (int i = 0; i < strsArray.length; i++) {
//                System.out.println(strsArray[i]);
//            }
//
////        Map<String, String> map = redisTemplate.hasKey("updateBykey");
//
//
//            String userId = operationLog.getUserId();
//
//            if ("select".equals(operationLog.getOperationType())){
//                System.out.println("---------收到select操作消息，开始消费---------");
//
//                redisTemplate.opsForSet().add(userId + operationLog.getMethod(), strsArray);
//                System.out.println("将"+strsArray.toString()+"保存到redis，key="+userId + operationLog.getMethod());
//
//            } else if ("update".equals(operationLog.getOperationType())) {
//
//                System.out.println("---------收到update操作消息，开始消费---------");
//
//
//                Set<String> existsSet = redisTemplate.opsForSet().members(userId + operationLog.getMethod());
//
//                if (existsSet != null && existsSet.size() > 0) {
//                    System.out.println("操作到原始信息中redis中存在，将修改后到信息保存到redis中，并进行对比操作");
//
//                    redisTemplate.opsForSet().add(userId + operationLog.getMethod()+"modify", strsArray);
//
//                    redisTemplate.opsForSet().differenceAndStore(userId + operationLog.getMethod()+"modify",userId + operationLog.getMethod() , userId + operationLog.getMethod()+"diff");
//
//                    Set<String> diffSet = redisTemplate.opsForSet().members(userId + operationLog.getMethod()+"diff");
//
//                    if (diffSet == null || diffSet.size() == 0) {
//                        System.out.println("Diff为空，表示本次未修改任何内容");
//                    } else {
//                        for (String str : diffSet) {
//
//                            String key = str.split(":")[0];
//                            String value = str.split(":")[1];
//
//                            Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("updateBykey");
//
//                            if (map != null) {
//                                String modifyDesc = map.get(key).toString();
//                                System.out.println("入库    "+modifyDesc + "->" + value);
//                            }
//
//                        }
//                    }
//
//                    redisTemplate.delete(userId + operationLog.getMethod());
//                    System.out.println("删除Redis"+userId + operationLog.getMethod());
//
//                    redisTemplate.delete(userId + operationLog.getMethod()+"modify");
//                    System.out.println("删除Redis"+userId + operationLog.getMethod()+"modify");
//
//                }
//
//            }

            System.out.println("---------消费End---------，我是work消费者, msg="+operationLog.getDescribe());

//            System.out.println("sleep 5s");
//            Thread.sleep(5000);


            /**
             *  multiple 取值为 false 时，表示通知 RabbitMQ 当前消息被确认
             *  如果为 true，则额外将比第一个参数指定的 delivery tag 小的消息一并确认
             */


            // TODO 模拟异常
//            System.out.println("----------模拟异常----------");
//            int x = 1;
//            int y = x/0;

            boolean multiple = false;

            //ACK,确认一条消息已经被消费
            System.out.println("----------确认一条消息被消费----------");
            channel.basicAck(deliveryTag, multiple);

        } catch (Exception e) {

//          if (message.getMessageProperties().getRedelivered()) {
//            if (true) {
//                System.out.println("消息已重复处理失败,拒绝再次接收");
//                // 拒绝消息，requeue=false 表示不再重新入队，如果配置了死信队列则进入死信队列
//                channel.basicReject(deliveryTag, false);
//            } else {
                System.out.println("消息即将再次返回队列处理");
                // requeue为是否重新回到队列，true重新入队
                channel.basicNack(deliveryTag, false, true);
//            }

        }

    }
}
