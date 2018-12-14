package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.BadRequestException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;

@Repository
public class CooperativaDAO {

    private Logger log = LoggerFactory.getLogger(CooperativaDAO.class);
    private final JdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<Cooperativa> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Cooperativa.class);
    private static final String COOPERATIVA_SQL = "select cd_coop, sigla, nm_coop, flg_ativo from ods.cooperativa where 1 = 1 ";
    
    @Autowired
    public CooperativaDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cooperativa> buscaCooperativas(final Boolean inAtivos) {
        try {
            log.info("Procurando cooperativas.");
            String filter = inAtivos ? " AND flg_ativo = 'S' " : "";
            return jdbcTemplate.query(COOPERATIVA_SQL + filter, ROW_MAPPER);
        } catch (final EmptyResultDataAccessException e) {
            log.warn("Nenhuma cooperativa foi encontrada.");
            throw new NotFoundException("Nenhuma cooperativa foi encontrada.");
        } catch (final Exception e) {
            log.error("Erro ao buscar cooperativas.", e);
            throw new BadRequestException(null);
        }            
    }
    
    public Cooperativa getCooperativaById(final Integer cooperativa) {
        try {
            log.info(String.format("Procurando cooperativa %d.", cooperativa));
            String filter = " AND cd_coop = ? ";
            return jdbcTemplate.queryForObject(COOPERATIVA_SQL + filter, getParams(cooperativa), ROW_MAPPER);            
        } catch (final EmptyResultDataAccessException e) {
            log.warn(String.format("Não foi encontrada a cooperativa %d.", cooperativa), e);
            throw new NotFoundException("Não foi encontrada a cooperativa " + cooperativa);
        } catch (final Exception e) {
            log.error(String.format("Erro ao buscar cooperativa %d.", cooperativa), e);
            throw new BadRequestException(null);
        }
    } 
    
    private Object[] getParams(final Integer cooperativa) {
        return new Object[] { cooperativa };
    }
    
}
