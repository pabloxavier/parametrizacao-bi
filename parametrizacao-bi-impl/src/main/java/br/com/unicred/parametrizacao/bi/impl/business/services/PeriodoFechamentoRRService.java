package br.com.unicred.parametrizacao.bi.impl.business.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoRRCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.PeriodoFechamentoRR;
import br.com.unicred.parametrizacao.bi.impl.business.validators.PeriodoFechamentoRRValidator;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.dao.PeriodoFechamentoRRDAO;

@Service
public class PeriodoFechamentoRRService {


    private PeriodoFechamentoRRDAO dao;
    private PeriodoFechamentoRRValidator validator;

    @Autowired
    public PeriodoFechamentoRRService(PeriodoFechamentoRRDAO periodoFechamentoDAO, PeriodoFechamentoRRValidator validator) {
        this.dao = periodoFechamentoDAO;
        this.validator = validator;
    }
    
    public List<PeriodoFechamentoRR> buscaPeriodoFechamentoRR() {
        return dao.buscaPeriodoFechamentoRR();
    }

    public PeriodoFechamentoRR buscaPeriodoFechamentoRRporData(final LocalDate data) {
        return dao.buscaPeriodoFechamentoRRporData(data);
    }

    
    public PeriodoFechamentoRR inserirPeriodoFechamentoRR(PeriodoFechamentoRR periodoFechamentoRR) {
        return dao.inserirPeriodoFechamentoRR(periodoFechamentoRR);
    }
    
    public PeriodoFechamentoRR inserirPeriodoFechamentoRR(final PeriodoFechamentoRRCommand comando) {
        validator.validateInsert(comando);
        
        PeriodoFechamentoRR periodoFechamentoRR = PeriodoFechamentoRR.criar(comando);
        dao.inserirPeriodoFechamentoRR(periodoFechamentoRR);
        return periodoFechamentoRR;
    }
    
    public String excluirPeriodoFechamentoRR(final PeriodoFechamentoRRCommand comando) {
        validator.validateDelete(comando);
        
        dao.excluirPeriodoFechamentoRR(comando);
        return String.format("Período %d excluído com sucesso.", comando.getDataCompetenciaRankingRating());
    }    
    
}
