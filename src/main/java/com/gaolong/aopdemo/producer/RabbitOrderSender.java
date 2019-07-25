package com.gaolong.aopdemo.producer;

import com.gaolong.aopdemo.logs.OperationLog;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitOrderSender {
    //自动注入RabbitTemplate模板类
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //回调函数: confirm确认
    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            String messageId = correlationData.getId();
            if(ack){
                System.out.println("----------监听生产者已发送消息到exchange和queue----------messageId："+messageId);
            } else {
                //失败则进行具体的后续操作:重试 或者补偿等手段
                System.err.println("异常处理...");
            }
        }
    };

    // 消息没有正确到达队列时触发回调，如果正确到达队列不执
    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(Message message, int i, String s, String s1, String s2) {

            // 反序列化对象输出
            System.out.println("消息主体: " + SerializationUtils.deserialize(message.getBody()));
            System.out.println("应答码: " + i);
            System.out.println("描述：" + s);
            System.out.println("消息使用的交换器 exchange : " + s1);
            System.out.println("消息使用的路由键 routing : " + s2);
        }
    };

    //发送消息方法调用: 构建自定义对象消息
    public void sendOrder(OperationLog operationLog)  {
        // 通过实现 ConfirmCallback 接口，消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，也就是只确认是否正确到达 Exchange 中
        // 监听生产者是否发送消息到exchange和queue
        rabbitTemplate.setConfirmCallback(confirmCallback);
        //消息唯一ID
        CorrelationData correlationData = new CorrelationData(operationLog.getId());
        rabbitTemplate.convertAndSend("order-exchange", "order.ABC", operationLog, correlationData);
    }
}

