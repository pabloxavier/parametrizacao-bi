package br.com.unicred.parametrizacao.bi.impl.infrastructure.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.unicred.parametrizacao.bi.impl.business.commands.DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand;
import br.com.unicred.parametrizacao.bi.impl.business.domain.DefinicaoCentrosCustosOrcadoRealizadoProjetos;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.ErroInesperadoException;

@Repository
public class DefinicaoCentrosCustosOrcadoRealizadoProjetosDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private Logger log = LoggerFactory.getLogger(DefinicaoCentrosCustosOrcadoRealizadoProjetosDAO.class);
    private static final BeanPropertyRowMapper<DefinicaoCentrosCustosOrcadoRealizadoProjetos> ROW_MAPPER = BeanPropertyRowMapper.newInstance(DefinicaoCentrosCustosOrcadoRealizadoProjetos.class);

    private static final String MENSAGEM = "Definicao Centros Custos Orcado Realizado Projetos";
    private static final String LISTAR_SQL = "select codigo_cooperativa, comparacao, codigo_posto, excluir from edw.definicao_centros_custos_orcado_realizado_projetos where 1 = 1 ";
    private static final String INSERIR_SQL = "insert into edw.definicao_centros_custos_orcado_realizado_projetos (codigo_cooperativa, comparacao, codigo_posto, excluir) values (:cdCoop, :comparacao, :cdPosto, false) ";
    private static final String EXCLUIR_SQL = "update edw.definicao_centros_custos_orcado_realizado_projetos set excluir = true where codigo_cooperativa = :cdCoop and comparacao =:comparacao and codigo_posto = :cdPosto";

    @Autowired
    public DefinicaoCentrosCustosOrcadoRealizadoProjetosDAO(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DefinicaoCentrosCustosOrcadoRealizadoProjetos> listar() {
        try {
            log.info(String.format("Listando %s.", MENSAGEM));
            return jdbcTemplate.query(LISTAR_SQL, ROW_MAPPER);
        } catch (final Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao listar %s.", MENSAGEM), e);
        }         
    }

    public List<DefinicaoCentrosCustosOrcadoRealizadoProjetos> listarComFiltros(Integer cdCoop, String comparacao, String cdPosto, Boolean isExcluido) {
        try {
                     
            String sql = LISTAR_SQL; 
            
            if (cdCoop != null)
                sql += String.format(" and codigo_cooperativa = %d ", cdCoop);

            if (comparacao != null && cdPosto != null)
                sql += String.format(" and codigo_posto %s '%s' ", comparacao, cdPosto);
                
            if (isExcluido != null)
                sql += String.format(" and excluir = %s ", isExcluido);
            
            log.info(String.format("Listando %s [%s].", MENSAGEM, sql));
            return jdbcTemplate.query(sql, ROW_MAPPER);
        } catch (final Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao listar %s.", MENSAGEM), e);
        }           
    }

    public DefinicaoCentrosCustosOrcadoRealizadoProjetos inserir(final DefinicaoCentrosCustosOrcadoRealizadoProjetos dominio) {
        try {
            log.info(String.format("Inserindo %s [%s].", MENSAGEM, dominio.toString()));
            jdbcTemplate.update(INSERIR_SQL, getParams(dominio));
            return dominio;
        } catch (Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao inserir %s [%s].", MENSAGEM, dominio.toString()), e);
        }
    }
    
    public void excluir(final DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {
        try {
            log.info(String.format("Excluindo %s [%s].", MENSAGEM, comando.toString()));
            jdbcTemplate.update(EXCLUIR_SQL, getParams(comando));    
        } catch (Exception e) {
            throw new ErroInesperadoException(String.format("Erro ao excluir %s [%s].", MENSAGEM, comando.toString()), e);
        }
    }
    
    private MapSqlParameterSource getParams(DefinicaoCentrosCustosOrcadoRealizadoProjetos dominio) {
        return new MapSqlParameterSource("cdCoop", dominio.getCodigoCooperativa())
                               .addValue("comparacao", dominio.getComparacao())
                               .addValue("cdPosto", dominio.getCodigoPosto());
    }    

    private MapSqlParameterSource getParams(DefinicaoCentrosCustosOrcadoRealizadoProjetosCommand comando) {
        return new MapSqlParameterSource("cdCoop", comando.getCodigoCooperativa())
                               .addValue("comparacao", comando.getComparacao())
                               .addValue("cdPosto", comando.getCodigoPosto());
    }    
}
