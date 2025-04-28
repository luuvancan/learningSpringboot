package com.springlearn.webapp.controller.kafka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlearn.webapp.service.kafka.Producer;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@AllArgsConstructor
@RequestMapping("/kafka")
@Data
public class KafkaController {
    private final Producer producer;

    @GetMapping("/send")
    public String sendMessage() {
        producer.sendMessage("Hello Kafka!");
        return "Message sent to Kafka!";
    }
}
