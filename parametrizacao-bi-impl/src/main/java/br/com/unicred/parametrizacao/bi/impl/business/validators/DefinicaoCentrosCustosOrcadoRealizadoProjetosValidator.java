package br.com.unicred.parametrizacao.bi.impl.business.validators;

import java.util.List;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoCentrosCustosOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.enums.ComparacaoEnum;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RegistroJaExistenteException;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.DefinicaoCentrosCustosOrcadoRealizadoProjetosDAO;

@Component
public class DefinicaoCentrosCustosOrcadoRealizadoProjetosValidator {
    
    private CooperativaValidator cooperativaValidator;
    private PostoValidator postoValidator;
    private DefinicaoCentrosCustosOrcadoRealizadoProjetosDAO dao;
    private static final String MENSAGEM = "Definicao Centros Custos Orcado Realizado Projetos";
    
    @Autowired    
    public DefinicaoCentrosCustosOrcadoRealizadoProjetosValidator(CooperativaValidator cooperativaValidator, PostoValidator postoValidator, DefinicaoCentrosCustosOrcadoRealizadoProjetosDAO dao) {
        this.cooperativaValidator = cooperativaValidator;
        this.postoValidator = postoValidator;
        this.dao = dao;
    }

    public void validateInsertUpdate(DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {      
        cooperativaValidator.existeCoop(comando.getCodigoCooperativa());        
        existeComparacao(comando.getComparacao());
        existePosto(comando);
        previneUnicidade(comando);
    }

    public void validateDelete(DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {      
        if (!existeRegistro(comando)){
            throw new NotFoundException(String.format("Não foi encontrada a %s [%s].", MENSAGEM, comando.toString()));
        }
    }
      
    public void previneUnicidade(DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {
        if (existeRegistro(comando)) {
            throw new RegistroJaExistenteException(String.format("Já existe a %s [%s].", MENSAGEM, comando.toString()));
        }
    }
    
    public Boolean existeRegistro(DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {
        List<DefinicaoCentrosCustosOrcadoRealizadoProjetos> result = dao.listarComFiltros(comando.getCodigoCooperativa(), comando.getComparacao(), comando.getCodigoPosto(), Boolean.FALSE);
        return result.isEmpty() ? Boolean.FALSE : Boolean.TRUE;
    }
    
    private void existePosto(DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando){
        try {
            Integer cdPosto = Integer.valueOf(comando.getCodigoPosto().replace("%", ""));
            postoValidator.existePosto(comando.getCodigoCooperativa(), cdPosto);
        } catch (Exception e) {
            throw new NotFoundException(String.format("Posto %s inválido.", comando.getCodigoPosto())); 
        }
    }
    
    private boolean existeComparacao(String comparacao) {
        try {
            return EnumUtils.isValidEnum(ComparacaoEnum.class, ComparacaoEnum.getById(comparacao).toString());
        } catch (Exception e) {
            throw new NotFoundException(String.format("Comparacao %s inválida.", comparacao));
        }
   }    
    
}
