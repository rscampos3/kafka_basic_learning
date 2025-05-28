package br.com.learn.pockafka.dto;

import lombok.Builder;

@Builder
public record JsonExemplo(String nome, Integer idade, String cpf) {
}
