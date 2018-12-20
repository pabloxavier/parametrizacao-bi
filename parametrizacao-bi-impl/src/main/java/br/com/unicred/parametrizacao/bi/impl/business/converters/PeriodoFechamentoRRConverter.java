package br.com.unicred.parametrizacao.bi.impl.business.converters;

import java.util.List;
import java.util.stream.Collectors;

import br.com.unicred.parametrizacao.bi.api.v1.representation.PeriodoFechamentoRRRepresentation;
import br.com.unicred.parametrizacao.bi.impl.business.domain.PeriodoFechamentoRR;

public class PeriodoFechamentoRRConverter {
	
	public static PeriodoFechamentoRRRepresentation from(PeriodoFechamentoRR dominio) {
		
		PeriodoFechamentoRRRepresentation model = new PeriodoFechamentoRRRepresentation();
		model.setDataCompetenciaRankingRating(dominio.getDataCompetenciaRankingRating());
		model.setDataUltimoPocessamento(dominio.getDataUltimoPocessamento());
		model.setPeriodoFechado(dominio.getFlagFechado());
		
		return model;
	}
	
    public static List<PeriodoFechamentoRRRepresentation> from(List<PeriodoFechamentoRR> dominio){
        return dominio
               .stream()
               .map(item -> from(item))
               .collect(Collectors.toList());
    }

}