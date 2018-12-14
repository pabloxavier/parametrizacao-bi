package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Posto;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.BadRequestException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;

@Repository
public class PostoDAO {

    private Logger log = LoggerFactory.getLogger(PostoDAO.class);
    private final JdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<Posto> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Posto.class);
    
    private static final String POSTO_SQL = "select cd_coop, cd_posto, sigla_posto, nm_posto, flg_ativo from ods.posto where 1 = 1 ";
    private static final String POSTO_BY_ID_SQL = "select cd_coop, cd_posto, sigla_posto, nm_posto, flg_ativo from ods.posto where cd_coop = ? and cd_posto = ?  limit 1";
    
    @Autowired
    public PostoDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Posto> buscaPostos(final Integer cooperativa, final Integer posto, final Boolean inAtivos) {
        try {
            log.warn("Procurando postos.");
            String filterCooperativa = cooperativa != null ? " AND cd_coop = " + cooperativa : "";
            String filterPosto = posto != null ? " AND cd_posto = " + posto : "";
            String filterAtivos = inAtivos ? " AND flg_ativo = 'S' " : "";
            
            return jdbcTemplate.query(POSTO_SQL + filterCooperativa + filterPosto + filterAtivos, ROW_MAPPER);     
            
        } catch (final EmptyResultDataAccessException e) {
            log.warn("Não foi encontrado nenhum posto.");
            throw new NotFoundException("Não foi encontrado nenhum posto.");
        } catch (final Exception e) {
            log.error("Erro ao buscar postos.", e);
            throw new BadRequestException(null);
        }
    }

    public Posto getPostoByPostoAndCoop(final Integer cooperativa, final Integer posto) {
        try {
            log.info(String.format("Procurando posto %d da cooperativa %d.", posto, cooperativa));
            return jdbcTemplate.queryForObject(POSTO_BY_ID_SQL, new Object[] { cooperativa, posto }, ROW_MAPPER);            
        } catch (final EmptyResultDataAccessException e) {
            log.warn(String.format("Não foi encontrado o posto %d" , posto));
            throw new NotFoundException(String.format("Não foi encontrado o posto %d da cooperativa %d.", posto, cooperativa));
        } catch (final Exception e) {
            log.error(String.format("Erro ao buscar posto %d da cooperativa %d.", posto, cooperativa), e);
            throw new BadRequestException(null);
        }
    }
    
}
