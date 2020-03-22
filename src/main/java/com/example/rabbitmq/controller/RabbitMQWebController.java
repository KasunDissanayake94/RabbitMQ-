package com.example.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/example-rabbitmq/direct/")
public class RabbitMQWebController {

    @Autowired
    private AmqpTemplate amqpTemplate;
    //this will send message to Rmq exchange

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("exchangeName") String exchange, @RequestParam("routingKey") String routingKey,
                            @RequestParam("messageData") String messageData) {

        amqpTemplate.convertAndSend(exchange, routingKey, messageData);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

}