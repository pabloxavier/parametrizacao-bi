package br.com.unicred.parametrizacao.bi.api.v1.representation;

import java.time.LocalDate;

public class PeriodoFechamentoRRRepresentation {
	
	private LocalDate dataCompetenciaRankingRating;
	private LocalDate dataUltimoPocessamento;
	private String periodoFechado;

	public LocalDate getDataCompetenciaRankingRating() {
		return dataCompetenciaRankingRating;
	}
	public void setDataCompetenciaRankingRating(LocalDate dataCompetenciaRankingRating) {
		this.dataCompetenciaRankingRating = dataCompetenciaRankingRating;
	}
	public LocalDate getDataUltimoPocessamento() {
		return dataUltimoPocessamento;
	}
	public void setDataUltimoPocessamento(LocalDate dataUltimoPocessamento) {
		this.dataUltimoPocessamento = dataUltimoPocessamento;
	}
	public String getPeriodoFechado() {
		return periodoFechado;
	}
	public void setPeriodoFechado(String periodoFechado) {
		this.periodoFechado = periodoFechado;
	}

}