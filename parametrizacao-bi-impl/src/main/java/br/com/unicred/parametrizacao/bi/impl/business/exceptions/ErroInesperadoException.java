package br.com.unicred.parametrizacao.bi.impl.business.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErroInesperadoException extends RuntimeException{

    private Logger log = LoggerFactory.getLogger(ErroInesperadoException.class);
    private static final String ERRO = "Ocorreu um erro inesperado. Entre em contato com o suporte.";

    public ErroInesperadoException(){
        super(ERRO);
        log.error(ERRO);
    }
    
    public ErroInesperadoException(String message, Exception e){
        super(String.format("%s %s", ERRO, message));
        log.error(String.format("%s %s: %s", ERRO, message, e));
    }
}