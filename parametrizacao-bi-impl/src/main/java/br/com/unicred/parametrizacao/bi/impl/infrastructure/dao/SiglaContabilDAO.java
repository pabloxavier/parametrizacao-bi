package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.SiglaContabilCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.SiglaContabil;

@Repository
public class SiglaContabilDAO {
	
	private final JdbcTemplate jdbcTemplate;
	private static final String BUSCA_SIGLA_CONTABIL_SQL = "select codigo, sigla_contabil siglaContabil, ordem from edw.sigla_contabil;";

	private static final BeanPropertyRowMapper<SiglaContabil> ROW_MAPPER = BeanPropertyRowMapper.newInstance(SiglaContabil.class);
	
	@Autowired
    public SiglaContabilDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public List<SiglaContabil> buscaSiglasContabeis() {
		return jdbcTemplate.query(BUSCA_SIGLA_CONTABIL_SQL, ROW_MAPPER);
    }
	
}
