package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoPPRCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.PeriodoFechamentoPPR;

@Repository
public class PeriodoFechamentoPPRDAO {
	
   private Logger LOGGER = LoggerFactory.getLogger(CooperativaDAO.class);

   private final JdbcTemplate jdbcTemplate;
   private static final String BUSCA_PERIODO_FECHAMENTO_RR_SQL = "select data_competencia_ranking_rating, data_ultimo_pocessamento, flag_fechado from edw.periodo_fechamento_ranking_rating";
   private static final String INSERIR_PERIODO_FECHAMENTO_RR = "insert into edw.periodo_fechamento_ranking_rating values (?, ?, ?)";
   
   private static final BeanPropertyRowMapper<PeriodoFechamentoPPRCommand> ROW_MAPPER = BeanPropertyRowMapper.newInstance(PeriodoFechamentoPPRCommand.class);

   
   @Autowired
   public PeriodoFechamentoPPRDAO(final JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
   }

   public List<PeriodoFechamentoPPRCommand> buscaPeriodoFechamentoPPR() {
       return jdbcTemplate.query(BUSCA_PERIODO_FECHAMENTO_RR_SQL, ROW_MAPPER);
   }
   
   public boolean inserirPeriodoFechamentoPPR(PeriodoFechamentoPPR periodoFechamentoPPR) {
       
       Object params[] = {
    	   periodoFechamentoPPR.getDtCompetencia(),
    	   periodoFechamentoPPR.getDtUltProcessamento(),
    	   periodoFechamentoPPR.isFechado()
       };
       
       Object types[] = {
           Types.DATE,
           Types.DATE,
           Types.BOOLEAN
       };
       
       try {
           jdbcTemplate.update(INSERIR_PERIODO_FECHAMENTO_RR, params, types);
       } catch (Exception e) {
           LOGGER.error("Erro ao inserir " + periodoFechamentoPPR + ": " + e);
           return false;
       }
       return true;
   }
    
}