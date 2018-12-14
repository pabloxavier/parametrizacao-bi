package br.com.unicred.parametrizacao.bi.api.v1.representation;

public class IndicadorRepresentation {

    private Integer codigo;
    private String nome;
    private String periodicidade;


    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPeriodicidade() {
        return periodicidade;
    }
    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }
    
}
