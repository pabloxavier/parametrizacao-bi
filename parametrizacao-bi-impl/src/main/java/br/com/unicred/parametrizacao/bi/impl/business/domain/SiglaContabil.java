package br.com.unicred.parametrizacao.bi.impl.business.domain;

import br.com.unicred.parametrizacao.bi.api.v1.commands.SiglaContabilInclusao;

public class SiglaContabil {

	private Integer codigo;
	private String siglaContabil;
	private Integer ordem;
	
	protected SiglaContabil() {
		
	}
	
	private SiglaContabil(SiglaContabilInclusao comando) {
		this.codigo = comando.getCodigo();
		this.siglaContabil = comando.getSiglaContabil();
		this.ordem = comando.getOrdem();
	}
	
	public static SiglaContabil criar(SiglaContabilInclusao comando) {
		comando.validate();
		return new SiglaContabil(comando);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getSiglaContabil() {
		return siglaContabil;
	}

	public Integer getOrdem() {
		return ordem;
	}
	
	
	
	
	
}
