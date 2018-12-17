package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.ErroInesperadoException;

@Repository
public class CooperativaDAO {

    private Logger log = LoggerFactory.getLogger(CooperativaDAO.class);
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<Cooperativa> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Cooperativa.class);
    private static final String COOPERATIVA_SQL = "select cd_coop, sigla, nm_coop, flg_ativo from ods.cooperativa where 1 = 1 ";
    
    @Autowired
    public CooperativaDAO(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cooperativa> buscaCooperativas(final Boolean inAtivos) {
        try {
            log.info("Procurando cooperativas.");
            String filter = inAtivos ? " AND flg_ativo = 'S' " : "";
            return jdbcTemplate.query(COOPERATIVA_SQL + filter, ROW_MAPPER);
        } catch (final Exception e) {
            throw new ErroInesperadoException("Erro ao buscar cooperativas.", e);
        }            
    }

    public Cooperativa getCooperativaById(final Integer cdCoop) {
        try {
            log.info(String.format("Procurando cooperativa %d.", cdCoop));
            String filter = " AND cd_coop = :cdCoop ";
            List<Cooperativa> result = jdbcTemplate.query(COOPERATIVA_SQL + filter, getParams(cdCoop), ROW_MAPPER);
            return result.isEmpty() ? null : result.get(0);
        } catch (final Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao buscar cooperativa %d.", cdCoop), e);
        }
    }
    
    private MapSqlParameterSource getParams(Integer cdCoop) {
        return new MapSqlParameterSource("cdCoop", cdCoop);
    }
    
}
