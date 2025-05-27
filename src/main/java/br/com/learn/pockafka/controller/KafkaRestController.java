package br.com.learn.pockafka.controller;

import br.com.learn.pockafka.repository.MessageRepository;
import br.com.learn.pockafka.sender.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaRestController {

    @Autowired
    private MessageProducer messageProducer;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("msg") String message) {
        this.messageProducer.sendMessage(message);
        return "" + message + " sent successfully!";
    }

    @GetMapping("/getAll")
    public String getAllMessages() {
        return this.messageRepository.getAllMessages();
    }
}
