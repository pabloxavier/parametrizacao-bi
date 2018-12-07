package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.PostoCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.Posto;

@Repository
public class PostoDAO {

    private Logger LOGGER = LoggerFactory.getLogger(PostoDAO.class);
    
    private final JdbcTemplate jdbcTemplate;
    
    private static final BeanPropertyRowMapper<PostoCommand> ROW_MAPPER = 
            BeanPropertyRowMapper.newInstance(PostoCommand.class);
    
    private static final String BUSCA_POSTOS_SQL = "select cd_coop, cd_posto, sigla_posto, nm_posto, flg_ativo from ods.posto";
    private static final String INSERIR_POSTO = "";
    
    
    @Autowired
    public PostoDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PostoCommand> buscaPostos() {
        return jdbcTemplate.query(BUSCA_POSTOS_SQL, ROW_MAPPER);
    }
    
    public boolean inserirPosto(Posto posto) {
        
        Object params[] = {
            posto.getCdCoop(),
            posto.getCdPosto(),
            posto.getSiglaPosto(),
            posto.getNmPosto(),
            posto.getFlgAtivo()
        };
        
        Object types[] = {
            Types.INTEGER,
            Types.VARCHAR,
            Types.VARCHAR
        };
        
        try {
            jdbcTemplate.update(INSERIR_POSTO, params, types);
        } catch (Exception e) {
            LOGGER.error("Erro ao inserir " + posto + ": " + e);
            return false;
        }
        return true;
    }
    
}
