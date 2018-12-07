package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.api.v1.commands.CooperativaCommand;

@Repository
public class CooperativaDAO {

    private final JdbcTemplate jdbcTemplate;
    private static final String BUSCA_COOPERATIVAS_SQL = "select cd_coop, sigla, nm_coop from ods.cooperativa";
    
    private static final BeanPropertyRowMapper<CooperativaCommand> ROW_MAPPER = BeanPropertyRowMapper.newInstance(CooperativaCommand.class);
    
    @Autowired
    public CooperativaDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CooperativaCommand> buscaCooperativas(Integer cooperativa) {
        return jdbcTemplate.query(BUSCA_COOPERATIVAS_SQL, ROW_MAPPER);
    }
}
