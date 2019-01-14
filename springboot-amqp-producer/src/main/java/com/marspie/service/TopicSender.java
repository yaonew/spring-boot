package com.marspie.service;

import com.marspie.config.RabbitMqConfig;
import com.marspie.entity.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Copyright (c) 2019, The Marspie Open Source Project
 *
 * @author alex
 * @date 2019/1/14 10 38
 * @email yaonew@126.com
 * @blog http://nsoft.vip
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Order order) {
        this.rabbitTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE,"order.message", order);
        this.rabbitTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE,"order.ha", order);
    }

}
