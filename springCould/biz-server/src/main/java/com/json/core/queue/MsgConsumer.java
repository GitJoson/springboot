package com.json.core.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MsgConsumer {

    private final String queueName = "fistQueue";

    /**
     * 这个方法创建bean,就如init方法，初始化作用，如果没有会报错。
     * @return
     */
    @Bean
    public Queue receive(){
        return new Queue(queueName);
    }

    @RabbitHandler
    @RabbitListener(queues = queueName)
    public void receive(String msg){
        log.info("接收成功，队列名：[{}],消息内容：[{}]",queueName,msg);
    }
}
