package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PlanoFgCoopBrasilCommand;

@Repository
public class PlanoFgCoopBrasilDAO {

    private final JdbcTemplate jdbcTemplate;
    private static final String BUSCA_CONTA_BACEN_SQL = "select codigo_conta_bacen, descricao_conta_bacen from edw.plano_fg_coop_brasil";
    
    private static final BeanPropertyRowMapper<PlanoFgCoopBrasilCommand> ROW_MAPPER = BeanPropertyRowMapper.newInstance(PlanoFgCoopBrasilCommand.class);
    
    @Autowired
    public PlanoFgCoopBrasilDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PlanoFgCoopBrasilCommand> buscaContaBacen(String contaBacen) {
        return jdbcTemplate.query(BUSCA_CONTA_BACEN_SQL, ROW_MAPPER);
    }
}

