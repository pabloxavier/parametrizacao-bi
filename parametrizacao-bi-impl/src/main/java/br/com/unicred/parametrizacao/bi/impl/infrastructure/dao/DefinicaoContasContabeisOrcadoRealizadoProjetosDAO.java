package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoContasContabeisOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.BadInsertException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.BadRequestException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.MessageErrorDetail;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class DefinicaoContasContabeisOrcadoRealizadoProjetosDAO {

    private Logger LOGGER = LoggerFactory.getLogger(DefinicaoContasContabeisOrcadoRealizadoProjetosDAO.class);

    private final JdbcTemplate jdbcTemplate;

    private static final BeanPropertyRowMapper<DefinicaoContasContabeisOrcadoRealizadoProjetos> ROW_MAPPER =
            BeanPropertyRowMapper.newInstance(DefinicaoContasContabeisOrcadoRealizadoProjetos.class);

    private static final String INSERE_CONTA_CONTABIL_SQL = "insert edw.into definicao_contas_contabeis_orcado_realizado_projetos (codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir) values(:codigo_cooperativa,:comparacao,:codigo_conta_estrutural, false)";

    private static final String BUSCA_CONTAS_ATIVAS_SQL = "select id, codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir from edw.definicao_contas_contabeis_orcado_realizado_projetos where excluir = false";
    private static final String BUSCA_CONTAS_POR_CONTA_SQL = "select id, codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir from definicao_contas_contabeis_orcado_realizado_projetos where codigo_conta_estrutural =:codigo_conta_estrutural";
    private static final String BUSCA_CONTAS_POR_COOPERATIVA_SQL = "select id, codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir from definicao_contas_contabeis_orcado_realizado_projetos where codigo_cooperativa =:codigo_cooperativa";
    private static final String BUSCA_REGISTRO_SQL = "select id, codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir from definicao_contas_contabeis_orcado_realizado_projetos where id =:id";

    private static final String EDITA_REGISTRO_SQL = "update definicao_contas_contabeis_orcado_realizado_projetos set codigo_cooperativa =:codigo_cooperativa, comparacao =:comparacao, codigo_conta_estrutural =:codigo_conta_estrutural where id =:id";

    private static final String EXCLUI_CONTA_CONTABIL_POR_CONTA_SQL = "delete from definicao_contas_contabeis_orcado_realizado_projetos where codigo_conta_estrutural =:codigo_conta_estrutural";
    private static final String EXCLUI_CONTA_CONTABIL_COOPERATIVA_SQL = "delete from definicao_contas_contabeis_orcado_realizado_projetos where codigo_cooperativa =:codigo_cooperativa";
    private static final String EXCLUI_CONTA_CONTABIL_POR_ID_SQL = "delete from definicao_contas_contabeis_orcado_realizado_projetos where id =:id";


    @Autowired
    public DefinicaoContasContabeisOrcadoRealizadoProjetosDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos inserirContaContabil(DefinicaoContasContabeisOrcadoRealizadoProjetos conta) {

        Object params[] = {
                conta.getCodigoContaEstrutural(),
                conta.getComparacao(),
                conta.getCodigoContaEstrutural()
        };

        Object types[] = {
                Types.INTEGER,
                Types.VARCHAR,
                Types.VARCHAR
        };

        try {
            jdbcTemplate.update(INSERE_CONTA_CONTABIL_SQL, params, types);
            return conta;
        } catch (Exception e) {
            LOGGER.error("Erro ao inserir o registro! "+ e);
            throw new BadInsertException("Não foi possivel inserir conta - " + conta.getCodigoContaEstrutural());
        }

    }

    public boolean editarContaContabil(DefinicaoContasContabeisOrcadoRealizadoProjetosCommand comando, Integer id) {

        Object params[] = {
                comando.getCodigoCooperativa(),
                comando.getComparacao(),
                comando.getCodigoContaEstrutural(),
                id
        };

        Object types[] = {
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
        Object types[] = { Types.INTEGER };

        try {
            jdbcTemplate.update(EXCLUI_CONTA_CONTABIL_POR_ID_SQL, params, types);
        } catch (Exception e) {
            LOGGER.error("Erro ao excluir o registro! " + e);
            return false;
        }
        return true;
    }

    public boolean excluirContaContabelPorConta(String codigoContaEstrutural) {

        Object params[] = { codigoContaEstrutural };
        Object types[] = { Types.VARCHAR };

        try {
            jdbcTemplate.update(EXCLUI_CONTA_CONTABIL_POR_CONTA_SQL, params, types);
        } catch (Exception e) {
            LOGGER.error("Erro ao excluir o(s) registro(s) da conta! " + e);
            return false;
        }
        return true;
    }

    public boolean excluirContaContabelPorCooperativa(Integer codigoCooperativa) {

        Object params[] = { codigoCooperativa };
        Object types[] = { Types.INTEGER };

        try {
            jdbcTemplate.update(EXCLUI_CONTA_CONTABIL_COOPERATIVA_SQL, params, types);
        } catch (Exception e) {
            LOGGER.error("Erro ao excluir o(s) registro(s) da cooperativa! " + e);
            return false;
        }
        return true;
    }

    public DefinicaoContasContabeisOrcadoRealizadoProjetos buscaPorId(Integer id){
        Object params[] = {id};
        Object types[] = {Types.INTEGER};

        try {
            return jdbcTemplate.queryForObject(BUSCA_REGISTRO_SQL, params, DefinicaoContasContabeisOrcadoRealizadoProjetos.class);
        } catch (Exception e) {
            LOGGER.error("Erro ao buscar registro pelo identificador!" + e);
            return null;
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
}
