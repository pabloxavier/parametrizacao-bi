package br.com.unicred.parametrizacao.bi.impl.business.commands;

import br.com.unicred.parametrizacao.bi.impl.business.validators.CommandValidator;

public class IndicadorEdicaoCommand {
	
	private String nome;
	private String periodicidade;
	
	
	public IndicadorEdicaoCommand() {
		
	}
	
	public void validate() {
		CommandValidator<IndicadorEdicaoCommand> validator = 
				new CommandValidator<IndicadorEdicaoCommand>();
		
		validator.validate(this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(String periodicidade) {
		this.periodicidade = periodicidade;
	}
	
	

}
