package br.com.unicred.parametrizacao.bi.impl.business.exceptions;

public class ErroInesperadoException extends RuntimeException{

    private static final long serialVersionUID = 6471427447783961094L;

    public ErroInesperadoException(){
        super("Ocorreu um erro inesperado. Entre em contato com o suporte.");
    }

    public ErroInesperadoException(String message){
        super(message);
    }
}