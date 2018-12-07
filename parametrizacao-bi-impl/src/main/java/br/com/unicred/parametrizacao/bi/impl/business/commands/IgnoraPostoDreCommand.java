package br.com.unicred.parametrizacao.bi.api.v1.commands;

/**
 * 
 * As cooperativas fazem o rateio entre os postos, lançando valores de receita e 
 * despesa pelo posto 90 para retear conforme os critérios.
 * Porém, tem postos que não são mais utilizados então eles saem do rateio.
 * DRE = Demonstração do Resultado do Exercício
 *
 * @author thiago.cabelleira
 */
public class IgnoraPostoDreCommand {
    
    private Integer codigoCooperativa;
    private Integer codigoPosto;

    public IgnoraPostoDreCommand() {
        
    }
    
    public void validate() {
        //TODO realizar validacao
    }
    
    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }
    public void setCodigoCooperativa(Integer codigoCooperativa) {
        this.codigoCooperativa = codigoCooperativa;
    }
    public Integer getCodigoPosto() {
        return codigoPosto;
    }
    public void setCodigoPosto(Integer codigoPosto) {
        this.codigoPosto = codigoPosto;
    }
    


    
    
}
