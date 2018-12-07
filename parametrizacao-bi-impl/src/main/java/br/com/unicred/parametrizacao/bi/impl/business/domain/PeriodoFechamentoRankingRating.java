package br.com.unicred.parametrizacao.bi.impl.business.domain;

import java.time.LocalDate;

public class PeriodoFechamentoRankingRating {

	private LocalDate dataCompetencia;
	private LocalDate dataUltimoProcessamento;
	private boolean isFechado;
	
	protected PeriodoFechamentoRankingRating() {
		
	}

	public LocalDate getDataCompetencia() {
		return dataCompetencia;
	}

	public LocalDate getDataUltimoProcessamento() {
		return dataUltimoProcessamento;
	}

	public boolean isFechado() {
		return isFechado;
	}
	
	
}
