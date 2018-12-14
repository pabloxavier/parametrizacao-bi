package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.CooperativaCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Cooperativa;

@Repository
public class CooperativaDAO {

    private Logger LOGGER = LoggerFactory.getLogger(CooperativaDAO.class);
    
    private final JdbcTemplate jdbcTemplate;
    
    private static final BeanPropertyRowMapper<CooperativaCommand> ROW_MAPPER = 
            BeanPropertyRowMapper.newInstance(CooperativaCommand.class);
    
    private static final String BUSCA_COOPERATIVAS_SQL = "select cd_coop, sigla, nm_coop, flg_ativo from ods.cooperativa";
    private static final String INSERIR_COOPERATIVA = "insert into dansdjnadkja";
    
    
    @Autowired
    public CooperativaDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CooperativaCommand> buscaCooperativas() {
        return jdbcTemplate.query(BUSCA_COOPERATIVAS_SQL, ROW_MAPPER);
    }
    
    public boolean inserirCooperativa(Cooperativa cooperativa) {
        
        Object params[] = {
            cooperativa.getCdCoop(),
            cooperativa.getNmCoop(),
            cooperativa.getSigla()
        };
        
        Object types[] = {
            Types.INTEGER,
            Types.VARCHAR,
            Types.VARCHAR
        };
        
        try {
            jdbcTemplate.update(INSERIR_COOPERATIVA, params, types);
        } catch (Exception e) {
            LOGGER.error("Erro ao inserir " + cooperativa + ": " + e);
            return false;
        }
        return true;
    }
    
}
