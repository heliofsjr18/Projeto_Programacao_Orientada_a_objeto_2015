    package Dados;

import ConexaoBD.GerenciadorConexao;
import ConexaoBD.GerenciadorConexaoImpl;
import Excecoes.ConexaoException;
import Excecoes.RepositorioException;
import Negocio.Basica.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOFuncionarioImpl implements DAOFuncionario {

    private final GerenciadorConexao conectarBD;        
    
    public DAOFuncionarioImpl(){
        conectarBD = GerenciadorConexaoImpl.getInstancia();
    }
    
    @Override
    public void inserir(Funcionario fun) throws RepositorioException, ConexaoException {
        Connection c = null;
        String insertSql = "INSERT INTO funcionarios (fun_cpf, fun_nome, fun_telefone, fun_login, fun_senha) VALUES (?,?,?,?,?)";
        try {
            c = conectarBD.conectar();
            PreparedStatement inserirPst = c.prepareStatement(insertSql);
            inserirPst.setString(1, fun.getFun_cpf());
            inserirPst.setString(2, fun.getFun_nome());
            inserirPst.setString(3, fun.getFun_telefone());
            inserirPst.setString(4, fun.getFun_login());
            inserirPst.setString(5, fun.getFun_senha());
            inserirPst.execute();
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public void atualizar(Funcionario fun, Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String updateSql = "UPDATE FROM funcionarios SET fun_cpf = ?, fun_nome = ?, fun_telefone = ?, fun_login = ?, fun_senha = ? WHERE fun_codigo = ?";
        try {
            c = conectarBD.conectar();
            PreparedStatement alterarPst = c.prepareStatement(updateSql);
            alterarPst.setString(1, fun.getFun_cpf());
            alterarPst.setString(2, fun.getFun_nome());
            alterarPst.setString(3, fun.getFun_telefone());
            alterarPst.setString(4, fun.getFun_login());
            alterarPst.setString(5, fun.getFun_senha());
            alterarPst.setInt(6, codigo);
            alterarPst.execute();
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public void atualizar(Funcionario fun) throws RepositorioException, ConexaoException {
        Connection c = null;
        String updateSql = "UPDATE FROM funcionarios SET fun_cpf = ?, fun_nome = ?, fun_telefone = ?, fun_login = ?, fun_senha = ? WHERE fun_cpf = ?";
        try {
            c = conectarBD.conectar();
            PreparedStatement alterarPst = c.prepareStatement(updateSql);
            alterarPst.setString(1, fun.getFun_cpf());
            alterarPst.setString(2, fun.getFun_nome());
            alterarPst.setString(3, fun.getFun_telefone());
            alterarPst.setString(4, fun.getFun_login());
            alterarPst.setString(5, fun.getFun_senha());
            alterarPst.setString(6, fun.getFun_cpf());
            alterarPst.execute();
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            conectarBD.desconectar(c);
        }
    }
    @Override
    public void remover(Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String removerSql = "DELETE FROM funcionarios WHERE fun_codigo ="+codigo;
        try {
            c = conectarBD.conectar();
            Statement removerSt = c.createStatement();
            removerSt.execute(removerSql);
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public void remover(String cpf) throws RepositorioException, ConexaoException {
        Connection c = null;
        String removerSql = "DELETE FROM funcionarios WHERE fun_cpf ="+cpf;
        try {
            c = conectarBD.conectar();
            Statement removerSt = c.createStatement();
            removerSt.execute(removerSql);
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public Funcionario pesquisar(Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String pesquisarSql = "SELECT fun_codigo, fun_cpf, fun_nome, fun_telefone, fun_login, fun_senha FROM funcionarios WHERE fun_codigo ="+codigo;
        try {
            c = conectarBD.conectar();
            Statement pesquisarSt = c.createStatement();
            ResultSet rs = pesquisarSt.executeQuery(pesquisarSql);
            if(rs.next()){
                Funcionario fun = new Funcionario();
                fun.setFun_codigo(rs.getInt("fun_codigo"));
                fun.setFun_cpf(rs.getString("fun_cpf"));
                fun.setFun_nome(rs.getString("fun_nome"));
                fun.setFun_telefone(rs.getString("fun_telefone"));
                fun.setFun_login(rs.getString("fun_login"));
                fun.setFun_senha(rs.getString("fun_senha"));
                return fun;
            }
            return null;
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public Funcionario pesquisar(String cpf) throws RepositorioException, ConexaoException {
        Connection c = null;
        String pesquisarSql = "SELECT fun_codigo, fun_cpf, fun_nome, fun_telefone, fun_login, fun_senha FROM funcionarios WHERE fun_cpf ="+cpf;
        try {
            c = conectarBD.conectar();
            Statement pesquisarSt = c.createStatement();
            ResultSet rs = pesquisarSt.executeQuery(pesquisarSql);
            if(rs.next()){
                Funcionario fun = new Funcionario();
                fun.setFun_codigo(rs.getInt("fun_codigo"));
                fun.setFun_cpf(rs.getString("fun_cpf"));
                fun.setFun_nome(rs.getString("fun_nome"));
                fun.setFun_telefone(rs.getString("fun_telefone"));
                fun.setFun_login(rs.getString("fun_login"));
                fun.setFun_senha(rs.getString("fun_senha"));
                return fun;
            }
            return null;
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public ArrayList<Funcionario> listar() throws RepositorioException, ConexaoException {
        Connection c = null;
        String listarSql = "SELECT fun_codigo, fun_cpf, fun_nome, fun_telefone, fun_login, fun_senha FROM funcionarios";
        ArrayList<Funcionario> lista = new ArrayList<>();
        try {
            c = conectarBD.conectar();
            Statement listarSt = c.createStatement();
            ResultSet rs = listarSt.executeQuery(listarSql);
            while(rs.next()){
                Funcionario fun = new Funcionario();
                fun.setFun_codigo(rs.getInt("fun_codigo"));
                fun.setFun_cpf(rs.getString("fun_cpf"));
                fun.setFun_nome(rs.getString("fun_nome"));
                fun.setFun_telefone(rs.getString("fun_telefone"));
                fun.setFun_login(rs.getString("fun_login"));
                fun.setFun_senha(rs.getString("fun_senha"));
                lista.add(fun);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            conectarBD.desconectar(c);
        }
    }

    
}
