package br.com.unicred.parametrizacao.bi.impl.business.services;

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoContasContabeisOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.DefinicaoContasContabeisOrcadoRealizadoProjetosDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefinicaoContasContabeisOrcadoRealizadoProjetosService {

    @Autowired
    private DefinicaoContasContabeisOrcadoRealizadoProjetosDAO dao;

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listar(){
        return null;
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarPorCooperativa(){
        return null;
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarPorConta(){
        return null;
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> listarContasInativas(){
        return null;
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos consultarPorCooperativa(){
        return null;
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos consultarPorConta(){
        return null;
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos salvarConta(DefinicaoContasContabeisOrcadoRealizadoProjetosCommand command){ return null; }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos editarConta(DefinicaoContasContabeisOrcadoRealizadoProjetosCommand command){ return null; }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos excluir(DefinicaoContasContabeisOrcadoRealizadoProjetosCommand command){ return null; }
}
