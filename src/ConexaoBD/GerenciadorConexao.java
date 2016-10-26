
package ConexaoBD;

import Excecoes.ConexaoException;
import java.sql.Connection;

/**
 *
 * @author helio
 */
public interface GerenciadorConexao {
    
    /**
     * Conectar com o banco de dados
     * @return retorna uma conexão
     * @throws Excecoes.ConexaoException Erro na conexão com o banco
     */
    public Connection conectar() throws ConexaoException;
    
    /**
     * Desconecta do banco de dados
     * @param c Recebe uma conexão
     * @throws ConexaoException erro ao tentar desconectar do banco
     */
    public void desconectar(Connection c) throws ConexaoException;
}
