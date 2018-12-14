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

import br.com.unicred.parametrizacao.bi.impl.business.domain.PlanoFgCoopBrasil;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.ErroInesperadoException;
import br.com.unicred.parametrizacao.bi.impl.business.exceptions.NotFoundException;

@Repository
public class PlanoFgCoopBrasilDAO {

    private final JdbcTemplate jdbcTemplate;
    private Logger log = LoggerFactory.getLogger(PlanoFgCoopBrasilDAO.class);
    private static final BeanPropertyRowMapper<PlanoFgCoopBrasil> ROW_MAPPER = BeanPropertyRowMapper.newInstance(PlanoFgCoopBrasil.class);

    private static final String BUSCA_CONTA_BACEN_SQL = "select codigo_conta_bacen, descricao_conta_bacen from edw.plano_fg_coop_brasil";
    private static final String BUSCA_CONTA_BACEN_SQL_BY_CODIGO = "select codigo_conta_bacen, descricao_conta_bacen from edw.plano_fg_coop_brasil WHERE codigo_conta_bacen = ? ";
    private static final String INSERIR_CONTA_BACEN = "insert into edw.plano_fg_coop_brasil (codigo_conta_bacen, descricao_conta_bacen) values(?,?)";
    
    @Autowired
    public PlanoFgCoopBrasilDAO(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PlanoFgCoopBrasil> buscaContaBacen() {
        try {
            log.info("Procurando postos ignorados.");
            return jdbcTemplate.query(BUSCA_CONTA_BACEN_SQL, ROW_MAPPER);
        } catch (final EmptyResultDataAccessException e) {
            log.warn("Não foram encontrados codigos bacen.", e);
            throw new NotFoundException("Não foram encontrados codigos bacen.");
        }            
    }

    public List<PlanoFgCoopBrasil> buscaContaBacenByCodigo(String codigoContaBacen) {
        log.info(String.format("Procurando contas bacen pelo codigo %d.", codigoContaBacen));
        List<PlanoFgCoopBrasil> contasBacenList = jdbcTemplate.query(BUSCA_CONTA_BACEN_SQL_BY_CODIGO, new Object[] { codigoContaBacen }, ROW_MAPPER);
        
        if (contasBacenList.size() == 0) {
            log.warn(String.format("Não foram encontradas contas Bacen com este codigo %d.", codigoContaBacen));
            throw new NotFoundException(String.format("Não foram encontradas contas Bacen com este codigo %d.", codigoContaBacen));
        }
        return contasBacenList;
    }
    
    public PlanoFgCoopBrasil inserirContaBacen(final PlanoFgCoopBrasil planoFgCoopBrasil) {
        
        try {
            log.info(String.format("Inserindo conta bacen %d com a descrição %d.", planoFgCoopBrasil.getCodigoContaBacen(), planoFgCoopBrasil.getDescricaoContaBacen()));
            jdbcTemplate.update(INSERIR_CONTA_BACEN, getParams(planoFgCoopBrasil), getTypes());
            return planoFgCoopBrasil;
        } catch (Exception e) {
            log.error(String.format("Erro ao inserir conta bacen %d com a descrição %d.", planoFgCoopBrasil.getCodigoContaBacen(), planoFgCoopBrasil.getDescricaoContaBacen()) + e);
            throw new ErroInesperadoException();
        }
    }

    
    private Object[] getParams(final PlanoFgCoopBrasil planoFgCoopBrasil) {
        return new Object[] { planoFgCoopBrasil.getCodigoContaBacen(), planoFgCoopBrasil.getDescricaoContaBacen() };
    }
    
    private int[] getTypes() {
        return new int[] { Types.VARCHAR, Types.VARCHAR};
    }
    
}

