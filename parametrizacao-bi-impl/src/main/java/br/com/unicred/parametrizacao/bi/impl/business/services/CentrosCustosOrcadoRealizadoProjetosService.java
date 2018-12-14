package br.com.unicred.parametrizacao.bi.impl.business.services;

import br.com.unicred.parametrizacao.bi.impl.business.commands.CentrosCustosOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.CentrosCustosOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.CentrosCustosOrcadoRealizadoProjetosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentrosCustosOrcadoRealizadoProjetosService {
    private CentrosCustosOrcadoRealizadoProjetosDAO dao;

    @Autowired
    public CentrosCustosOrcadoRealizadoProjetosService(CentrosCustosOrcadoRealizadoProjetosDAO dao) {
        this.dao = dao;
    }

    public List<CentrosCustosOrcadoRealizadoProjetos> buscarTodos(){
        return dao.buscarTodos();
    }

    public CentrosCustosOrcadoRealizadoProjetos salvar(CentrosCustosOrcadoRealizadoProjetosCommand comando){
        // TODO VALIDATOR
        CentrosCustosOrcadoRealizadoProjetos centrosCustosOrcadoRealizadoProjetos = CentrosCustosOrcadoRealizadoProjetos.criar(comando);
        return dao.inserir(centrosCustosOrcadoRealizadoProjetos);
    }

}
