package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import br.com.unicred.parametrizacao.bi.impl.business.converters.IndicadorConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.domain.Indicador;
import br.com.unicred.parametrizacao.bi.impl.business.dto.IndicadorDTO;

import java.util.List;

@Repository
public class IndicadorDAO {

    private Logger LOGGER = LoggerFactory.getLogger(IndicadorDAO.class);

    private final JdbcTemplate jdbcTemplate;

    private static final BeanPropertyRowMapper<IndicadorDTO> ROW_MAPPER_DTO =
            BeanPropertyRowMapper.newInstance(IndicadorDTO.class);

    private static final String BUSCA_INDICADORES_SQL = "select chave, nome_indicador, periodicidade from edw.indicador order by nome_indicador";

    @Autowired
    public IndicadorDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Indicador> buscaIndicadores() {
        return IndicadorConverter.fromDTO(jdbcTemplate.query(BUSCA_INDICADORES_SQL, ROW_MAPPER_DTO));
    }
    
}
