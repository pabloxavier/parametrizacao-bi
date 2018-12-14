package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoRRCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.PeriodoFechamentoRR;

@Repository
public class PeriodoFechamentoRRDAO {
	
   private Logger LOGGER = LoggerFactory.getLogger(CooperativaDAO.class);

   private final JdbcTemplate jdbcTemplate;
   private static final String BUSCA_PERIODO_FECHAMENTO_RR_SQL = "select data_competencia_ranking_rating, data_ultimo_pocessamento, flag_fechado from edw.periodo_fechamento_ranking_rating";
   private static final String INSERIR_PERIODO_FECHAMENTO_RR = "insert into edw.periodo_fechamento_ranking_rating values (?, ?, ?)";
   
   private static final BeanPropertyRowMapper<PeriodoFechamentoRRCommand> ROW_MAPPER = BeanPropertyRowMapper.newInstance(PeriodoFechamentoRRCommand.class);

   
   @Autowired
   public PeriodoFechamentoRRDAO(final JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
   }

   public List<PeriodoFechamentoRRCommand> buscaPeriodoFechamentoRR() {
       return jdbcTemplate.query(BUSCA_PERIODO_FECHAMENTO_RR_SQL, ROW_MAPPER);
   }
   
   public boolean inserirPeriodoFechamentoRR(PeriodoFechamentoRR periodoFechamentoRR) {
       
       Object params[] = {
    	   periodoFechamentoRR.getDataCompetencia(),
    	   periodoFechamentoRR.getDataUltimoProcessamento(),
    	   periodoFechamentoRR.isFechado()
       };
       
       Object types[] = {
           Types.DATE,
           Types.DATE,
           Types.BOOLEAN
       };
       
       try {
           jdbcTemplate.update(INSERIR_PERIODO_FECHAMENTO_RR, params, types);
       } catch (Exception e) {
           LOGGER.error("Erro ao inserir " + periodoFechamentoRR + ": " + e);
           return false;
       }
       return true;
   }
    
}