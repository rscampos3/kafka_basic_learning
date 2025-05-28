package br.com.learn.pockafka.controller;

import br.com.learn.pockafka.dto.JsonExemplo;
import br.com.learn.pockafka.repository.MessageRepository;
import br.com.learn.pockafka.sender.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KafkaRestController {

    @Autowired
    private MessageProducer messageProducer;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<JsonExemplo>> getAllMessages() {
        return ResponseEntity.ok(this.messageRepository.getAllMessages());
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody JsonExemplo json) {
        this.messageProducer.sendMessage(json);
        return ResponseEntity.ok(json.toString() + " sent successfully!");
    }
}
