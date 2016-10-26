
package ConexaoBD;

import Excecoes.ConexaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class GerenciadorConexaoImpl implements GerenciadorConexao {
    
    private static GerenciadorConexaoImpl INSTANCIA;
    private final String url;
    private final String nome;
    private final String senha;
    
    
    private GerenciadorConexaoImpl(){
        ResourceBundle rsb = ResourceBundle.getBundle("ConexaoBD.PropriedadesDoBanco");
        url = rsb.getString("url");
        nome = rsb.getString("nome");
        senha = rsb.getString("senha");
    }
    
    public static GerenciadorConexaoImpl getInstancia(){
        if(INSTANCIA == null)
            INSTANCIA = new GerenciadorConexaoImpl();
        return INSTANCIA;
    }

    @Override
    public Connection conectar()throws ConexaoException{
        Connection c;
        try {
            c = DriverManager.getConnection(url, nome, senha);
            return c;
        } catch (SQLException e) {
            throw new ConexaoException(e.getMessage());
        }
        
    }

    @Override
    public void desconectar(Connection c) throws ConexaoException{
        try {
            c.close();
        } catch (SQLException e) {
            throw new ConexaoException();
        }
    }
    
}
