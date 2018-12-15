package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import br.com.unicred.parametrizacao.bi.impl.business.commands.CentrosCustosOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.CentrosCustosOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.BadRequestException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.ErroInesperadoException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class CentrosCustosOrcadoRealizadoProjetosDAO {

    private Logger log = LoggerFactory.getLogger(CentrosCustosOrcadoRealizadoProjetosDAO.class);
    private final JdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<CentrosCustosOrcadoRealizadoProjetos> ROW_MAPPER = BeanPropertyRowMapper.newInstance(CentrosCustosOrcadoRealizadoProjetos.class);
    private static final String CENTROS_CUSTOS_ORCADO_REALIZADO_PROJETOS_SQL = "SELECT codigo_cooperativa, codigo_posto FROM edw.centros_custos_orcado_realizado_projetos WHERE 1 = 1 ";
    private static final String INSERT_COMMAND_VALUES = " INSERT INTO edw.centros_custos_orcado_realizado_projetos (codigo_cooperativa, codigo_posto) VALUES " ;
    private static final String UPDATE_COMMAND = " UPDATE edw.centros_custos_orcado_realizado_projetos SET ";
    private static final String DELETE_COMMAND = " DELETE FROM edw.centros_custos_orcado_realizado_projetos ";

    @Autowired
    public CentrosCustosOrcadoRealizadoProjetosDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CentrosCustosOrcadoRealizadoProjetos> buscarTodos(){
        try {
            log.info("Bucando centros custos orçados realizados por projetos.");
            return jdbcTemplate.query(CENTROS_CUSTOS_ORCADO_REALIZADO_PROJETOS_SQL , ROW_MAPPER);
        }catch (final EmptyResultDataAccessException e) {
            log.warn("Nenhum centro custo orçado realizado por projetos foi encontrado.");
            throw new NotFoundException("Nenhum centro custo orçado realizado por projetos foi encontrado.");
        } catch (final Exception e) {
            log.error("Erro ao buscar centros custos orçados realizados por projetos.", e);
            throw new BadRequestException(null);
        }
    }

    public List<CentrosCustosOrcadoRealizadoProjetos> buscarByCooperativa(Integer cooperativa){
        try {
            log.info("Bucando centros custos orçados realizados por projetos por cooperativa.");
            String sql = CENTROS_CUSTOS_ORCADO_REALIZADO_PROJETOS_SQL + " AND codigo_cooperativa = ? ";
            return jdbcTemplate.query(sql, new Object[] { cooperativa },ROW_MAPPER);
        }catch (final EmptyResultDataAccessException e) {
            log.warn("Nenhum centro custo orçado realizado por projetos foi encontrado.");
            throw new NotFoundException("Nenhum centro custo orçado realizado por projetos foi encontrado.");
        } catch (final Exception e) {
            log.error("Erro ao buscar centros custos orçados realizados por projetos.", e);
            throw new BadRequestException(null);
        }
    }


    public List<CentrosCustosOrcadoRealizadoProjetos> buscarByPosto(Integer posto){
        try {
            log.info("Bucando centros custos orçados realizados por projetos por posto.");
            String sql = CENTROS_CUSTOS_ORCADO_REALIZADO_PROJETOS_SQL + " AND codigo_posto = ? ";
            return jdbcTemplate.query(sql, new Object[] { posto },ROW_MAPPER);
        }catch (final EmptyResultDataAccessException e) {
            log.warn("Nenhum centro custo orçado realizado por projetos foi encontrado.");
            throw new NotFoundException("Nenhum centro de custo orçado realizado por projeto foi encontrado.");
        } catch (final Exception e) {
            log.error("Erro ao buscar centros custos orçados realizados por projetos.", e);
            throw new BadRequestException(null);
        }
    }

    public CentrosCustosOrcadoRealizadoProjetos buscarByCooperativaEPosto(Integer cooperativa, Integer posto){
        try {
            log.info("Bucando centros custos orçados realizados por projetos por cooperativa e posto.");
            String sql = CENTROS_CUSTOS_ORCADO_REALIZADO_PROJETOS_SQL
                    + " AND codigo_cooperativa = ?"
                    + " AND codigo_posto = ? ";
            return jdbcTemplate.queryForObject(sql, new Object[] { cooperativa, posto }, ROW_MAPPER);
        } catch (final Exception e) {
            log.error("Erro ao buscar centros custos orçados realizados por projetos.", e);
            throw new BadRequestException(null);
        }
    }

    public Boolean isCentroCustoExistsPorCooperativaEPosto(Integer cooperativa, Integer posto){
            try {
                log.info("Bucando centros custos orçados realizados por projetos por cooperativa e posto.");
                String sql = CENTROS_CUSTOS_ORCADO_REALIZADO_PROJETOS_SQL
                        + " AND codigo_cooperativa = ?"
                        + " AND codigo_posto = ? ";
                CentrosCustosOrcadoRealizadoProjetos result = jdbcTemplate.queryForObject(sql, new Object[]{cooperativa, posto}, ROW_MAPPER);
                if (result != null){
                    return Boolean.TRUE;
                }
            } catch (final EmptyResultDataAccessException e){
                return Boolean.FALSE;
            }
        return Boolean.FALSE;
    }

    public CentrosCustosOrcadoRealizadoProjetos inserir(CentrosCustosOrcadoRealizadoProjetos domain){
        try{
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            String sql = INSERT_COMMAND_VALUES
                         + " (?, ?)";
            log.debug("SQL: {} Params: {}", sql, parameters);
            jdbcTemplate.update(sql, getParams(domain), getTypes());
            return domain;
        } catch (Exception e){
            log.error(String.format("Erro ao inserir centro custo orcado realizado projetos  %d.", domain.getCodigoPosto(), domain.getCodigoCooperativa()) + e);
            throw new ErroInesperadoException();
        }
    }

    public CentrosCustosOrcadoRealizadoProjetos atualizar(CentrosCustosOrcadoRealizadoProjetos domain, Integer cooperativa, Integer posto){
        try{
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            String sql = UPDATE_COMMAND
                    + " codigo_cooperativa = ?, codigo_posto = ? "
                    + "  WHERE codigo_cooperativa = " + cooperativa
                    + "  AND codigo_posto = " + posto;
            log.debug("SQL: {} Params: {}", sql, parameters);
            jdbcTemplate.update(sql, getParams(domain), getTypes());
            return domain;
        } catch (Exception e){
            log.error(String.format("Erro ao atualizar centro custo orcado realizado projetos %d.", domain.getCodigoPosto(), domain.getCodigoCooperativa()) + e);
            throw new ErroInesperadoException();
        }
    }

    public CentrosCustosOrcadoRealizadoProjetos excluir(CentrosCustosOrcadoRealizadoProjetos domain){
        try{
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            String sql = DELETE_COMMAND
                    + " WHERE codigo_cooperativa = ? "
                    + " AND codigo_posto = ? ";
            log.debug("SQL: {} Params: {}", sql, parameters);
            jdbcTemplate.update(sql, getParams(domain), getTypes());
            return domain;
        } catch (Exception e){
            log.error(String.format("Erro ao excluir centro custo orcado realizado projetos %d.", domain.getCodigoPosto(), domain.getCodigoCooperativa()) + e);
            throw new ErroInesperadoException();
        }
    }

    private Object[] getParams(final CentrosCustosOrcadoRealizadoProjetos domain) {
        return new Object[] { domain.getCodigoCooperativa(), domain.getCodigoPosto() };
    }

    private int[] getTypes() {
        return new int[] { Types.INTEGER, Types.INTEGER };
    }

    private Object[] getParams(final CentrosCustosOrcadoRealizadoProjetosCommand comando) {
        return new Object[] { comando.getCodigoCooperativa(), comando.getCodigoPosto() };
    }
}
