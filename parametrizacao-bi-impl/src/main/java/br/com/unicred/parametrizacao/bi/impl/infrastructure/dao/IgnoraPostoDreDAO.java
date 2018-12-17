package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.IgnoraPostoDreCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.IgnoraPostoDre;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.ErroInesperadoException;

@Repository
public class IgnoraPostoDreDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private Logger log = LoggerFactory.getLogger(CooperativaDAO.class);
    private static final BeanPropertyRowMapper<IgnoraPostoDre> ROW_MAPPER = BeanPropertyRowMapper.newInstance(IgnoraPostoDre.class);

    private static final String POSTOS_IGNORADOS_SQL = "select codigo_cooperativa, codigo_posto from edw.ignora_posto_dre ";
    private static final String POSTOS_IGNORADOS_BY_COOP_SQL = "select codigo_cooperativa, codigo_posto from edw.ignora_posto_dre WHERE codigo_cooperativa = :cdCoop ";
    private static final String POSTO_IGNORADO_BY_COOP_E_POSTO_SQL = "select codigo_cooperativa, codigo_posto from edw.ignora_posto_dre WHERE codigo_cooperativa = :cdCoop and codigo_posto = :cdPosto limit 1 ";
    private static final String INSERIR_POSTO_IGNORADO_SQL = "insert into edw.ignora_posto_dre (codigo_cooperativa, codigo_posto) values (?, ?) ";
    private static final String EXCLUIR_POSTO_IGNORADO_SQL = "delete from edw.ignora_posto_dre where codigo_cooperativa = ? and codigo_posto = ? ";

    @Autowired
    public IgnoraPostoDreDAO(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<IgnoraPostoDre> buscaPostosIgnorados() {
        try {
            log.info("Procurando postos ignorados.");
            return jdbcTemplate.query(POSTOS_IGNORADOS_SQL, ROW_MAPPER);
        } catch (final Exception e) {
            throw new ErroInesperadoException("Erro ao buscar postos ignorados.", e);
        }         
    }

    public List<IgnoraPostoDre> buscaPostosIgnoradosByCoop(Integer cdCoop) {
        try {
            log.info(String.format("Procurando postos ignorados da cooperativa %d.", cdCoop));
            return jdbcTemplate.query(POSTOS_IGNORADOS_BY_COOP_SQL, getParams(cdCoop), ROW_MAPPER);
        } catch (final Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao buscar postos da cooperativa %d.", cdCoop), e);
        }           
    }

    public IgnoraPostoDre buscaPostoIgnoradoByCoopEPosto(Integer cdCoop, Integer cdPosto) {
        try {
            log.info(String.format("Procurando posto %d ignorado na cooperativa %d.", cdPosto, cdCoop));
            List<IgnoraPostoDre> result = jdbcTemplate.query(POSTO_IGNORADO_BY_COOP_E_POSTO_SQL, getParams(cdCoop, cdPosto), ROW_MAPPER);
            return result.isEmpty() ? null : result.get(0);
        } catch (final Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao buscar posto %d da cooperativa %d.", cdPosto, cdCoop), e);
        }
    }

    public IgnoraPostoDre inserirPostoIgnorado(final IgnoraPostoDre ignoraPostoDre) {
        try {
            log.info(String.format("Inserindo posto %d ignorado na cooperativa %d.", ignoraPostoDre.getCodigoPosto(), ignoraPostoDre.getCodigoCooperativa()));
            jdbcTemplate.update(INSERIR_POSTO_IGNORADO_SQL, getParams(ignoraPostoDre), getTypes());
            return ignoraPostoDre;
        } catch (Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao inserir posto %d ignorado para cooperativa %d.", ignoraPostoDre.getCodigoPosto(), ignoraPostoDre.getCodigoCooperativa()), e);
        }
    }
    
    public void excluirPostoIgnorado(final IgnoraPostoDreCommand comando) {
        try {
            log.info(String.format("Excluindo posto %d ignorado na cooperativa %d.", comando.getCodigoPosto(), comando.getCodigoCooperativa()));
            jdbcTemplate.update(EXCLUIR_POSTO_IGNORADO_SQL, getParams(comando), getTypes());    
        } catch (Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao excluir posto %d ignorado para cooperativa %d.", comando.getCodigoPosto(), comando.getCodigoCooperativa()), e);
        }
    }

    private MapSqlParameterSource getParams(Integer cdCoop) {
        return new MapSqlParameterSource("cdCoop", cdCoop);
    }
    
    private MapSqlParameterSource getParams(Integer cdCoop, Integer cdPosto) {
        return new MapSqlParameterSource("cdCoop", cdCoop)
                               .addValue("cdPosto", cdPosto);
    }    
}
