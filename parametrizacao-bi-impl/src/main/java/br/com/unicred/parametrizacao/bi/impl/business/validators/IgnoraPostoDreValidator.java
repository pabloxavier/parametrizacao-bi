package br.com.unicred.parametrizacao.bi.impl.business.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unicred.parametrizacao.bi.impl.business.commands.IgnoraPostoDreCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.IgnoraPostoDre;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RegistroJaExistenteException;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.IgnoraPostoDreDAO;

@Component
public class IgnoraPostoDreValidator {
    
    private CooperativaValidator cooperativaValidator;
    private PostoValidator postoValidator;
    private IgnoraPostoDreDAO ignoraPostoDreDAO;
    
    @Autowired    
    public IgnoraPostoDreValidator(CooperativaValidator cooperativaValidator, PostoValidator postoValidator, IgnoraPostoDreDAO ignoraPostoDreDAO) {
        this.cooperativaValidator = cooperativaValidator;
        this.postoValidator = postoValidator;
        this.ignoraPostoDreDAO = ignoraPostoDreDAO;
    }

    public void validateInsert(IgnoraPostoDreCommand comando) {      
        cooperativaValidator.existeCoop(comando.getCodigoCooperativa());
        postoValidator.existePosto(comando.getCodigoCooperativa(), comando.getCodigoPosto());
        previneUnicidade(comando.getCodigoCooperativa(), comando.getCodigoPosto());
    }
    
    public void validateDelete(IgnoraPostoDreCommand comando) {      
        if (!existeRegistro(comando.getCodigoCooperativa(), comando.getCodigoPosto())) {
            throw new NotFoundException("O posto " + comando.getCodigoPosto() + " com cooperativa " + comando.getCodigoCooperativa() + " não foi encontrado base de postos ignorados.");
        }
    }
    
    public void previneUnicidade(final Integer cooperativa, final Integer posto) {
        if (existeRegistro(cooperativa, posto)) {
            throw new RegistroJaExistenteException("Já existe posto " + posto + " ignorado para cooperativa " + cooperativa);
        }
    }
    
    public Boolean existeRegistro(final Integer cooperativa, final Integer posto) {
        IgnoraPostoDre postoIgnorado = ignoraPostoDreDAO.buscaPostoIgnoradoByCoopEPosto(cooperativa, posto);
        return postoIgnorado == null ? Boolean.FALSE : Boolean.TRUE;
    }

}
