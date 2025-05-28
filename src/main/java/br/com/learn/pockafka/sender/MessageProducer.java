package br.com.learn.pockafka.sender;

import br.com.learn.pockafka.dto.JsonExemplo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    private Logger log = LoggerFactory.getLogger(MessageProducer.class);
    @Autowired
    private KafkaTemplate<String, JsonExemplo> kafkaTemplate;

    @Value("${myapp.kafka.topic}")
    private String topic;

    public void sendMessage(JsonExemplo json) {
        log.info("MESSAGE SENT FROM JSON END - > " + json);
        try {
            this.kafkaTemplate.send(topic, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
