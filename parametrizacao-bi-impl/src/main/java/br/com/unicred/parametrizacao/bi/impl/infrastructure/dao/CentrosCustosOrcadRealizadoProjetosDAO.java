package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import br.com.unicred.parametrizacao.bi.impl.business.domain.CentrosCustosOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.BadRequestException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CentrosCustosOrcadRealizadoProjetosDAO {

    private Logger log = LoggerFactory.getLogger(CentrosCustosOrcadRealizadoProjetosDAO.class);
    private final JdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<CentrosCustosOrcadoRealizadoProjetos> ROW_MAPPER = BeanPropertyRowMapper.newInstance(CentrosCustosOrcadoRealizadoProjetos.class);
    private static final String CENTOS_CUSTOS_ORCADO_REALIZADO_PROJETOS_SQL = "SELECT codigo_cooperativa, codigo_posto FROM edw.centros_custos_orcado_realizado_projetos WHERE 1 = 1 ";

    @Autowired
    public CentrosCustosOrcadRealizadoProjetosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CentrosCustosOrcadoRealizadoProjetos> buscarTodos(){
        try {
            log.info("Bucando centros custos orçados realizados por projetos.");
            return jdbcTemplate.query(CENTOS_CUSTOS_ORCADO_REALIZADO_PROJETOS_SQL , ROW_MAPPER);
        }catch (final EmptyResultDataAccessException e) {
            log.warn("Nenhum centro custo orçado realizado por projetos foi encontrado.");
            throw new NotFoundException("Nenhuma cooperativa foi encontrada.");
        } catch (final Exception e) {
            log.error("Erro ao buscar centros custos orçados realizados por projetos.", e);
            throw new BadRequestException(null);
        }
    }
}
