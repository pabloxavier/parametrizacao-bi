package br.com.unicred.parametrizacao.bi.impl.business.domain;

import java.time.LocalDate;
import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoPPRCommand;

public class PeriodoFechamentoPPR {

	private LocalDate dataCompetencia;
	private LocalDate dataUltProcessamento;
	private boolean isFechado;
	
	protected PeriodoFechamentoPPR() {
		
	}
	
	private PeriodoFechamentoPPR (PeriodoFechamentoPPRCommand comando) {
		this.dataCompetencia = comando.getDataCompetencia();
		this.dataUltProcessamento = comando.getDataUltimoProcessamento();
		this.isFechado = comando.isFechado();		
	}	
	
	public static PeriodoFechamentoPPR criar(PeriodoFechamentoPPRCommand comando){
	    comando.validate();
	    return new PeriodoFechamentoPPR(comando);
	}
	
	public LocalDate getDtCompetencia() {
		return dataCompetencia;
	}
	public LocalDate getDtUltProcessamento() {
		return dataUltProcessamento;
	}
	public boolean isFechado() {
		return isFechado;
	}
	
	
	
}
