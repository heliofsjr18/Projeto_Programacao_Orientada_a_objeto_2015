package Dados;

import ConexaoBD.GerenciadorConexao;
import ConexaoBD.GerenciadorConexaoImpl;
import Excecoes.ConexaoException;
import Excecoes.RepositorioException;
import Negocio.Basica.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOPagamentoImpl implements DAOPagamento {

    private final GerenciadorConexao conectarBD;        
    
    public DAOPagamentoImpl(){
        conectarBD = GerenciadorConexaoImpl.getInstancia();
    }
    
    @Override
    public void inserir(Pagamento pag) throws RepositorioException, ConexaoException {
        Connection c = null;
        String insertSql = "INSERT INTO pagamentos (pag_tipo, pag_qtdParcelas, pag_juros, pag_desconto) VALUES (?,?,?,?)";
        try {
            c = conectarBD.conectar();
            PreparedStatement inserirPst = c.prepareStatement(insertSql);
            inserirPst.setString(1, pag.getPag_tipo());
            inserirPst.setInt(2, pag.getPag_qtdParcelas());
            inserirPst.setDouble(3, pag.getPag_juros());
            inserirPst.setDouble(4, pag.getPag_desconto());
            inserirPst.execute();
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public void atualizar(Pagamento pag, Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String updateSql = "UPDATE FROM pagamentos SET pag_tipo = ?, pag_qtdParcelas = ?, pag_juros= ?, pag_desconto = ? WHERE pag_codigo = ?";
        try {
            c = conectarBD.conectar();
            PreparedStatement alterarPst = c.prepareStatement(updateSql);
            alterarPst.setString(1, pag.getPag_tipo());
            alterarPst.setInt(2, pag.getPag_qtdParcelas());
            alterarPst.setDouble(3, pag.getPag_juros());
            alterarPst.setDouble(4, pag.getPag_desconto());
            alterarPst.setInt(5, codigo);
            alterarPst.execute();
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public void remover(Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String removerSql = "DELETE FROM pagamentos WHERE pag_codigo ="+codigo;
        try {
            c = conectarBD.conectar();
            Statement removerSt = c.createStatement();
            removerSt.execute(removerSql);
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public void remover(String tipo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String removerSql = "DELETE FROM pagamentos WHERE pag_tipo ="+tipo;
        try {
            c = conectarBD.conectar();
            Statement removerSt = c.createStatement();
            removerSt.execute(removerSql);
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public Pagamento pesquisar(Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String pesquisarSql = "SELECT pag_codigo, pag_tipo, pag_qtdParcelas, pag_juros, pag_desconto FROM pagamentos WHERE pag_codigo ="+codigo;
        try {
            c = conectarBD.conectar();
            Statement pesquisarSt = c.createStatement();
            ResultSet rs = pesquisarSt.executeQuery(pesquisarSql);
            if(rs.next()){
                Pagamento pag = new Pagamento();
                pag.setPag_codigo(rs.getInt("pag_codigo"));
                pag.setPag_tipo(rs.getString("pag_tipo"));
                pag.setPag_qtdParcelas(rs.getInt("pag_qtdParcelas"));
                pag.setPag_juros(rs.getDouble("pag_juros"));
                pag.setPag_desconto(rs.getDouble("pag_desconto"));
                return pag;
            }
            return null;
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public Pagamento pesquisar(String tipo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String pesquisarSql = "SELECT pag_codigo, pag_tipo, pag_qtdParcelas, pag_juros, pag_desconto FROM pagamentos WHERE pag_tipo ="+tipo;
        try {
            c = conectarBD.conectar();
            Statement pesquisarSt = c.createStatement();
            ResultSet rs = pesquisarSt.executeQuery(pesquisarSql);
            if(rs.next()){
                Pagamento pag = new Pagamento();
                pag.setPag_codigo(rs.getInt("pag_codigo"));
                pag.setPag_tipo(rs.getString("pag_tipo"));
                pag.setPag_qtdParcelas(rs.getInt("pag_qtdParcelas"));
                pag.setPag_juros(rs.getDouble("pag_juros"));
                pag.setPag_desconto(rs.getDouble("pag_desconto"));
                return pag;
            }
            return null;
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public ArrayList<Pagamento> listar() throws RepositorioException, ConexaoException {
        Connection c = null;
        String listarSql = "SELECT pag_codigo, pag_tipo, pag_qtdParcelas, pag_juros, pag_desconto FROM pagamentos";
        ArrayList<Pagamento> lista = new ArrayList<>();
        try {
            c = conectarBD.conectar();
            Statement listarSt = c.createStatement();
            ResultSet rs = listarSt.executeQuery(listarSql);
            while(rs.next()){
                Pagamento pag = new Pagamento();
                pag.setPag_codigo(rs.getInt("pag_codigo"));
                pag.setPag_tipo(rs.getString("pag_tipo"));
                pag.setPag_qtdParcelas(rs.getInt("pag_qtdParcelas"));
                pag.setPag_juros(rs.getDouble("pag_juros"));
                pag.setPag_desconto(rs.getDouble("pag_desconto"));
                lista.add(pag);
                return lista;
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }
    
}
