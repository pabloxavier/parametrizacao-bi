package br.com.unicred.parametrizacao.bi.impl.business.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotFoundException extends RuntimeException{
    private Logger log = LoggerFactory.getLogger(NotFoundException.class);
    private static final String MSG = "Nenhum registro encontrado.";

    public NotFoundException(){
        super(MSG);
        log.info(MSG);
    }
    
    public NotFoundException(String message){
        super(message);
        log.info(message);
    }
}
