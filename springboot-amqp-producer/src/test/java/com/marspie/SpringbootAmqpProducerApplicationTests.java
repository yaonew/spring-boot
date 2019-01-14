package com.marspie;

import com.marspie.entity.Order;
import com.marspie.service.DirectSender;
import com.marspie.service.FanoutSender;
import com.marspie.service.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAmqpProducerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private DirectSender directSender;

    @Test
    public void testFanout() throws Exception {
        Order order = new Order();
        order.setId("1");
        order.setName("pwd");
        order.setMessageId("m0001");
        fanoutSender.send(order);
    }

    @Test
    public void testTopic() throws Exception {
        Order order = new Order();
        order.setId("2");
        order.setName("pwd");
        order.setMessageId("m0002");
        topicSender.send(order);
    }

    @Test
    public void testDirect() throws Exception {
        Order order = new Order();
        order.setId("3");
        order.setName("pwd");
        order.setMessageId("m0003");
        directSender.send(order);
    }

}

