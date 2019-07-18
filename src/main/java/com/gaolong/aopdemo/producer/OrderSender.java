package com.gaolong.aopdemo.producer;

import com.gaolong.aopdemo.logs.OperationLog;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(OperationLog operationLog){
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(operationLog.getId());
        rabbitTemplate.convertAndSend("order-exchange","order.abcd",operationLog);
        /**
         * 还要在 rabbitmq 控制台配置exchange和queue，并绑定
         * 加绑定在控制台的exchange和queues哪一块都可以
         */
    }
}