package br.com.unicred.parametrizacao.bi.impl.business.commands;

public class SiglaContabilCommand {
	
	private Integer codigo;
	private String siglaContabil;
	private Integer ordem;
	
	protected SiglaContabilCommand() {
		
	}
	
	public void validate() {
        //TODO realizar validacao
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
