package br.com.unicred.parametrizacao.bi.impl.business.converters;

import java.util.List;
import java.util.stream.Collectors;

import br.com.unicred.parametrizacao.bi.api.v1.representation.IgnoraPostoDreRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.domain.IgnoraPostoDre;

public class IgnoraPostoDreConverter {
    
    public static IgnoraPostoDreRepresentation from(IgnoraPostoDre dominio){
        
        IgnoraPostoDreRepresentation model = new IgnoraPostoDreRepresentation();
        model.setCodigoCooperativa(dominio.getCodigoCooperativa());
        model.setCodigoPosto(dominio.getCodigoPosto());

        return model;
    }
    
    public static List<IgnoraPostoDreRepresentation> from(List<IgnoraPostoDre> dominio){
        return dominio
               .stream()
               .map(item -> from(item))
               .collect(Collectors.toList());
    }
}
