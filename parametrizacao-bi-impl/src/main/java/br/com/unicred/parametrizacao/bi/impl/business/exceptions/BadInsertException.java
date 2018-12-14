package br.com.unicred.parametrizacao.bi.impl.business.exceptions;

public class BadInsertException extends  RuntimeException{

    public BadInsertException() {
        super();
    }

    public BadInsertException(String message) {
        super(message);
    }
}
