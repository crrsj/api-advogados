package br.com.advocacia.infra;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.advocacia.dto.MensagemDeErros;
import br.com.advocacia.dto.ValidandoCampos;


@RestControllerAdvice
public class TratamentoDeErros {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<MensagemDeErros>oabDuplicado(){		
		var erros = new MensagemDeErros(HttpStatus.BAD_REQUEST, "Campos oab,telefone,número do processo ou email já cadastrado");
		return new ResponseEntity<>(erros,HttpStatus.BAD_REQUEST);
		
	}	
	
	
	
    @ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagemDeErros>objetoNaoEncontrado(){
    	var erros = new MensagemDeErros(HttpStatus.BAD_REQUEST, "Objeto não encontrado");   	    	
    	return new ResponseEntity<>(erros,HttpStatus.BAD_REQUEST);
		
	}
    
    
 
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>erroDeValidacao(MethodArgumentNotValidException ex){    	
    	var erros = ex.getFieldErrors();
    	return ResponseEntity.badRequest().body(erros.stream().map(ValidandoCampos::new).toList());
    }
    
  
}
