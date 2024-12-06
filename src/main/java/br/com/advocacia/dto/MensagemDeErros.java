package br.com.advocacia.dto;

import org.springframework.http.HttpStatus;

public record MensagemDeErros(HttpStatus ststus,String mensagem) {

}
 