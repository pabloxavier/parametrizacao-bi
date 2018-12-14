package br.com.unicred.parametrizacao.bi.api.v1.representation;

import java.time.LocalDate;

public class PeriodoFechamentoPPRRepresentation {

	private LocalDate dataCompetencia;
    private LocalDate dataUltimoProcessamento;
    private boolean isFechado;
    
    public LocalDate getDataCompetencia() {
		return dataCompetencia;
	}
    
	public void setDataCompetencia(LocalDate dataCompetencia) {
		this.dataCompetencia = dataCompetencia;
	}
    
	public LocalDate getDataUltimoProcessamento() {
		return dataUltimoProcessamento;
	}
	
	public void setDataUltimoProcessamento(LocalDate dataUltimoProcessamento) {
		this.dataUltimoProcessamento = dataUltimoProcessamento;
	}
	
	public boolean isFechado() {
		return isFechado;
	}
	
	public void setFechado(boolean isFechado) {
		this.isFechado = isFechado;
	}
}
