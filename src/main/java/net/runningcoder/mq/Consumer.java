package net.runningcoder.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by wangmaocheng on 2017/10/25.
 */
@Slf4j
@Component
public class Consumer {

    @JmsListener(destination = "sample.queue", containerFactory="jmsListenerContainerQueue")
    public void receiveQueue1(String text) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("queue1:===>" + text);
    }

    @JmsListener(destination = "sample.queue", containerFactory="jmsListenerContainerQueue")
    public void receiveQueue2(String text) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("queue2:===>" + text);
    }

    @JmsListener(destination = "sample.topic", containerFactory="jmsListenerContainerTopic")
    public void receiveTopic1(String text) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("topic1:===>" + text);
    }

    @JmsListener(destination = "sample.topic", containerFactory="jmsListenerContainerTopic")
    public void receiveTopic2(String text) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("topic2:===>" + text);
    }

}
