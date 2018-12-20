package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.sql.Types;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PeriodoFechamentoRRCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.PeriodoFechamentoRR;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.BadRequestException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.ErroInesperadoException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;

@Repository
public class PeriodoFechamentoRRDAO {
    
  private Logger log = LoggerFactory.getLogger(PeriodoFechamentoRRDAO.class);

  private final JdbcTemplate jdbcTemplate;
  private static final String BUSCA_PERIODO_FECHAMENTO_RR_SQL = "select data_competencia_ranking_rating, data_ultimo_pocessamento, flag_fechado from edw.periodo_fechamento_ranking_rating";
  private static final String BUSCA_PERIODO_FECHAMENTO_RR_POR_DATA_SQL = "select data_competencia_ranking_rating, data_ultimo_pocessamento, flag_fechado from edw.periodo_fechamento_ranking_rating where data_competencia_ranking_rating = ?";
  private static final String EXCLUIR_PERIODO_FECHAMENTO_RR_POR_DATA_SQL = "delete from edw.periodo_fechamento_ranking_rating where data_competencia_ranking_rating = ?";
  private static final String INSERIR_PERIODO_FECHAMENTO_RR = "insert into edw.periodo_fechamento_ranking_rating (data_competencia_ranking_rating, data_ultimo_pocessamento, flag_fechado) values (?, ?, ?)";

  private static final BeanPropertyRowMapper<PeriodoFechamentoRR> ROW_MAPPER = BeanPropertyRowMapper.newInstance(PeriodoFechamentoRR.class);


  @Autowired
  public PeriodoFechamentoRRDAO(final JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
  }

  public List<PeriodoFechamentoRR> buscaPeriodoFechamentoRR() {
      try {
          log.info("Procurando períodos de fechamento.");
          return jdbcTemplate.query(BUSCA_PERIODO_FECHAMENTO_RR_SQL, ROW_MAPPER);
      } catch (final EmptyResultDataAccessException e) {
          log.warn("Não foram encontrados períodos");
          throw new NotFoundException("Não foram encontrados períodos.");
      }     
  }
  
  public PeriodoFechamentoRR buscaPeriodoFechamentoRRporData(final LocalDate data) {
      try {
    	  log.info(String.format("Procurando período de fechamento %d", data));
          return jdbcTemplate.queryForObject(BUSCA_PERIODO_FECHAMENTO_RR_POR_DATA_SQL, new Object[] { data }, ROW_MAPPER);            
      } catch (final EmptyResultDataAccessException e) {
          log.warn(String.format("Não foi encontrado o período %d" , data));
          throw new NotFoundException(String.format("Não foi encontrado o período %d.", data));
      } catch (final Exception e) {
          log.error(String.format("Erro ao buscar período %d.", data), e);
          throw new BadRequestException(null);
      }
  }

  public void excluirPeriodoFechamentoRR(final PeriodoFechamentoRRCommand comando) {
      try {
          log.info(String.format("Excluindo período %d.", comando.getDataCompetenciaRankingRating()));
          jdbcTemplate.update(EXCLUIR_PERIODO_FECHAMENTO_RR_POR_DATA_SQL, getParams(comando), getTypes());    
      } catch (Exception e) {
          log.error(String.format("Erro ao excluir o período.", comando.getDataCompetenciaRankingRating()) + e);
          throw new ErroInesperadoException();
      }
  } 
  
  
  public PeriodoFechamentoRR inserirPeriodoFechamentoRR(PeriodoFechamentoRR periodoFechamentoRR) {

      try {
          log.info(String.format("Inserindo período %d.", periodoFechamentoRR.getDataCompetenciaRankingRating()));
          jdbcTemplate.update(INSERIR_PERIODO_FECHAMENTO_RR, getParams(periodoFechamentoRR), getTypes());
          return periodoFechamentoRR;
      } catch (Exception e) {
          log.error(String.format("Erro ao inserir período %d.", periodoFechamentoRR.getDataCompetenciaRankingRating()) + e);
          throw new ErroInesperadoException();
      }
	  
  }
  
  private Object[] getParams(final PeriodoFechamentoRR periodoFechamentoRR) {
      return new Object[] { periodoFechamentoRR.getDataCompetenciaRankingRating() };
  }
  
  private int[] getTypes() {
      return new int[] { Types.DATE };
  }
  
  private Object[] getParams(final PeriodoFechamentoRRCommand comando) {
      return new Object[] { comando.getDataCompetenciaRankingRating() };
  }
}