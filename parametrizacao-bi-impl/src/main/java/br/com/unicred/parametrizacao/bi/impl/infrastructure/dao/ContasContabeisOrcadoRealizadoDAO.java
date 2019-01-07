package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.ContasContabeisOrcadoRealizadoCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.ContasContabeisOrcadoRealizado;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.ErroInesperadoException;
import br.com.unicred.parametrizacao.bi.impl.infrastructure.utils.ContasContabeisOrcadoRealizadoUtils;

@Repository
public class ContasContabeisOrcadoRealizadoDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private Logger log = LoggerFactory.getLogger(ContasContabeisOrcadoRealizadoDAO.class);
    private static final BeanPropertyRowMapper<ContasContabeisOrcadoRealizado> ROW_MAPPER = BeanPropertyRowMapper.newInstance(ContasContabeisOrcadoRealizado.class);
    
    private static final String CONTAS_CONTABEIS_ORCADO_REALIZADO_TABLE = "edw.contas_contabeis_orcado_realizado";
    private static final String CONTAS_CONTABEIS_ORCADO_REALIZADO_PROJETOS_TABLE = "edw.contas_contabeis_orcado_realizado_projetos";
    private static final String LISTAR_SQL = "select codigo_cooperativa, codigo_conta_estrutural from %s ";
    private static final String LISTAR_BY_COOP_SQL = "select codigo_cooperativa, codigo_conta_estrutural from %s where codigo_cooperativa = :cdCoop";
    private static final String LISTAR_BY_COOP_AND_CONTA_SQL = "select codigo_cooperativa, codigo_conta_estrutural from %s where codigo_cooperativa = :cdCoop and codigo_conta_estrutural = :cdConta";
    private static final String INSERIR_SQL = "insert into %s (codigo_cooperativa, codigo_conta_estrutural) values (:cdCoop, :cdConta) ";
    private static final String EXCLUIR_SQL = "delete from %s where codigo_cooperativa = :cdCoop and codigo_conta_estrutural = :cdConta ";

    @Autowired
    public ContasContabeisOrcadoRealizadoDAO(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ContasContabeisOrcadoRealizado> listarContasContabeisOrcadoRealizado(Boolean isProjeto) {
        String mensagem = ContasContabeisOrcadoRealizadoUtils.defineMensagem(isProjeto);
        try {            
            log.info(String.format("Procurando %s.", mensagem));
            String sql = ajustaTabelaSql(LISTAR_SQL, defineTabela(isProjeto));
            return jdbcTemplate.query(sql, ROW_MAPPER);
        } catch (final Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao buscar %s.", mensagem), e);
        }         
    }

    public List<ContasContabeisOrcadoRealizado> listarContasContabeisOrcadoRealizadoByCoop(Integer cdCoop, Boolean isProjeto) {
        String mensagem = ContasContabeisOrcadoRealizadoUtils.defineMensagem(isProjeto);
        try {            
            log.info(String.format("Procurando %s da cooperativa %d.", mensagem, cdCoop));
            String sql = ajustaTabelaSql(LISTAR_BY_COOP_SQL, defineTabela(isProjeto));
            return  jdbcTemplate.query(sql, getParams(cdCoop), ROW_MAPPER);
        } catch (final Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao buscar %s da cooperativa %d.", mensagem, cdCoop), e);
        }         
    }

    public ContasContabeisOrcadoRealizado buscaContaContabilOrcadoRealizadoByCoopAndConta(Integer cdCoop, String cdConta, Boolean isProjeto) {
        String mensagem = ContasContabeisOrcadoRealizadoUtils.defineMensagem(isProjeto);
        try {
            log.info(String.format("Procurando %s da cooperativa %d e conta %s.", mensagem, cdCoop, cdConta));
            String sql = ajustaTabelaSql(LISTAR_BY_COOP_AND_CONTA_SQL, defineTabela(isProjeto));
            List<ContasContabeisOrcadoRealizado> result = jdbcTemplate.query(sql, getParams(cdCoop, cdConta), ROW_MAPPER);
            return result.isEmpty() ? null : result.get(0);
        } catch (final Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao buscar %s da cooperativa %d e conta %s.", mensagem, cdCoop, cdConta), e);
        }
    }

    public ContasContabeisOrcadoRealizado inserir(final ContasContabeisOrcadoRealizado dominio, Boolean isProjeto) {
        String mensagem = ContasContabeisOrcadoRealizadoUtils.defineMensagem(isProjeto);
        try {
            log.info(String.format("Inserindo %s na cooperativa %d e conta %s.", mensagem, dominio.getCodigoCooperativa(), dominio.getCodigoContaEstrutural()));
            String sql =  ajustaTabelaSql(INSERIR_SQL, defineTabela(isProjeto));
            jdbcTemplate.update(sql, getParams(dominio.getCodigoCooperativa(), dominio.getCodigoContaEstrutural()));
            return dominio;
        } catch (Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao inserir %s para cooperativa %d e conta %s.", mensagem, dominio.getCodigoCooperativa(), dominio.getCodigoContaEstrutural()), e);
        }
    }
    
    public void excluirPostoIgnorado(final ContasContabeisOrcadoRealizadoCommand comando, Boolean isProjeto) {
        String mensagem = ContasContabeisOrcadoRealizadoUtils.defineMensagem(isProjeto);
        try {
            log.info(String.format("Excluindo %s na cooperativa %d e conta %s.", mensagem, comando.getCodigoCooperativa(), comando.getCodigoContaEstrutural()));
            String sql = ajustaTabelaSql(EXCLUIR_SQL, defineTabela(isProjeto));
            jdbcTemplate.update(sql, getParams(comando.getCodigoCooperativa(), comando.getCodigoContaEstrutural()));    
        } catch (Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao excluir %s para cooperativa %d e conta %s.", mensagem, comando.getCodigoCooperativa(), comando.getCodigoContaEstrutural()), e);
        }
    }
    
    private MapSqlParameterSource getParams(Integer cdCoop) {
        return new MapSqlParameterSource("cdCoop", cdCoop);
    }

    private MapSqlParameterSource getParams(Integer cdCoop, String cdConta) {
        return new MapSqlParameterSource("cdCoop", cdCoop)
                               .addValue("cdConta", cdConta);
    }
    
    private String defineTabela(Boolean isProjeto){
        return isProjeto ? CONTAS_CONTABEIS_ORCADO_REALIZADO_PROJETOS_TABLE : CONTAS_CONTABEIS_ORCADO_REALIZADO_TABLE;
    }      
    
    private String ajustaTabelaSql(String sql, String table){
        return String.format(sql , table);
    }
    
 
}
