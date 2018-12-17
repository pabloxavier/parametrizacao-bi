package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Posto;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.ErroInesperadoException;

@Repository
public class PostoDAO {

    private Logger log = LoggerFactory.getLogger(PostoDAO.class);
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<Posto> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Posto.class);
    
    private static final String POSTO_SQL = "select cd_coop, cd_posto, sigla_posto, nm_posto, flg_ativo from ods.posto where 1 = 1 ";
    private static final String POSTO_BY_ID_SQL = "select cd_coop, cd_posto, sigla_posto, nm_posto, flg_ativo from ods.posto where cd_coop = :cdCoop and cd_posto = :cdPosto  limit 1";

    @Autowired
    public PostoDAO(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Posto> buscaPostos(final Integer cdCoop, final Integer cdPosto, final Boolean inAtivos) {
        try {
            log.warn("Procurando postos.");
            String filterCoop = cdCoop != null ? " AND cd_coop = " + cdCoop : "";
            String filterPosto = cdPosto != null ? " AND cd_posto = " + cdPosto : "";
            String filterAtivos = inAtivos ? " AND flg_ativo = 'S' " : "";
            return jdbcTemplate.query(POSTO_SQL + filterCoop + filterPosto + filterAtivos, ROW_MAPPER);     
        } catch (final Exception e) {
            throw new ErroInesperadoException("Erro ao buscar postos.", e);
        }
    }

    public Posto getPostoByPostoAndCoop(final Integer cdCoop, final Integer cdPosto) {
        try {
            log.info(String.format("Procurando posto %d da cooperativa %d.", cdPosto, cdCoop));
            List<Posto> result = jdbcTemplate.query(POSTO_BY_ID_SQL, getParams(cdCoop, cdPosto), ROW_MAPPER);     
            return result.isEmpty() ? null : result.get(0);
        } catch (final Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao buscar posto %d da cooperativa %d.", cdPosto, cdCoop), e);
        }
    }

    private MapSqlParameterSource getParams(Integer cdCoop, Integer cdPosto) {
        return new MapSqlParameterSource("cdCoop", cdCoop)
                               .addValue("cdPosto", cdPosto);
    }
    
}
