package br.com.unicred.parametrizacao.bi.impl.infrastructure.utils;

public class ContasContabeisOrcadoRealizadoUtils {
    private static final String MENSAGEM = "contas contabeis orcado realizado";
    private static final String MENSAGEM_PROJETO = "contas contabeis orcado realizado projetos";
    
    public static String defineMensagem(Boolean isProjeto){
        return isProjeto ? MENSAGEM_PROJETO : MENSAGEM;
    } 
}
