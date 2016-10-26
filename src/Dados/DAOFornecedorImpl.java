package Dados;

import ConexaoBD.GerenciadorConexao;
import ConexaoBD.GerenciadorConexaoImpl;
import Excecoes.ConexaoException;
import Excecoes.RepositorioException;
import Negocio.Basica.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOFornecedorImpl implements DAOFornecedor {

    private final GerenciadorConexao conectarBD;        
    
    public DAOFornecedorImpl(){
        conectarBD = GerenciadorConexaoImpl.getInstancia();
    }
    
    @Override
    public void inserir(Fornecedor forn) throws RepositorioException, ConexaoException {
        Connection c = null;
        String insertSql = "INSERT INTO fornecedores (forn_cnpj, forn_razaoSocial) VALUES (?,?)";
        try {
            c = conectarBD.conectar();
            PreparedStatement inserirPst = c.prepareStatement(insertSql);
            inserirPst.setString(1, forn.getForn_cnpj());
            inserirPst.setString(2, forn.getForn_razaoSocial());
            inserirPst.execute();
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public void atualizar(Fornecedor forn, Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String updateSql = "UPDATE FROM fornecedores SET forn_cnpj = ?, forn_razaoSocial = ? WHERE forn_codigo = ?";
        try {
            c = conectarBD.conectar();
            PreparedStatement alterarPst = c.prepareStatement(updateSql);
            alterarPst.setString(1, forn.getForn_cnpj());
            alterarPst.setString(2, forn.getForn_razaoSocial());
            alterarPst.setInt(3, codigo);
            alterarPst.execute();
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public void atualizar(Fornecedor forn) throws RepositorioException, ConexaoException {
        Connection c = null;
        String updateSql = "UPDATE FROM fornecedores SET forn_cnpj = ?, forn_razaoSocial = ? WHERE forn_cnpj = ?";
        try {
            c = conectarBD.conectar();
            PreparedStatement alterarPst = c.prepareStatement(updateSql);
            alterarPst.setString(1, forn.getForn_cnpj());
            alterarPst.setString(2, forn.getForn_razaoSocial());
            alterarPst.setString(3, forn.getForn_cnpj());
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
        String removerSql = "DELETE FROM fornecedores WHERE forn_codigo ="+codigo;
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
    public void remover(String cnpj) throws RepositorioException, ConexaoException {
        Connection c = null;
        String removerSql = "DELETE FROM fornecedores WHERE forn_codigo ="+cnpj;
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
    public Fornecedor pesquisar(Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String pesquisarSql = "SELECT forn_codigo, forn_cnpj, forn_razaoSocial FROM fornecedores WHERE forn_codigo ="+codigo;
        try {
            c = conectarBD.conectar();
            Statement pesquisarSt = c.createStatement();
            ResultSet rs = pesquisarSt.executeQuery(pesquisarSql);
            if(rs.next()){
                Fornecedor forn = new Fornecedor();
                forn.setForn_codigo(rs.getInt("forn_codigo"));
                forn.setForn_cnpj(rs.getString("forn_cnpj"));
                forn.setForn_razaoSocial(rs.getString("forn_razaoSocial"));
                return forn;
            }
            return null;
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public Fornecedor pesquisar(String cnpj) throws RepositorioException, ConexaoException {
        Connection c = null;
        String pesquisarSql = "SELECT forn_codigo, forn_cnpj, forn_razaoSocial FROM fornecedores WHERE forn_cnpj ="+cnpj;
        try {
            c = conectarBD.conectar();
            Statement pesquisarSt = c.createStatement();
            ResultSet rs = pesquisarSt.executeQuery(pesquisarSql);
            if(rs.next()){
                Fornecedor forn = new Fornecedor();
                forn.setForn_codigo(rs.getInt("forn_codigo"));
                forn.setForn_cnpj(rs.getString("forn_cnpj"));
                forn.setForn_razaoSocial(rs.getString("forn_razaoSocial"));
                return forn;
            }
            return null;
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public ArrayList<Fornecedor> listar() throws RepositorioException, ConexaoException {
        Connection c = null;
        String listarSql = "SELECT forn_codigo, forn_cnpj, forn_razaoSocial FROM fornecedores";
        ArrayList<Fornecedor> lista = new ArrayList<>();
        try {
            c = conectarBD.conectar();
            Statement listarSt = c.createStatement();
            ResultSet rs = listarSt.executeQuery(listarSql);
            while(rs.next()){
                Fornecedor forn = new Fornecedor();
                forn.setForn_codigo(rs.getInt("forn_codigo"));
                forn.setForn_cnpj(rs.getString("forn_cnpj"));
                forn.setForn_razaoSocial(rs.getString("forn_razaoSocial"));
                lista.add(forn);
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
