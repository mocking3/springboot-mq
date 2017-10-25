package net.runningcoder.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Created by wangmaocheng on 2017/10/25.
 */
@Slf4j
@EnableScheduling
@Component
public class Producer {
    private int i = 0;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Scheduled(fixedDelay = 3000)
    public void send() {
        int j = i++;
        this.jmsMessagingTemplate.convertAndSend(this.queue, "Sample message(queue)" + j);
        log.info("Message was sent to the Queue");

        this.jmsMessagingTemplate.convertAndSend(this.topic, "Sample message(topic)" + j);
        log.info("Message was sent to the Topic");
    }

}
