package br.com.unicred.parametrizacao.bi.impl.business.domain;

import br.com.unicred.parametrizacao.bi.api.v1.commands.IgnoraPostoDreInclusao;

/**
 * 
 * As cooperativas fazem o rateio entre os postos, lançando valores de receita e 
 * despesa pelo posto 90 para retear conforme os critérios.
 * Porém, tem postos que não são mais utilizados então eles saem do rateio.
 * DRE = Demonstração do Resultado do Exercício
 *
 * @author thiago.cabelleira
 */
public class IgnoraPostoDre {
    
    private Integer codigoCooperativa;
    private Integer codigoPosto;
    
    protected IgnoraPostoDre(){
        
    }
    
    private IgnoraPostoDre(IgnoraPostoDreInclusao comando){
        this.codigoCooperativa = comando.getCodigoCooperativa();
        this.codigoPosto = comando.getCodigoPosto();
    }
    
    public static IgnoraPostoDre criar(IgnoraPostoDreInclusao comando){
        comando.validate();
        return new IgnoraPostoDre(comando);
    }
        
    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }
    public Integer getCodigoPosto() {
        return codigoPosto;
    }

    
    
}