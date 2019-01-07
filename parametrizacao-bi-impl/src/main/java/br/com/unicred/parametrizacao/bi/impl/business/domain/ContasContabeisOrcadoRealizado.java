package br.com.unicred.parametrizacao.bi.impl.business.domain;

import br.com.unicred.parametrizacao.bi.impl.business.commands.ContasContabeisOrcadoRealizadoCommand;

/**
 * @author thiago.cabelleira
 */
public class ContasContabeisOrcadoRealizado {
    
    private Integer codigoCooperativa;
    private String codigoContaEstrutural;
    
    protected ContasContabeisOrcadoRealizado(){
        
    }
    
    private ContasContabeisOrcadoRealizado(ContasContabeisOrcadoRealizadoCommand comando){
        this.codigoCooperativa = comando.getCodigoCooperativa();
        this.codigoContaEstrutural = comando.getCodigoContaEstrutural();
    }
    
    public static ContasContabeisOrcadoRealizado criar(ContasContabeisOrcadoRealizadoCommand comando){
        return new ContasContabeisOrcadoRealizado(comando);
    }

    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }

    public void setCodigoCooperativa(Integer codigoCooperativa) {
        this.codigoCooperativa = codigoCooperativa;
    }

    public String getCodigoContaEstrutural() {
        return codigoContaEstrutural;
    }

    public void setCodigoContaEstrutural(String codigoContaEstrutural) {
        this.codigoContaEstrutural = codigoContaEstrutural;
    }


    
}
