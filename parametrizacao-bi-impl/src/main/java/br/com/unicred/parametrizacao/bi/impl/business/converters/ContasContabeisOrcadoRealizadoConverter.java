package br.com.unicred.parametrizacao.bi.impl.business.converters;

import java.util.List;
import java.util.stream.Collectors;

import br.com.unicred.parametrizacao.bi.api.v1.representation.ContasContabeisOrcadoRealizadoRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.domain.ContasContabeisOrcadoRealizado;

public class ContasContabeisOrcadoRealizadoConverter {
    
    public static ContasContabeisOrcadoRealizadoRepresentation from(ContasContabeisOrcadoRealizado dominio){
        
        ContasContabeisOrcadoRealizadoRepresentation model = new ContasContabeisOrcadoRealizadoRepresentation();
        model.setCodigoCooperativa(dominio.getCodigoCooperativa());
        model.setCodigoContaEstrutural(dominio.getCodigoContaEstrutural());

        return model;
    }
    
    public static List<ContasContabeisOrcadoRealizadoRepresentation> from(List<ContasContabeisOrcadoRealizado> dominio){
        return dominio
               .stream()
               .map(item -> from(item))
               .collect(Collectors.toList());
    }
}
