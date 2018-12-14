package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoRRCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.PeriodoFechamentoRR;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.PeriodoFechamentoRRDAO;


@Service
public class PeriodoFechamentoRRService {

    @Autowired
    private PeriodoFechamentoRRDAO dao;

    public List<PeriodoFechamentoRRCommand> buscaPeriodoFechamentoRR() {
        return dao.buscaPeriodoFechamentoRR();
    }

    public boolean inserirPeriodoFechamentoRR(PeriodoFechamentoRR periodoFechamentoRR) {
        return dao.inserirPeriodoFechamentoRR(periodoFechamentoRR);
    }
}
