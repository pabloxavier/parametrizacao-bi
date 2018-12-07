package br.com.unicred.parametrizacao.bi.impl.business.domain;

public class Cooperativa {
    
    private Integer cdCoop; 
    private String sigla;
    private String nmCoop;

    public Integer getCdCoop() {
        return cdCoop;
    }

    public void setCdCoop(Integer cdCoop) {
        this.cdCoop = cdCoop;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNmCoop() {
        return nmCoop;
    }

    public void setNmCoop(String nmCoop) {
        this.nmCoop = nmCoop;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdCoop == null) ? 0 : cdCoop.hashCode());
        result = prime * result + ((nmCoop == null) ? 0 : nmCoop.hashCode());
        result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
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
        Cooperativa other = (Cooperativa) obj;
        if (cdCoop == null) {
            if (other.cdCoop != null)
                return false;
        } else if (!cdCoop.equals(other.cdCoop))
            return false;
        if (nmCoop == null) {
            if (other.nmCoop != null)
                return false;
        } else if (!nmCoop.equals(other.nmCoop))
            return false;
        if (sigla == null) {
            if (other.sigla != null)
                return false;
        } else if (!sigla.equals(other.sigla))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cooperativa [cdCoop=" + cdCoop + ", sigla=" + sigla + ", nmCoop=" + nmCoop + "]";
    }
    
}
