package br.com.unicred.parametrizacao.bi.impl.business.commands;

import br.com.unicred.parametrizacao.bi.impl.business.validators.CommandValidator;

public class IndicadorInclusaoCommand {
	
	private Integer codigo;
	private String nome;
	private String periodicidade;
	
	
	public IndicadorInclusaoCommand() {
		
	}
	
	public void validate() {
		CommandValidator<IndicadorInclusaoCommand> validator = 
				new CommandValidator<IndicadorInclusaoCommand>();
		
		validator.validate(this);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
