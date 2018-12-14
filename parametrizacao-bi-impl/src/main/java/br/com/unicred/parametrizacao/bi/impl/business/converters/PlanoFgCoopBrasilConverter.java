package br.com.unicred.parametrizacao.bi.impl.business.converters;

import java.util.List;
import java.util.stream.Collectors;

import br.com.unicred.parametrizacao.bi.api.v1.representation.PlanoFgCoopBrasilRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.domain.PlanoFgCoopBrasil;

public class PlanoFgCoopBrasilConverter {

    public static PlanoFgCoopBrasilRepresentation from(PlanoFgCoopBrasil dominio){
        
    	PlanoFgCoopBrasilRepresentation model = new PlanoFgCoopBrasilRepresentation();
        model.setCodigoContaBacen(dominio.getCodigoContaBacen());
        model.setDescricaoContaBacen(dominio.getDescricaoContaBacen());

        return model;
    }
    
    public static List<PlanoFgCoopBrasilRepresentation> from(List<PlanoFgCoopBrasil> dominio){
        return dominio
               .stream()
               .map(item -> from(item))
               .collect(Collectors.toList());
    }

}
