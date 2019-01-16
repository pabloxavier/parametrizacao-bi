package br.com.unicred.parametrizacao.bi.impl.business.enums;

import java.util.Arrays;
import java.util.Optional;

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
 
    public static ComparacaoEnum getById(String id) {
        Optional<ComparacaoEnum> indFormaTrans = 
                Arrays.stream(ComparacaoEnum.values())
                .filter(e -> e.getDescricao().equals(id.toUpperCase()))
                .findFirst();
        if (indFormaTrans.isPresent()) {
            return indFormaTrans.get();
        }
        return null;
    } 

}
