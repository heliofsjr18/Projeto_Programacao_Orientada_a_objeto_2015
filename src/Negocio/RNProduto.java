package Negocio;

import Dados.DAOProduto;
import Dados.DAOProdutoImpl;
import Excecoes.ConexaoException;
import Excecoes.DadosInvalidosException;
import Excecoes.RegistroException;
import Excecoes.RepositorioException;
import Negocio.Basica.Produto;
import java.util.ArrayList;

/**
 *
 * @author helio
 */
public class RNProduto {
    
    private static DAOProduto instancia;
    
    public RNProduto(){
        instancia = new DAOProdutoImpl();
    }
    
    //Verificar Preenchimento
    //Inserir dados no banco
    public void salvarRegistro(Produto prod) throws RegistroException, DadosInvalidosException{
        
        RNProduto.verificarPreenchimento(prod);
        
        RNProduto.inserirNovo(prod);
        
    }
    
    //Verificar Preenchimento
    //Verificar Existencia
    //Alterar dados no banco
    public void alterarRegistro(Produto prod) throws RegistroException, DadosInvalidosException{
        
        RNProduto.verificarPreenchimento(prod);
        
        RNProduto.verificarExistencia(prod);
        
        RNProduto.atualizarNovo(prod);
    }
    //Verificar Existencia
    //Remover dados no banco
    public void removerRegistro(Produto prod)throws RegistroException, DadosInvalidosException{
        
        RNProduto.verificarExistencia(prod);
        
        RNProduto.removerNovo(prod.getProd_codigo());
    }    
    //Verificar Preenchimento
    //Verificar Existencia
    //Pesquisar dados no banco
    public Produto pesquisarRegistro(Produto prod) throws RegistroException, DadosInvalidosException{
        
        RNProduto.verificarPreenchimento(prod);
        
        RNProduto.verificarExistencia(prod);
        
        return RNProduto.pesquisarNovo(prod.getProd_codigo());
    }
    //Listar todos os registros
    public ArrayList<Produto> listarRegistro()throws RegistroException{
        
        return RNProduto.listarNovo();
    }
    
    
 
    
    /*############################################################################
         SEPARAR AS FUNCIONALIDADES DAS FUNÇÕES INTERNAS DA REGRA DE NEGÓCIO
    ############################################################################*/
    
    
    
    
    /**
     * Verifica os preenchimentos do objeto e dos campos
     * @param prod Objeto que será verificado
     * @throws DadosInvalidosException Erro de campo não preenchido.
     */
    private static void verificarPreenchimento(Produto prod) throws DadosInvalidosException{
        
        if(prod == null)
            throw new DadosInvalidosException("Objeto não preenchido");
        if((prod.isQtdEstoqueNull()) || (prod.getProd_qtdEstoque() < 0))
            throw new DadosInvalidosException("Quantidade em estoque não preenchido ou não é válido");
        if((prod.isValorNull()) || (prod.getProd_valor() < 0.5))
            throw new DadosInvalidosException("Valor não preenchido ou não é válido");            
        if(prod.isValorNull())
            throw new DadosInvalidosException("Codgo do fornecedor não preenchido ou não é válido");            
    }
    /**
     * Verifica a existencia de um cadastro no banco de dados
     * @param prod Objeto que será verificado
     * @throws DadosInvalidosException Caso o cadastro informado não exista no banco, informar ao usuário
     * @throws RegistroException Problemas técnico (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void verificarExistencia(Produto prod) throws DadosInvalidosException, RegistroException{
        try {
            Produto verificaProdExist = instancia.pesquisar(prod.getProd_codigo());
            if(verificaProdExist == null)
                throw new DadosInvalidosException("Produto não existe no Banco de dados");
        } catch (RepositorioException | ConexaoException e) {
            throw new RegistroException(e.getMessage());            
        }
    }
    /**
     * Remover um registro existente no banco de dados
     * @param codigo Registro que será removido
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void removerNovo(Integer codigo) throws RegistroException{
        try {
            instancia.remover(codigo);
        } catch (RepositorioException | ConexaoException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    /**
     * Atualizar um novo Registro no banco de dados
     * @param prod Objeto que será atualizado
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void atualizarNovo(Produto prod) throws RegistroException{
        try {
            instancia.atualizar(prod, prod.getProd_codigo());
        } catch (RepositorioException | ConexaoException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    /**
     * Insere um novo registro
     * @param prod Objeto que será inserido
     * @throws RegistroException Problemas tecnico(Erro na Conexao com o banco ou Problemas no repositório)
     */ 
    private static void inserirNovo(Produto prod) throws RegistroException{
        try {
            instancia.inserir(prod);
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    /**
     * Pesquisar um registro existente no banco de dados
     * @param codigo objeto que será pesquisado
     * @return Um registro do banco de dados
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static Produto pesquisarNovo(Integer codigo) throws RegistroException{
        try {
            return instancia.pesquisar(codigo);
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    /**
     * Listar todos os registros existentes no banco de dados
     * @return Todos os registros do banco de dados
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static ArrayList<Produto> listarNovo() throws RegistroException{
        try {
            return instancia.listar();
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
}
