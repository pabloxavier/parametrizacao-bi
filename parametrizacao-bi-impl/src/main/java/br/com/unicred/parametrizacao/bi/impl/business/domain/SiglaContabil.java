package br.com.unicred.parametrizacao.bi.impl.business.domain;

import org.springframework.stereotype.Component;

import br.com.unicred.parametrizacao.bi.impl.business.commands.SiglaContabilCommand;

@Component
public class SiglaContabil {

	private Integer codigo;
	private String siglaContabil;
	private Integer ordem;
	
	protected SiglaContabil() {
		
	}
	
	private SiglaContabil(SiglaContabilCommand comando) {
		this.codigo = comando.getCodigo();
		this.siglaContabil = comando.getSiglaContabil();
		this.ordem = comando.getOrdem();
	}
	
	public static SiglaContabil criar(SiglaContabilCommand comando) {
		comando.validate();
		return new SiglaContabil(comando);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getSiglaContabil() {
		return siglaContabil;
	}

	public void setSiglaContabil(String siglaContabil) {
		this.siglaContabil = siglaContabil;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	
}
