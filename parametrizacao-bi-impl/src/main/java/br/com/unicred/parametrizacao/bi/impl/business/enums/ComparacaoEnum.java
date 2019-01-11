package br.com.unicred.parametrizacao.bi.impl.business.enums;

public enum ComparacaoEnum {
    LIKE("LIKE"),
    IGUAL("=");
    
    private String descricao;
    
    private ComparacaoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
