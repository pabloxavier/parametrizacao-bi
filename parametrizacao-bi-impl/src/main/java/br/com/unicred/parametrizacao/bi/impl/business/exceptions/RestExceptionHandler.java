package br.com.unicred.parametrizacao.bi.impl.business.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException exception){
        String message = exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ErroInesperadoException.class)
    public ResponseEntity<?> handleNotFoundException(ErroInesperadoException exception){
        String message = exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException exception) {

        MessageErrorResponse message = new MessageErrorResponse();

        message.setTitulo("Dados incorretos");

        message.setMessage(exception.getMessage());

        message.setMessages(exception.getErrors());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RegistroJaExistenteException.class)
    public ResponseEntity<?> handleResourceBadRequestExceptionDominio(RegistroJaExistenteException exception) {

        MessageErrorResponse message = new MessageErrorResponse();

        message.setTitulo("Dados incorretos");

        message.setMessage(exception.getMessage());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
