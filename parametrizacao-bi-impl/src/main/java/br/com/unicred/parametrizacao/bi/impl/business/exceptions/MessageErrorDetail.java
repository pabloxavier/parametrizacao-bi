package br.com.unicred.parametrizacao.bi.impl.business.exceptions;

public class MessageErrorDetail  {

    private String field;
    private String message;

    public MessageErrorDetail (String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return this.field;
    }

    public String getMessage() {
        return this.message;
    }
}
