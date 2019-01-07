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

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosEdicaoCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoContasContabeisOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.BadInsertException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.ErroInesperadoException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;

@Repository
public class DefinicaoContasContabeisOrcadoRealizadoProjetosDAO {

    private Logger LOGGER = LoggerFactory.getLogger(DefinicaoContasContabeisOrcadoRealizadoProjetosDAO.class);

    private final JdbcTemplate jdbcTemplate;

    private static final BeanPropertyRowMapper<DefinicaoContasContabeisOrcadoRealizadoProjetos> ROW_MAPPER =
            BeanPropertyRowMapper.newInstance(DefinicaoContasContabeisOrcadoRealizadoProjetos.class);

    private static final String INSERE_CONTA_CONTABIL_SQL = "insert into edw.definicao_contas_contabeis_orcado_realizado_projetos (codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir) values(?, ?, ?, ?)";
    private static final String BUSCA_CONTAS_ATIVAS_SQL = "select id, codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir from edw.definicao_contas_contabeis_orcado_realizado_projetos where excluir = false";
    private static final String BUSCA_CONTAS_INATIVAS_SQL = "select id, codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir from edw.definicao_contas_contabeis_orcado_realizado_projetos where excluir = true";
    private static final String BUSCA_CONTAS_SQL = "select id, codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir from edw.definicao_contas_contabeis_orcado_realizado_projetos";
    private static final String BUSCA_CONTAS_POR_CONTA_ESTRUTURAL_SQL = "select id, codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir from edw.definicao_contas_contabeis_orcado_realizado_projetos where codigo_conta_estrutural = ?";
    private static final String BUSCA_CONTAS_POR_COOPERATIVA_SQL = "select id, codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir from edw.definicao_contas_contabeis_orcado_realizado_projetos where codigo_cooperativa = ?";
    private static final String BUSCA_REGISTRO_SQL = "select id, codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir from definicao_contas_contabeis_orcado_realizado_projetos where id =:id";

    private static final String EDITA_REGISTRO_SQL = "update edw.definicao_contas_contabeis_orcado_realizado_projetos set codigo_cooperativa = ?, comparacao = ?, codigo_conta_estrutural = ? where id = ?";

    private static final String EXCLUI_CONTA_CONTABIL_POR_CONTA_ESTRUTURAL_SQL = "update edw.definicao_contas_contabeis_orcado_realizado_projetos set excluir = true  where codigo_conta_estrutural = ?";
    private static final String EXCLUI_CONTA_CONTABIL_COOPERATIVA_SQL = "update edw.definicao_contas_contabeis_orcado_realizado_projetos set excluir = true where codigo_cooperativa = ?";
    private static final String EXCLUI_CONTA_CONTABIL_POR_ID_SQL = "update edw.definicao_contas_contabeis_orcado_realizado_projetos set excluir = true where id = ?";


    @Autowired
    public DefinicaoContasContabeisOrcadoRealizadoProjetosDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos inserirContaContabil(DefinicaoContasContabeisOrcadoRealizadoProjetos conta) {

        Object params[] = {
                conta.getCodigoCooperativa(),
                conta.getComparacao(),
                conta.getCodigoContaEstrutural(),
                Boolean.FALSE
        };

        int types[] = {
                Types.INTEGER,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.BOOLEAN
        };

        try {
            jdbcTemplate.update(INSERE_CONTA_CONTABIL_SQL, params, types);
            return conta;
        } catch (Exception e) {
            LOGGER.error("Erro ao inserir o registro! "+ e);
            throw new BadInsertException("Não foi possivel inserir conta - " + conta.getCodigoContaEstrutural());
        }

    }

    public boolean editarContaContabil(DefinicaoContasContabeisOrcadoRealizadoProjetosEdicaoCommand comando) {

        Object params[] = {
                comando.getCodigoCooperativa(),
                comando.getComparacao(),
                comando.getCodigoContaEstrutural(),
                comando.getCodigo()
        };

        int types[] = {
                Types.INTEGER,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.INTEGER
        };

        try {
            jdbcTemplate.update(EDITA_REGISTRO_SQL, params, types);
        } catch (Exception e) {
            LOGGER.error("Erro ao atualizar o registro! " + e);
            throw  new NotFoundException();
        }
        return true;
    }

