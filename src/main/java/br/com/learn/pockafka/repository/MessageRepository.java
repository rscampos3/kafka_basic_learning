package br.com.learn.pockafka.repository;

import br.com.learn.pockafka.dto.JsonExemplo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageRepository {
    private List<JsonExemplo> list = new ArrayList<>();

    public void addMessage(JsonExemplo message) {
        this.list.add(message);
    }

    public List<JsonExemplo> getAllMessages() {
        return this.list;
    }
}
