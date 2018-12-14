package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoPPRCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.PeriodoFechamentoPPR;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.PeriodoFechamentoPPRDAO;


@Service
public class PeriodoFechamentoPPRService {

    @Autowired
    private PeriodoFechamentoPPRDAO dao;

    public List<PeriodoFechamentoPPRCommand> buscaPeriodoFechamentoPPR() {
        return dao.buscaPeriodoFechamentoPPR();
    }

    public boolean inserirPeriodoFechamentoPPR(PeriodoFechamentoPPR periodoFechamentoPPR) {
        return dao.inserirPeriodoFechamentoPPR(periodoFechamentoPPR);
    }
}
