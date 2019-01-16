package br.com.unicred.parametrizacao.bi.impl.business.converters;

import java.util.List;
import java.util.stream.Collectors;

import br.com.unicred.parametrizacao.bi.api.v1.representation.DefinicaoCentrosCustosOrcadoRealizadoProjetosRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoCentrosCustosOrcadoRealizadoProjetos;

public class DefinicaoCentrosCustosOrcadoRealizadoProjetosConverter {
    
    public static DefinicaoCentrosCustosOrcadoRealizadoProjetosRepresentation from(DefinicaoCentrosCustosOrcadoRealizadoProjetos dominio){
        
        DefinicaoCentrosCustosOrcadoRealizadoProjetosRepresentation model = new DefinicaoCentrosCustosOrcadoRealizadoProjetosRepresentation();
        model.setCodigoCooperativa(dominio.getCodigoCooperativa());
        model.setComparacao(dominio.getComparacao());
        model.setCodigoPosto(dominio.getCodigoPosto());
        //String isExcluido = null == dominio.getExcluir() ? "" : BooleanConverter.booleanToPalavra(dominio.getExcluir());
        model.setIsExcluido(BooleanConverter.booleanToPalavra(dominio.getExcluir()));

        return model;
    }
    
    public static List<DefinicaoCentrosCustosOrcadoRealizadoProjetosRepresentation> from(List<DefinicaoCentrosCustosOrcadoRealizadoProjetos> dominio){
        return dominio
               .stream()
               .map(item -> from(item))
               .collect(Collectors.toList());
    }
}
