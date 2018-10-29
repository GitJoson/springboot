package com.json.core.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MsgProducter {

    @Autowired
    private AmqpTemplate template;

    private final String queueName = "fistQueue";

    public void send(String msg){
        this.template.convertAndSend(queueName,msg);
        log.info("发送成功，队列名：[{}],消息内容：[{}]",queueName,msg);
    }
}
