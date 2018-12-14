package br.com.unicred.parametrizacao.bi.impl.business.services;

import br.com.unicred.parametrizacao.bi.impl.business.domain.CentrosCustosOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.CentrosCustosOrcadRealizadoProjetosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentrosCustosOrcadoRealizadoProjetosService {
    private CentrosCustosOrcadRealizadoProjetosDAO dao;

    @Autowired
    public CentrosCustosOrcadoRealizadoProjetosService(CentrosCustosOrcadRealizadoProjetosDAO dao) {
        this.dao = dao;
    }

    public List<CentrosCustosOrcadoRealizadoProjetos> buscarTodos(){
        return dao.buscarTodos();
    }
}
