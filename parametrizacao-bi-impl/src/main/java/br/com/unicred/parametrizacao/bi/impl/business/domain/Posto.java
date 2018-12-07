package br.com.unicred.parametrizacao.bi.impl.business.domain;

public class Posto {
    
    private Integer cdCoop; 
    private Integer cdPosto; 
    private String siglaPosto;
    private String nmPosto;
    private String flgAtivo;
    
    public Integer getCdCoop() {
        return cdCoop;
    }
    public Integer getCdPosto() {
        return cdPosto;
    }
    public String getSiglaPosto() {
        return siglaPosto;
    }
    public String getNmPosto() {
        return nmPosto;
    }
    public String getFlgAtivo() {
        return flgAtivo;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cdCoop == null) ? 0 : cdCoop.hashCode());
        result = prime * result + ((cdPosto == null) ? 0 : cdPosto.hashCode());
        result = prime * result + ((flgAtivo == null) ? 0 : flgAtivo.hashCode());
        result = prime * result + ((nmPosto == null) ? 0 : nmPosto.hashCode());
        result = prime * result + ((siglaPosto == null) ? 0 : siglaPosto.hashCode());
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
        Posto other = (Posto) obj;
        if (cdCoop == null) {
            if (other.cdCoop != null)
                return false;
        } else if (!cdCoop.equals(other.cdCoop))
            return false;
        if (cdPosto == null) {
            if (other.cdPosto != null)
                return false;
        } else if (!cdPosto.equals(other.cdPosto))
            return false;
        if (flgAtivo == null) {
            if (other.flgAtivo != null)
                return false;
        } else if (!flgAtivo.equals(other.flgAtivo))
            return false;
        if (nmPosto == null) {
            if (other.nmPosto != null)
                return false;
        } else if (!nmPosto.equals(other.nmPosto))
            return false;
        if (siglaPosto == null) {
            if (other.siglaPosto != null)
                return false;
        } else if (!siglaPosto.equals(other.siglaPosto))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Posto [cdCoop=" + cdCoop + ", cdPosto=" + cdPosto + ", siglaPosto=" + siglaPosto + ", nmPosto="
                + nmPosto + ", flgAtivo=" + flgAtivo + "]";
    }
    
}
