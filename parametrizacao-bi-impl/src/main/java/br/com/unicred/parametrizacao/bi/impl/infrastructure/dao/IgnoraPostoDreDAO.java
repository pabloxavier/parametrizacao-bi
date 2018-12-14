package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.IgnoraPostoDreCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.IgnoraPostoDre;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.ErroInesperadoException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;

@Repository
public class IgnoraPostoDreDAO {

    private final JdbcTemplate jdbcTemplate;
    private Logger log = LoggerFactory.getLogger(CooperativaDAO.class);
    private static final BeanPropertyRowMapper<IgnoraPostoDre> ROW_MAPPER = BeanPropertyRowMapper.newInstance(IgnoraPostoDre.class);

    private static final String POSTOS_IGNORADOS_SQL = "select codigo_cooperativa, codigo_posto from edw.ignora_posto_dre ";
    private static final String POSTOS_IGNORADOS_BY_COOP_SQL = "select codigo_cooperativa, codigo_posto from edw.ignora_posto_dre WHERE codigo_cooperativa = ? ";
    private static final String POSTO_IGNORADO_BY_COOP_E_POSTO_SQL = "select codigo_cooperativa, codigo_posto from edw.ignora_posto_dre WHERE codigo_cooperativa = ? and codigo_posto = ? limit 1 ";
    private static final String INSERIR_POSTO_IGNORADO_SQL = "insert into edw.ignora_posto_dre (codigo_cooperativa, codigo_posto) values (?, ?) ";
    private static final String EXCLUIR_POSTO_IGNORADO_SQL = "delete from edw.ignora_posto_dre where codigo_cooperativa = ? and codigo_posto = ? ";

    @Autowired
    public IgnoraPostoDreDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<IgnoraPostoDre> buscaPostosIgnorados() {
        try {
            log.info("Procurando postos ignorados.");
            return jdbcTemplate.query(POSTOS_IGNORADOS_SQL, ROW_MAPPER);
        } catch (final EmptyResultDataAccessException e) {
            log.warn("Não foram encontrados postos ignorados.", e);
            throw new NotFoundException("Não foram encontrados postos ignorados.");
        }            
    }

    public List<IgnoraPostoDre> buscaPostosIgnoradosByCoop(Integer cooperativa) {
        log.info(String.format("Procurando postos ignorados da cooperativa %d.", cooperativa));
        List<IgnoraPostoDre> postosIgnoradosList = jdbcTemplate.query(POSTOS_IGNORADOS_BY_COOP_SQL, new Object[] { cooperativa }, ROW_MAPPER);
        
        if (postosIgnoradosList.size() == 0) {
            log.warn(String.format("Não foram encontrados postos ignorados na cooperativa %d.", cooperativa));
            throw new NotFoundException(String.format("Não foram encontrados postos ignorados na cooperativa %d.", cooperativa));
        }
        return postosIgnoradosList;
    }
    
    public IgnoraPostoDre buscaPostoIgnoradoByCoopEPosto(Integer cooperativa, Integer posto) {
        log.info(String.format("Procurando posto %d ignorado na cooperativa %d.", posto, cooperativa));
        return jdbcTemplate.queryForObject(POSTO_IGNORADO_BY_COOP_E_POSTO_SQL, new Object[] { cooperativa, posto }, ROW_MAPPER);
    }

    public IgnoraPostoDre inserirPostoIgnorado(final IgnoraPostoDre ignoraPostoDre) {
        try {
            log.info(String.format("Inserindo posto %d ignorado na cooperativa %d.", ignoraPostoDre.getCodigoPosto(), ignoraPostoDre.getCodigoCooperativa()));
            jdbcTemplate.update(INSERIR_POSTO_IGNORADO_SQL, getParams(ignoraPostoDre), getTypes());
            return ignoraPostoDre;
        } catch (Exception e) {
            log.error(String.format("Erro ao inserir posto %d ignorado para cooperativa %d.", ignoraPostoDre.getCodigoPosto(), ignoraPostoDre.getCodigoCooperativa()) + e);
            throw new ErroInesperadoException();
        }
    }
    
    public void excluirPostoIgnorado(final IgnoraPostoDreCommand comando) {
        try {
            log.info(String.format("Excluindo posto %d ignorado na cooperativa %d.", comando.getCodigoPosto(), comando.getCodigoCooperativa()));
            jdbcTemplate.update(EXCLUIR_POSTO_IGNORADO_SQL, getParams(comando), getTypes());    
        } catch (Exception e) {
            log.error(String.format("Erro ao excluir posto %d ignorado para cooperativa %d.", comando.getCodigoPosto(), comando.getCodigoCooperativa()) + e);
            throw new ErroInesperadoException();
        }
    }

    private Object[] getParams(final IgnoraPostoDre ignoraPostoDre) {
        return new Object[] { ignoraPostoDre.getCodigoCooperativa(), ignoraPostoDre.getCodigoPosto() };
    }
    
    private int[] getTypes() {
        return new int[] { Types.INTEGER, Types.INTEGER };
    }
    
    private Object[] getParams(final IgnoraPostoDreCommand comando) {
        return new Object[] { comando.getCodigoCooperativa(), comando.getCodigoPosto() };
    }
}
