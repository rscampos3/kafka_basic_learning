package br.com.learn.pockafka.consumer;

import br.com.learn.pockafka.dto.JsonExemplo;
import br.com.learn.pockafka.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    private Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    private MessageRepository messageRepository;

    @KafkaListener(topics = "${myapp.kafka.topic}", groupId = "xyz")
    public void consume(JsonExemplo message) {
        log.info("MESSAGE RECEIVED AT CONSUMER END -> " + message);
        this.messageRepository.addMessage(message);
    }
}
