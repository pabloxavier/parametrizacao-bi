package br.com.unicred.parametrizacao.bi.impl.business.converters;

import br.com.unicred.parametrizacao.bi.api.v1.representation.DefinicaoContasContabeisOrcadoRealizadoProjetosRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoContasContabeisOrcadoRealizadoProjetos;

import java.util.List;
import java.util.stream.Collectors;


public class DefinicaoContasContabeisOrcadoRealizadoProjetosConverter {

    public static DefinicaoContasContabeisOrcadoRealizadoProjetosRepresentation from(DefinicaoContasContabeisOrcadoRealizadoProjetos dominio){
        DefinicaoContasContabeisOrcadoRealizadoProjetosRepresentation model = new DefinicaoContasContabeisOrcadoRealizadoProjetosRepresentation();
        model.setCodigo(dominio.getId());
        model.setCodigoContaEstrutural(dominio.getCodigoContaEstrutural());
        model.setCodigoCooperativa(dominio.getCodigoCooperativa());
        model.setComparacao(dominio.getComparacao());
        model.setStatus(dominio.getExcluir());
        return model;
}

    public static List<DefinicaoContasContabeisOrcadoRealizadoProjetosRepresentation> from(List<DefinicaoContasContabeisOrcadoRealizadoProjetos> dominio){
        return dominio
                .stream()
                .map(item -> from(item))
                .collect(Collectors.toList());
    }
}
