package br.com.unicred.parametrizacao.bi.api.v1.representation;

/**
 * @author thiago.cabelleira
 */
public class ContasContabeisOrcadoRealizadoRepresentation {
    
    private Integer codigoCooperativa;
    private String codigoContaEstrutural;

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
