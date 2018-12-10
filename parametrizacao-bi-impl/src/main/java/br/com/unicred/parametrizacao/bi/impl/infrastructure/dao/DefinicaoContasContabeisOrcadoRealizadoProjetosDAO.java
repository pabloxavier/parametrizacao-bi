package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoContasContabeisOrcadoRealizadoProjetosCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class DefinicaoContasContabeisOrcadoRealizadoProjetosDAO {

    private Logger LOGGER = LoggerFactory.getLogger(DefinicaoContasContabeisOrcadoRealizadoProjetosDAO.class);

    private final JdbcTemplate jdbcTemplate;

    private static final BeanPropertyRowMapper<DefinicaoContasContabeisOrcadoRealizadoProjetosCommand> ROW_MAPPER =
            BeanPropertyRowMapper.newInstance(DefinicaoContasContabeisOrcadoRealizadoProjetosCommand.class);

    private static final String BUSCA_CONTAS_ATIVAS_SQL = "select id, codigo_cooperativa, comparacao, codigo_conta_estrutural, excluir from ods.definicao_contas_contabeis_orcado_realizado_projetos where excluir = 1";

    @Autowired
    public DefinicaoContasContabeisOrcadoRealizadoProjetosDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
