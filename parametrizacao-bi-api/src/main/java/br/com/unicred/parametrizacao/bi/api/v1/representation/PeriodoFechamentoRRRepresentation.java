package br.com.unicred.parametrizacao.bi.api.v1.representation;

import java.time.LocalDate;

public class PeriodoFechamentoRRRepresentation {
	
	private LocalDate dataCompetenciaRankingRating;
	private LocalDate dataUltimoProcessamento;
	private String flagFechado;

	public LocalDate getDataCompetenciaRankingRating() {
		return dataCompetenciaRankingRating;
	}
	public void setDataCompetenciaRankingRating(LocalDate dataCompetenciaRankingRating) {
		this.dataCompetenciaRankingRating = dataCompetenciaRankingRating;
	}
	public LocalDate getDataUltimoProcessamento() {
		return dataUltimoProcessamento;
	}
	public void setDataUltimoProcessamento(LocalDate dataUltimoProcessamento) {
		this.dataUltimoProcessamento = dataUltimoProcessamento;
	}
	public String getFlagFechado() {
		return flagFechado;
	}
	public void setFlagFechado(String flagFechado) {
		this.flagFechado = flagFechado;
	}

}