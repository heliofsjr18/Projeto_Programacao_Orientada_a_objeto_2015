package Dados;

import ConexaoBD.GerenciadorConexao;
import ConexaoBD.GerenciadorConexaoImpl;
import Excecoes.ConexaoException;
import Excecoes.RepositorioException;
import Negocio.Basica.Fornecedor;
import Negocio.Basica.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOProdutoImpl implements DAOProduto {

    private final GerenciadorConexao conectarBD;        
    
    public DAOProdutoImpl(){
        conectarBD = GerenciadorConexaoImpl.getInstancia();
    }
    
    @Override
    public void inserir(Produto prod) throws RepositorioException, ConexaoException {
        Connection c = null;
        String insertSql = "INSERT INTO produtos (forn_codigo, prod_descricao, prod_qtdEstoque, prod_valor) VALUES (?,?,?,?)";
        try {
            c = conectarBD.conectar();
            PreparedStatement inserirPst = c.prepareStatement(insertSql);
            inserirPst.setInt(1, prod.getForn_codigo().getForn_codigo());
            inserirPst.setString(2, prod.getProd_descricao());
            inserirPst.setInt(3, prod.getProd_qtdEstoque());
            inserirPst.setDouble(4, prod.getProd_valor());
            inserirPst.execute();
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public void atualizar(Produto prod, Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String updateSql = "UPDATE FROM produtos SET forn_codigo = ?, prod_descricao = ?, prod_qtdEstoque = ?, prod_valor = ? WHERE prod_codigo = ?";
        try {
            c = conectarBD.conectar();
            PreparedStatement alterarPst = c.prepareStatement(updateSql);
            alterarPst.setInt(1, prod.getForn_codigo().getForn_codigo());
            alterarPst.setString(2, prod.getProd_descricao());
            alterarPst.setInt(3, prod.getProd_qtdEstoque());
            alterarPst.setDouble(4, prod.getProd_valor());
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
        String removerSql = "DELETE FROM produtos WHERE prod_codigo ="+codigo;
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
    public Produto pesquisar(Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String pesquisarSql = "SELECT prod_codigo, forn_codigo, prod_descricao, prod_qtdEstoque, prod_valor FROM produtos WHERE prod_codigo ="+codigo;
        try {
            c = conectarBD.conectar();
            Statement pesquisarSt = c.createStatement();
            ResultSet rs = pesquisarSt.executeQuery(pesquisarSql);
            if(rs.next()){
                Produto prod = new Produto();
                prod.setProd_codigo(rs.getInt("prod_codigo"));
                prod.getForn_codigo().setForn_codigo(rs.getInt("forn_codigo"));
                prod.setProd_descricao(rs.getString("prod_descricao"));
                prod.setProd_qtdEstoque(rs.getInt("prod_qtdEstoque"));
                prod.setProd_valor(rs.getDouble("prod_valor"));
                return prod;
            }
            return null;
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public ArrayList<Produto> listar() throws RepositorioException, ConexaoException {
        Connection c = null;
        String listarSql = "SELECT prod_codigo, forn_codigo, prod_descricao, prod_qtdEstoque, prod_valor FROM produtos";
        ArrayList<Produto> lista = new ArrayList<>();
        try {
            c = conectarBD.conectar();
            Statement listarSt = c.createStatement();
            ResultSet rs = listarSt.executeQuery(listarSql);
            while(rs.next()){
                Produto prod = new Produto();
                prod.setProd_codigo(rs.getInt("prod_codigo"));
                prod.getForn_codigo().setForn_codigo(rs.getInt("forn_codigo"));
                prod.setProd_descricao(rs.getString("prod_descricao"));
                prod.setProd_qtdEstoque(rs.getInt("prod_qtdEstoque"));
                prod.setProd_valor(rs.getDouble("prod_valor"));
                lista.add(prod);
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
