package br.com.unicred.parametrizacao.bi.impl.business.converters;

import java.util.List;
import java.util.stream.Collectors;

import br.com.unicred.parametrizacao.bi.api.v1.representation.PostoRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Posto;

public class PostoConverter {
    
    public static PostoRepresentation from(Posto dominio){
        
        PostoRepresentation model = new PostoRepresentation();
        model.setCodigoCooperativa(dominio.getCdCoop());
        model.setCodigoPosto(dominio.getCdPosto());
        model.setNomePosto(dominio.getNmPosto().trim());
        model.setSiglaPosto(dominio.getSiglaPosto().trim());
        model.setAtivo(BooleanConverter.letraToPalavra(dominio.getFlgAtivo()));

        return model;
    }
    
    public static List<PostoRepresentation> from(List<Posto> dominio){
        return dominio
               .stream()
               .map(item -> from(item))
               .collect(Collectors.toList());
    }
}
