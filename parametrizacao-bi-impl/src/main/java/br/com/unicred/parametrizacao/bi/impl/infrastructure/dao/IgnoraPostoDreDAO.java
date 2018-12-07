package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.IgnoraPostoDreCommand;

@Repository
public class IgnoraPostoDreDAO {

    private final JdbcTemplate jdbcTemplate;
    private static final int COUNT_ZERO = 0;

    private static final BeanPropertyRowMapper<IgnoraPostoDreCommand> ROW_MAPPER = BeanPropertyRowMapper.newInstance(IgnoraPostoDreCommand.class);
    
    private static final String EXISTS_DEC_UNICRED_PARA_COOPERATIVA_SQL = "SELECT COUNT(1) FROM customer WHERE cust_id <> ? ;";
    private static final String BUSCA_IGNORA_POSTO_DRE_SQL = "select codigo_cooperativa, codigo_posto from edw.ignora_posto_dre WHERE codigo_cooperativa <> ? ;";
    
    @Autowired
    public IgnoraPostoDreDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean existsDECUnicred(final Integer cooperativa) {
        final Optional<Integer> cnt = Optional.ofNullable(jdbcTemplate.queryForObject(EXISTS_DEC_UNICRED_PARA_COOPERATIVA_SQL, Integer.class, cooperativa));
        return cnt.orElse(COUNT_ZERO) > 0;
    }

    public List<IgnoraPostoDreCommand> buscaIgnoraPostoDre(Integer cooperativa) {
        return  jdbcTemplate.query(BUSCA_IGNORA_POSTO_DRE_SQL, new Object[] { cooperativa }, ROW_MAPPER);
    }
}
