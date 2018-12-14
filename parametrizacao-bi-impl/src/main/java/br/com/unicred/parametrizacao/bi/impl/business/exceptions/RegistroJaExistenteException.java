package br.com.unicred.parametrizacao.bi.impl.business.exceptions;

public class RegistroJaExistenteException extends RuntimeException{

    private static final long serialVersionUID = 6471427447783961094L;

    public RegistroJaExistenteException(){
        super("O registro já existe na base de dados.");
    }

    public RegistroJaExistenteException(String message){
        super(message);
    }
}