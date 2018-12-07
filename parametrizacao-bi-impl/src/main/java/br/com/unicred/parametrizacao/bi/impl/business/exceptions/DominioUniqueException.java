package br.com.unicred.parametrizacao.bi.impl.business.exceptions;

public class DominioUniqueException extends RuntimeException{

    private static final long serialVersionUID = 6471427447783961094L;

    public DominioUniqueException(){
        super("DomÃ­nio jÃ¡ existe");
    }

    public DominioUniqueException(String message){
        super(message);
    }
}