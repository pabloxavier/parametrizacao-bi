package br.com.unicred.parametrizacao.bi.impl.business.exceptions;

import java.util.List;

public class BadRequestException extends RuntimeException {

    private List<MessageErrorDetail> errors;

    public BadRequestException(List<MessageErrorDetail> errors) {
        super("Erros de validaÃ§Ã£o.");
        this.errors = errors;
    }

    public BadRequestException(String message, List<MessageErrorDetail> errors) {
        super(message);
        this.errors = errors;
    }

    public List<MessageErrorDetail> getErrors() {
        return this.errors;
    }
}
