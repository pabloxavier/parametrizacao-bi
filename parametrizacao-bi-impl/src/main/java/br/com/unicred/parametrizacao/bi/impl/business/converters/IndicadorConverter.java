package br.com.unicred.parametrizacao.bi.impl.business.converters;

import br.com.unicred.parametrizacao.bi.api.v1.representation.IndicadorRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Indicador;
import br.com.unicred.parametrizacao.bi.impl.business.dto.IndicadorDTO;

import java.util.List;
import java.util.stream.Collectors;

public class IndicadorConverter {
    
    public static Indicador fromDTO(IndicadorDTO indicador){
        return Indicador.create(indicador);
    }

    public static List<Indicador> fromDTO(List<IndicadorDTO> indicadores){
        return indicadores
                .stream()
                .map(item -> fromDTO(item))
                .collect(Collectors.toList());
    }

    public static IndicadorRepresentation from(Indicador indicador) {
        IndicadorRepresentation indicadorRepresentation = new IndicadorRepresentation();
        indicadorRepresentation.setCodigo(indicador.getCodigo());
        indicadorRepresentation.setNome(indicador.getNome());
        indicadorRepresentation.setPeriodicidade(indicador.getPeriodicidade().toString());
        return indicadorRepresentation;
    }

    public static List<IndicadorRepresentation> from(List<Indicador> indicadores) {
        return indicadores
                .stream()
                .map(item -> from(item))
                .collect(Collectors.toList());
    }
}
