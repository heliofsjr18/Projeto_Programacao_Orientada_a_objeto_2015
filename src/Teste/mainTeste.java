
package Teste;

import Dados.DAOCliente;
import Dados.DAOClienteImpl;
import Dados.DAOFornecedor;
import Dados.DAOFornecedorImpl;
import Dados.DAOFuncionario;
import Dados.DAOFuncionarioImpl;
import Dados.DAOPagamento;
import Dados.DAOPagamentoImpl;
import Dados.DAOProduto;
import Dados.DAOProdutoImpl;
import Dados.DAOVenda;
import Dados.DAOVendaImpl;
import Excecoes.ConexaoException;
import Excecoes.RepositorioException;
import javax.swing.JOptionPane;

/**
 *
 * @author helio
 */
public class mainTeste {
    public static void main(String[]args){
        
        DAOVenda ven = new DAOVendaImpl();
        DAOCliente cli = new DAOClienteImpl();
        DAOPagamento pag = new DAOPagamentoImpl();
        DAOProduto prod = new DAOProdutoImpl();
        DAOFornecedor forn = new DAOFornecedorImpl();
        DAOFuncionario fun = new DAOFuncionarioImpl();
        Long data = System.currentTimeMillis();
        
        try {
            /*VendaProduto produto = new VendaProduto();
            produto.getProd_codigo().setProd_codigo(2);
            produto.getVen_codigo().setVen_codigo(30);
            produto.setVenProd_qtdProduto(3);
            produto.setVenProd_valorProdutoUnitario(10.00);
            produto.setVenProd_valorTotal(32.50);
            Venda venda = new Venda();
            venda.getCli_codigo().setCli_codigo(5);
            venda.getFun_codigo().setFun_codigo(1);
            venda.getPag_codigo().setPag_codigo(1);
            venda.setVen_data(new Date(data));
            venda.setVen_valor(32.50);
            venda.getItensDaVenda().add(produto);*/
            
            forn.listar();
            ven.listar();
            cli.listar();
            fun.listar();
            prod.listar();
            pag.listar();
            JOptionPane.showMessageDialog(null, "Mermão que bicho cagado do carai doido");
        } catch (ConexaoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (RepositorioException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    
    }
}
