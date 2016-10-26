package Dados;

import ConexaoBD.GerenciadorConexao;
import ConexaoBD.GerenciadorConexaoImpl;
import Excecoes.ConexaoException;
import Excecoes.RepositorioException;
import Negocio.Basica.Venda;
import Negocio.Basica.VendaProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOVendaImpl implements DAOVenda {

    private final GerenciadorConexao conectarBD;        
    
    public DAOVendaImpl(){
        conectarBD = GerenciadorConexaoImpl.getInstancia();
    }
    @Override
    public void inserir(Venda ven) throws RepositorioException, ConexaoException {
        Connection c = null;
        String insertSql = "INSERT INTO vendas (ven_data, ven_valor, cli_codigo, fun_codigo, pag_codigo) VALUES (?,?,?,?,?)";
        String insertVenProdSql = "INSERT INTO vendas_produtos (prod_codigo,ven_codigo ,venProd_qtdProduto, venProd_valorProdutoUnitario, venProd_valorTotal) VALUES (?,?,?,?,?)";
        try {
            c = conectarBD.conectar();
            PreparedStatement inserirPst = c.prepareStatement(insertSql);
            inserirPst.setDate(1, ven.getVen_data());
            inserirPst.setDouble(2, ven.getVen_valor());
            inserirPst.setInt(3, ven.getCli_codigo().getCli_codigo());
            inserirPst.setInt(4, ven.getFun_codigo().getFun_codigo());
            inserirPst.setInt(5, ven.getPag_codigo().getPag_codigo());
            inserirPst.execute();
            for(Integer i = 0; i < ven.getItensDaVenda().size(); i++){                
                PreparedStatement inserirVenProdPst = c.prepareStatement(insertVenProdSql);
                inserirVenProdPst.setInt(1, ven.getItensDaVenda().get(i).getProd_codigo().getProd_codigo());
                inserirVenProdPst.setInt(2, ven.getItensDaVenda().get(i).getVen_codigo().getVen_codigo());
                inserirVenProdPst.setInt(3, ven.getItensDaVenda().get(i).getVenProd_qtdProduto());
                inserirVenProdPst.setDouble(4, ven.getItensDaVenda().get(i).getVenProd_valorProdutoUnitario());
                inserirVenProdPst.setDouble(5, ven.getItensDaVenda().get(i).getVenProd_valorTotal());
                inserirVenProdPst.execute();
            }
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    /*@Override
    public void atualizar(Venda ven, Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String updateSql = "UPDATE FROM vendas SET ven_data = ?, ven_valor = ?, cli_codigo = ?, fun_codigo = ?, pag_codigo = ? WHERE ven_codigo = ?";
        try {
            c = conectarBD.conectar();
            PreparedStatement alterarPst = c.prepareStatement(updateSql);
            alterarPst.setDate(1, ven.getVen_data());
            alterarPst.setDouble(2, ven.getVen_valor());
            alterarPst.setInt(3, ven.getCli_codigo().getCli_codigo());
            alterarPst.setInt(4, ven.getFun_codigo().getFun_codigo());
            alterarPst.setInt(5, ven.getPag_codigo().getPag_codigo());
            alterarPst.setInt(6, codigo);
            alterarPst.execute();
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }*/

    @Override
    public void remover(Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String removerSql = "DELETE FROM vendas WHERE ven_codigo ="+codigo;
        String removerVenProdSql = "DELETE FROM vendas_produtos WHERE ven_codigo ="+codigo;
        try {
            c = conectarBD.conectar();
            Statement removerSt = c.createStatement();
            removerSt.execute(removerSql);
            Statement removerVenProdSt = c.createStatement();
            removerVenProdSt.execute(removerVenProdSql);
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public Venda pesquisar(Integer codigo) throws RepositorioException, ConexaoException {
        Connection c = null;
        String pesquisarSql = "SELECT ven_codigo, ven_data, ven_valor, cli_codigo, fun_codigo, pag_codigo FROM vendas WHERE ven_codigo ="+codigo;
        String pesquisarVenProdSql = "SELECT venProd_codigo, prod_codigo, ven_codigo, venProd_qtdProduto, venProd_valorProdutoUnitario, venProd_valorTotal FROM vendas_produtos WHERE ven_codigo ="+codigo;
        try {
            c = conectarBD.conectar();
            VendaProduto venProd = new VendaProduto();
            Venda ven = new Venda();
            Statement pesquisarSt = c.createStatement();
            ResultSet rs = pesquisarSt.executeQuery(pesquisarSql);
            if(rs.next()){
                ven.setVen_codigo(rs.getInt("ven_codigo"));
                ven.setVen_data(rs.getDate("ven_data"));
                ven.setVen_valor(rs.getDouble("ven_valor"));
                ven.getCli_codigo().setCli_codigo(rs.getInt("cli_codigo"));
                ven.getFun_codigo().setFun_codigo(rs.getInt("fun_codigo"));
                ven.getPag_codigo().setPag_codigo(rs.getInt("pag_codigo"));
                ResultSet venProdRs = pesquisarSt.executeQuery(pesquisarVenProdSql);
                while(venProdRs.next()){
                    venProd.setVenProd_codigo(venProdRs.getInt("venProd_codigo"));
                    venProd.getProd_codigo().setProd_codigo(venProdRs.getInt("prod_codigo"));
                    venProd.getVen_codigo().setVen_codigo(venProdRs.getInt("ven_codigo"));
                    venProd.setVenProd_qtdProduto(venProdRs.getInt("venProd_qtdProduto"));
                    venProd.setVenProd_valorProdutoUnitario(venProdRs.getDouble("venProd_valorProdutoUnitario"));
                    venProd.setVenProd_valorTotal(venProdRs.getDouble("venProd_valorTotal"));
                    ven.getItensDaVenda().add(venProd);
                }
                return ven;
            }
            return null;
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }

    @Override
    public ArrayList<Venda> listar() throws RepositorioException, ConexaoException {
        Connection c = null;
        String listarSql = "SELECT ven_codigo, ven_data, ven_valor, cli_codigo, fun_codigo, pag_codigo FROM vendas";
        String listarVenProdSql = "SELECT venProd_codigo, prod_codigo, ven_codigo, venProd_qtdProduto, venProd_valorProdutoUnitario, venProd_valorTotal FROM vendas_produtos WHERE ven_codigo = ?";
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            c = conectarBD.conectar();            
            //Começo inicialização de objetos
            Venda ven = new Venda();
            VendaProduto venProd = new VendaProduto();
            //Fim inicialização de objetos            
            Statement listarSt = c.createStatement();
            ResultSet rs = listarSt.executeQuery(listarSql);
            PreparedStatement listarVenProdpst = c.prepareStatement(listarVenProdSql);
            while(rs.next()){
                ven.setVen_codigo(rs.getInt("ven_codigo"));
                ven.setVen_data(rs.getDate("ven_data"));
                ven.setVen_valor(rs.getDouble("ven_valor"));
                ven.getCli_codigo().setCli_codigo(rs.getInt("cli_codigo"));
                ven.getFun_codigo().setFun_codigo(rs.getInt("fun_codigo"));
                ven.getPag_codigo().setPag_codigo(rs.getInt("pag_codigo"));
                
                listarVenProdpst.setInt(1, ven.getVen_codigo());
                ResultSet venProdRs = listarVenProdpst.executeQuery();
                while(venProdRs.next()){
                    venProd.setVenProd_codigo(venProdRs.getInt("venProd_codigo"));
                    venProd.getProd_codigo().setProd_codigo(venProdRs.getInt("prod_codigo"));
                    venProd.getVen_codigo().setVen_codigo(venProdRs.getInt("ven_codigo"));
                    venProd.setVenProd_qtdProduto(venProdRs.getInt("venProd_qtdProduto"));
                    venProd.setVenProd_valorProdutoUnitario(venProdRs.getDouble("venProd_valorProdutoUnitario"));
                    venProd.setVenProd_valorTotal(venProdRs.getDouble("venProd_valorTotal"));
                    ven.getItensDaVenda().add(venProd);
                }
                lista.add(ven);
                
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException();
        } finally {
            conectarBD.desconectar(c);
        }
    }
    
}