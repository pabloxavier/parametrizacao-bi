package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoRRCommand;

public class PeriodoFechamentoRRDAO {

   private final JdbcTemplate jdbcTemplate;
   private static final String BUSCA_PERIODO_FECHAMENTO_RR_SQL = "select data_competencia_ranking_rating, data_ultimo_pocessamento, flag_fechado from edw.periodo_fechamento_ranking_rating";

   private static final BeanPropertyRowMapper<PeriodoFechamentoRRCommand> ROW_MAPPER = BeanPropertyRowMapper.newInstance(PeriodoFechamentoRRCommand.class);

   
   @Autowired
   public PeriodoFechamentoRRDAO(final JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
   }

   public List<PeriodoFechamentoRRCommand> buscaPeriodoFechamentoRR(Integer periodo_fechamento_ranking_rating) {
       return jdbcTemplate.query(BUSCA_PERIODO_FECHAMENTO_RR_SQL, ROW_MAPPER);
   }
    
}