    public boolean excluirContaContabelPorId(Integer id) {

        Object params[] = { id };
        int types[] = { Types.INTEGER };

        try {
            jdbcTemplate.update(EXCLUI_CONTA_CONTABIL_POR_ID_SQL, params, types);
        } catch (Exception e) {
            LOGGER.error("Erro ao excluir o registro! " + e);
            throw  new NotFoundException();
        }
        return true;
    }

    public boolean excluirContaContabelPorContaEstrutural(String codigoContaEstrutural) {

        Object params[] = { codigoContaEstrutural };
        int types[] = { Types.VARCHAR };

        try {
            jdbcTemplate.update(EXCLUI_CONTA_CONTABIL_POR_CONTA_ESTRUTURAL_SQL, params, types);
        } catch (Exception e) {
            LOGGER.error("Erro ao excluir o registro! " + e);
            throw  new NotFoundException();
        }
        return true;
    }

    public boolean excluirContaContabelPorCooperativa(Integer codigoCooperativa) {

        Object params[] = { codigoCooperativa };
        int types[] = { Types.INTEGER };

        try {
            jdbcTemplate.update(EXCLUI_CONTA_CONTABIL_COOPERATIVA_SQL, params, types);
        } catch (Exception e) {
            LOGGER.error("Erro ao excluir o registro! " + e);
            throw  new NotFoundException();
        }
        return true;
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos buscaPorId(Integer id){
        Object params[] = {id};
        int types[] = {Types.INTEGER};

        try {
            return jdbcTemplate.queryForObject(BUSCA_REGISTRO_SQL, params, DefinicaoContasContabeisOrcadoRealizadoProjetos.class);
        } catch (Exception e) {
            LOGGER.error("Erro ao buscar registro pelo identificador!" + e);
            return null;
        }
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> buscarContas() {
        try {
            LOGGER.info("Procurando contas .");
            return jdbcTemplate.query(BUSCA_CONTAS_SQL, ROW_MAPPER);
        } catch (final EmptyResultDataAccessException e) {
            LOGGER.warn("Não foram encontradas contas .", e);
            throw new NotFoundException("Não foram encontradas contas .");
        }
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> buscarContasAtivas() {
        try {
            LOGGER.info("Procurando contas ativas.");
            return jdbcTemplate.query(BUSCA_CONTAS_ATIVAS_SQL, ROW_MAPPER);
        } catch (final EmptyResultDataAccessException e) {
            LOGGER.warn("Não foram encontradas contas ativas.", e);
            throw new NotFoundException("Não foram encontradas contas ativas.");
        }
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> buscarContasInativas() {
        try {
            LOGGER.info("Procurando contas desativadas.");
            return jdbcTemplate.query(BUSCA_CONTAS_INATIVAS_SQL, ROW_MAPPER);
        } catch (final EmptyResultDataAccessException e) {
            LOGGER.warn("Não foram encontradas contas desativadas.", e);
            throw new NotFoundException("Não foram encontradas contas desativadas.");
        }
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> buscarContasPorCooperativa(Integer cdCoop) {
        try {
            LOGGER.info("Procurando contas por cooperativa.");
            return jdbcTemplate.query(BUSCA_CONTAS_POR_COOPERATIVA_SQL,new Object[] {cdCoop}, ROW_MAPPER);
        } catch (final EmptyResultDataAccessException e) {
            LOGGER.warn("Não foram encontradas contas ativas.", e);
            throw new NotFoundException("Não foram encontradas contas nesta cooperativa.");
        } catch (Exception e) {
            LOGGER.error("Erro ao consultar cooperativa "+ e);
            throw new ErroInesperadoException();
        }
    }

    public List<DefinicaoContasContabeisOrcadoRealizadoProjetos> buscarContasPorContaEstrutural(String conta) {
        try {
            LOGGER.info("Procurando contas por conta estrutural.");
            return jdbcTemplate.query(BUSCA_CONTAS_POR_CONTA_ESTRUTURAL_SQL,new Object[] {conta}, ROW_MAPPER);
        } catch (final EmptyResultDataAccessException e) {
            LOGGER.warn("Não foram encontrada esta  conta estrurural.", e);
            throw new NotFoundException("Não foram encontrada esta  conta estrurural.");
        } catch (Exception e) {
            LOGGER.error("Erro ao consultar conta estrutural "+ e);
            throw new ErroInesperadoException();
        }
    }
}
