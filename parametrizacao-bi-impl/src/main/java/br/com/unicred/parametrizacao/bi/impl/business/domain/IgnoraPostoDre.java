package br.com.unicred.parametrizacao.bi.impl.business.domain;

import br.com.unicred.parametrizacao.bi.api.v1.commands.IgnoraPostoDreCommand;

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
    
    private IgnoraPostoDre(IgnoraPostoDreCommand comando){
        this.codigoCooperativa = comando.getCodigoCooperativa();
        this.codigoPosto = comando.getCodigoPosto();
    }
    
    public static IgnoraPostoDre criar(IgnoraPostoDreCommand comando){
        comando.validate();
        return new IgnoraPostoDre(comando);
    }
        
    public Integer getCodigoCooperativa() {
        return codigoCooperativa;
    }
    public Integer getCodigoPosto() {
        return codigoPosto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoCooperativa == null) ? 0 : codigoCooperativa.hashCode());
        result = prime * result + ((codigoPosto == null) ? 0 : codigoPosto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IgnoraPostoDre other = (IgnoraPostoDre) obj;
        if (codigoCooperativa == null) {
            if (other.codigoCooperativa != null)
                return false;
        } else if (!codigoCooperativa.equals(other.codigoCooperativa))
            return false;
        if (codigoPosto == null) {
            if (other.codigoPosto != null)
                return false;
        } else if (!codigoPosto.equals(other.codigoPosto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IgnoraPostoDre [codigoCooperativa=" + codigoCooperativa + ", codigoPosto=" + codigoPosto + "]";
    }
    
}
