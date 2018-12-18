package br.com.unicred.parametrizacao.bi.impl.business.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.unicred.parametrizacao.bi.impl.business.commands.IgnoraPostoDreCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.IgnoraPostoDre;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.RegistroJaExistenteException;
import br.com.unicred.parametrizacao.bi.impl.business.services.CooperativaService;
import br.com.unicred.parametrizacao.bi.impl.business.services.PostoService;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.IgnoraPostoDreDAO;

@Component
public class IgnoraPostoDreValidator {
    
    private CooperativaService cooperativaService;
    private PostoService postoService;
    private IgnoraPostoDreDAO ignoraPostoDreDAO;
    
    @Autowired    
    public IgnoraPostoDreValidator(CooperativaService cooperativaService, PostoService postoService, IgnoraPostoDreDAO ignoraPostoDreDAO) {
        this.cooperativaService = cooperativaService;
        this.postoService = postoService;
        this.ignoraPostoDreDAO = ignoraPostoDreDAO;
    }

    public void validateInsert(IgnoraPostoDreCommand comando) {      
        existeCoop(comando);
        existePosto(comando);
        previneUnicidade(comando.getCodigoCooperativa(), comando.getCodigoPosto());
    }
    
    public void validateDelete(IgnoraPostoDreCommand comando) {      
        if (!existeRegistro(comando.getCodigoCooperativa(), comando.getCodigoPosto())) {
            throw new NotFoundException("O posto " + comando.getCodigoPosto() + " com cooperativa " + comando.getCodigoCooperativa() + " não foi encontrado base de postos ignorados.");
        }
    }

    public void existeCoop(IgnoraPostoDreCommand comando) {
        cooperativaService.getCooperativaById(comando.getCodigoCooperativa());
    }
    
    public void existePosto(IgnoraPostoDreCommand comando) {
        postoService.getPostoById(comando.getCodigoCooperativa(), comando.getCodigoPosto());
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
