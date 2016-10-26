package Dados;

import ConexaoBD.GerenciadorConexao;
import ConexaoBD.GerenciadorConexaoImpl;
import Excecoes.ConexaoException;
import Excecoes.RepositorioException;
import Negocio.Basica.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOClienteImpl implements DAOCliente {

    private final GerenciadorConexao conectarBD;        
    
    public DAOClienteImpl(){
        conectarBD = GerenciadorConexaoImpl.getInstancia();
    }
    
    @Override
    public void inserir(Cliente cli) throws RepositorioException, ConexaoException {
        Connection c = null;
        String insertSql = "INSERT INTO clientes (cli_cpf, cli_nome, cli_telefone, cli_endereco) VALUES (?,?,?,?)";
        try {
            c = conectarBD.conectar();
            PreparedStatement inserirPst = c.prepareStatement(insertSql);
            inserirPst.setString(1, cli.getCli_cpf());
            inserirPst.setString(2, cli.getCli_nome());
            inserirPst.setString(3, cli.getCli_telefone());
            inserirPst.setString(4, cli.getCli_endereco());
            inserirPst.execute();
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
        
    }

    @Override
    public void atualizar(Cliente cli, Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String updateSql = "UPDATE clientes SET cli_cpf = ?, cli_nome = ?, cli_telefone = ?, cli_endereco = ? WHERE cli_codigo = ?";
        try {
            c = conectarBD.conectar();
            PreparedStatement alterarPst = c.prepareStatement(updateSql);
            alterarPst.setString(1, cli.getCli_cpf());
            alterarPst.setString(2, cli.getCli_nome());
            alterarPst.setString(3, cli.getCli_telefone());
            alterarPst.setString(4, cli.getCli_endereco());
            alterarPst.setInt(5, codigo);
            alterarPst.execute();
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }
    @Override
    public void atualizar(Cliente cli) throws RepositorioException, ConexaoException {
                Connection c = null;
        String updateSql = "UPDATE clientes SET cli_cpf = ?, cli_nome = ?, cli_telefone = ?, cli_endereco = ? WHERE cli_cpf = ?";
        try {
            c = conectarBD.conectar();
            PreparedStatement alterarPst = c.prepareStatement(updateSql);
            alterarPst.setString(1, cli.getCli_cpf());
            alterarPst.setString(2, cli.getCli_nome());
            alterarPst.setString(3, cli.getCli_telefone());
            alterarPst.setString(4, cli.getCli_endereco());
            alterarPst.setString(5, cli.getCli_cpf());
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
        String removerSql = "DELETE FROM clientes WHERE cli_codigo ="+codigo;
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
    public void remover(String cpf) throws RepositorioException, ConexaoException {
        Connection c = null;
        String removerSql = "DELETE FROM clientes WHERE cli_cpf ="+cpf;
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
    public Cliente pesquisar(Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String pesquisarSql = "SELECT cli_codigo, cli_cpf, cli_nome, cli_telefone, cli_endereco FROM clientes WHERE cli_codigo ="+codigo;
        try {
            c = conectarBD.conectar();
            Statement pesquisarSt = c.createStatement();
            ResultSet rs = pesquisarSt.executeQuery(pesquisarSql);
            if(rs.next()){
                Cliente cli = new Cliente();
                cli.setCli_codigo(rs.getInt("cli_codigo"));
                cli.setCli_cpf(rs.getString("cli_cpf"));
                cli.setCli_nome(rs.getString("cli_nome"));
                cli.setCli_telefone(rs.getString("cli_telefone"));
                cli.setCli_endereco(rs.getString("cli_endereco"));
                return cli;
            }
            return null;
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public Cliente pesquisar(String cpf) throws RepositorioException, ConexaoException {
        Connection c = null;
        String pesquisarSql = "SELECT cli_codigo, cli_cpf, cli_nome, cli_telefone, cli_endereco FROM clientes WHERE cli_cpf ="+cpf;
        try {
            c = conectarBD.conectar();
            Statement pesquisarSt = c.createStatement();
            ResultSet rs = pesquisarSt.executeQuery(pesquisarSql);
            if(rs.next()){
                Cliente cli = new Cliente();
                cli.setCli_codigo(rs.getInt("cli_codigo"));
                cli.setCli_cpf(rs.getString("cli_cpf"));
                cli.setCli_nome(rs.getString("cli_nome"));
                cli.setCli_telefone(rs.getString("cli_telefone"));
                cli.setCli_endereco(rs.getString("cli_endereco"));
                return cli;
            }
            return null;
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public ArrayList<Cliente> listar() throws RepositorioException, ConexaoException {
        Connection c = null;
        String listarSql = "SELECT cli_codigo, cli_cpf, cli_nome, cli_telefone, cli_endereco FROM clientes";
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            c = conectarBD.conectar();
            Statement listarSt = c.createStatement();
            ResultSet rs = listarSt.executeQuery(listarSql);
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setCli_codigo(rs.getInt("cli_codigo"));
                cli.setCli_cpf(rs.getString("cli_cpf"));
                cli.setCli_nome(rs.getString("cli_nome"));
                cli.setCli_telefone(rs.getString("cli_telefone"));
                cli.setCli_endereco(rs.getString("cli_endereco"));
                lista.add(cli);
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
