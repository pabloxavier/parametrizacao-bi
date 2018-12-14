package br.com.unicred.parametrizacao.bi.impl.business.converters;

import java.util.List;
import java.util.stream.Collectors;

import br.com.unicred.parametrizacao.bi.api.v1.representation.CooperativaRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;

public class CooperativaConverter {
    
    public static CooperativaRepresentation from(Cooperativa dominio){
        
        CooperativaRepresentation model = new CooperativaRepresentation();
        model.setCodigoCooperativa(dominio.getCdCoop());
        model.setNomeCooperativa(dominio.getNmCoop().trim());
        model.setSiglaCooperativa(dominio.getSigla().trim());
        model.setAtivo(BooleanConverter.letraToPalavra(dominio.getFlgAtivo()));

        return model;
    }
    
    public static List<CooperativaRepresentation> from(List<Cooperativa> dominio){
        return dominio
               .stream()
               .map(item -> from(item))
               .collect(Collectors.toList());
    }
}
