package br.com.unicred.parametrizacao.bi.impl.business.converters;

import br.com.unicred.parametrizacao.bi.api.v1.representation.CentrosCustosOrcadoRealizadoProjetosRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.domain.CentrosCustosOrcadoRealizadoProjetos;

import java.util.List;
import java.util.stream.Collectors;

public class CentrosCustosOrcadoRealizadoProjetosConverter {

    public static CentrosCustosOrcadoRealizadoProjetosRepresentation from(
            CentrosCustosOrcadoRealizadoProjetos dominio){
        CentrosCustosOrcadoRealizadoProjetosRepresentation representation = new CentrosCustosOrcadoRealizadoProjetosRepresentation();
        representation.setCodigoCooperativa(dominio.getCodigoCooperativa());
        representation.setCodigoPosto(dominio.getCodigoPosto());
        return representation;
    }

    public static List<CentrosCustosOrcadoRealizadoProjetosRepresentation> from(List<CentrosCustosOrcadoRealizadoProjetos> listDominio){
        return listDominio
                .stream()
                .map(repres -> from(repres))
                .collect(Collectors.toList());
    }
}
