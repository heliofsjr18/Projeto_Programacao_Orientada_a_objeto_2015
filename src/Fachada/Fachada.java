package Fachada;

import Excecoes.DadosInvalidosException;
import Excecoes.RegistroException;
import Negocio.Basica.Cliente;
import Negocio.Basica.Fornecedor;
import Negocio.Basica.Funcionario;
import Negocio.Basica.Pagamento;
import Negocio.Basica.Produto;
import Negocio.Basica.Venda;
import Negocio.RNCliente;
import Negocio.RNFornecedor;
import Negocio.RNFuncionario;
import Negocio.RNPagamento;
import Negocio.RNProduto;
import Negocio.RNVenda;
import java.util.ArrayList;

/**
 *
 * @author helio
 */
public class Fachada {
    
    private static Fachada instancia;
    RNProduto rnProduto;
    RNCliente rnCliente;
    RNFornecedor rnFornecedor;
    RNPagamento rnPagamento;
    RNFuncionario rnFuncionario;
    RNVenda rnVenda;
    
    private Fachada(){
        rnProduto = new RNProduto();
        rnCliente = new RNCliente();
        rnFornecedor = new RNFornecedor();
        rnPagamento = new RNPagamento();
        rnFuncionario = new RNFuncionario();
        rnVenda = new RNVenda();
    }
    
    public static Fachada getInstancia(){
        if(instancia == null)
            instancia = new Fachada();
        return instancia;
    }
    
    //Começo da incialização de métodos para Cliente
    public void inserirCliente(Cliente cli)throws DadosInvalidosException, RegistroException{
        rnCliente.salvarRegistro(cli);
    }
    public void alterarCliente(Cliente cli)throws DadosInvalidosException, RegistroException{
        rnCliente.atualizarRegistro(cli);
    }
    public void removerCliente(Cliente cli)throws DadosInvalidosException, RegistroException{
        rnCliente.removerRegistro(cli);
    }
    public void pesquisarCliente(Cliente cli)throws DadosInvalidosException, RegistroException{
        rnCliente.pesquisarRegistro(cli);
    }
    public ArrayList<Cliente> listarCliente()throws RegistroException{
        return rnCliente.listarRegistro();
    }
    //Fim da incialização de métodos para Cliente
    
    //################################################################################################################
    
    //Começo da incialização de métodos para Fornecedor
    public void inserirFornecedor(Fornecedor forn)throws DadosInvalidosException, RegistroException{
        rnFornecedor.salvarNovo(forn);
    }
    public void alterarFornecedor(Fornecedor forn)throws DadosInvalidosException, RegistroException{
        rnFornecedor.atualizarRegistro(forn);
    }
    public void removerFornecedor(Fornecedor forn)throws DadosInvalidosException, RegistroException{
        rnFornecedor.removerRegistro(forn);
    }
    public void pesquisarFornecedor(Fornecedor cli)throws DadosInvalidosException, RegistroException{
        rnFornecedor.pesquisarRegistro(cli);
    }
    public ArrayList<Fornecedor> listarFornecedor()throws RegistroException{
        return rnFornecedor.listarRegistros();
    }
    //Fim da incialização de métodos para Fornecedor
    
    //################################################################################################################
    
    //Começo da incialização de métodos para Funcionario
    public void inserirFuncionario(Funcionario fun)throws DadosInvalidosException, RegistroException{
        rnFuncionario.salvarRegistro(fun);
    }
    public void alterarFuncionario(Funcionario fun)throws DadosInvalidosException, RegistroException{
        rnFuncionario.atualizarRegistro(fun);
    }
    public void removerFuncionario(Funcionario fun)throws DadosInvalidosException, RegistroException{
        rnFuncionario.removerRegistro(fun);
    }
    public Funcionario pesquisarFuncionario(Funcionario fun)throws DadosInvalidosException, RegistroException{
        return rnFuncionario.pesquisarRegistro(fun);
    }
    public ArrayList<Funcionario> listarFuncionario()throws RegistroException{
        return rnFuncionario.listarRegistro();
    }
    //Fim da incialização de métodos para Funcionario
    
    //################################################################################################################
    
    //Começo da incialização de métodos para Pagamento
    public void inserirPagamento(Pagamento pag)throws DadosInvalidosException, RegistroException{
        rnPagamento.inserirRegistro(pag);
    }
    public ArrayList<Pagamento> listarPagamento()throws RegistroException{
        return rnPagamento.listarRegistros();
    }
    //Fim da incialização de métodos para Pagamento
    
    //################################################################################################################
    
    //Começo da incialização de métodos para Venda
    public void InserirVenda(Venda ven)throws DadosInvalidosException, RegistroException{
        rnVenda.salvarNovo(ven);
    }
    //Fim da incialização de métodos para Venda
    
    //################################################################################################################
    
    //Começo da incialização de métodos para Produto
    public void inserirProduto(Produto prod)throws DadosInvalidosException, RegistroException{
        rnProduto.salvarRegistro(prod);
    }
    public void alterarProduto(Produto prod)throws DadosInvalidosException, RegistroException{
        rnProduto.alterarRegistro(prod);
    }
    public void removerProduto(Produto prod)throws DadosInvalidosException, RegistroException{
        rnProduto.removerRegistro(prod);
    }
    public void pesquisarProduto(Produto prod)throws DadosInvalidosException, RegistroException{
        rnProduto.pesquisarRegistro(prod);
    }
    public ArrayList<Produto> listarProduto()throws RegistroException{
        return rnProduto.listarRegistro();
    }
    //Fim da incialização de métodos para Produto
    
    
}
