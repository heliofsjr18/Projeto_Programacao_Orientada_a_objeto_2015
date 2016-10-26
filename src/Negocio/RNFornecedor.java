package Negocio;

import Dados.DAOFornecedor;
import Dados.DAOFornecedorImpl;
import Excecoes.ConexaoException;
import Excecoes.DadosInvalidosException;
import Excecoes.RegistroException;
import Excecoes.RepositorioException;
import Negocio.Basica.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author helio
 */
public class RNFornecedor {
    
    private static DAOFornecedor instancia;
    
    public RNFornecedor(){
        instancia = new DAOFornecedorImpl();
    }
    
    //Verificar preenchimento
    //verificar duplicidade
    //Inserir dados no banco    
    public void salvarNovo(Fornecedor forn) throws DadosInvalidosException, RegistroException{
        
        RNFornecedor.verificarPreenchimento(forn);
        
        RNFornecedor.verificarDuplicidade(forn.getForn_cnpj());
        
        RNFornecedor.inserirNovo(forn);
    }
    
    //Verificar preenchimento
    //verificar Existência
    //Atualizar dados no banco    
    public void atualizarRegistro(Fornecedor forn) throws DadosInvalidosException, RegistroException{
        
        RNFornecedor.verificarPreenchimento(forn);
        
        RNFornecedor.verificarExistencia(forn.getForn_cnpj());
        
        RNFornecedor.atualizarNovo(forn);
    }
    
    //verificar Existência
    //Remove dados no banco    
    public void removerRegistro(Fornecedor forn) throws DadosInvalidosException, RegistroException{
        
        RNFornecedor.verificarExistencia(forn.getForn_cnpj());
        
        RNFornecedor.removerNovo(forn.getForn_cnpj());
    }
    
    //verificar Existência
    //Remove dados no banco    
    public Fornecedor pesquisarRegistro(Fornecedor forn) throws DadosInvalidosException, RegistroException{
        
        RNFornecedor.verificarExistencia(forn.getForn_cnpj());
        
        return RNFornecedor.pesquisarNovo(forn);
    }
    
    //verificar Existência
    //Remove dados no banco    
    public ArrayList<Fornecedor> listarRegistros() throws RegistroException{
        
        return RNFornecedor.listarNovo();
    }
    
    
 
    
    /*############################################################################
         SEPARAR AS FUNCIONALIDADES DAS FUNÇÕES INTERNAS DA REGRA DE NEGÓCIO
    ############################################################################*/
    
    
    
    
    /**
     *  os preenchimentos do objeto e dos campos
     * @param forn Objeto que será verificado
     * @throws DadosInvalidosException Erro de campo não preenchido.
     */
    private static void verificarPreenchimento(Fornecedor forn) throws DadosInvalidosException{
        
        if(forn == null)
            throw new DadosInvalidosException("Objeto não preenchido");
        if((forn.isCnpjNull()) || (forn.getForn_cnpj().trim().length() < 5))
            throw new DadosInvalidosException("CNPJ não preenchido ou não é válido");
        if((forn.isRazaoSocialNull()) || (forn.getForn_razaoSocial().trim().length() < 3))
            throw new DadosInvalidosException("Razão Social não preenchido ou não é válido");
    }   
    /**
     * Verifica Se já consta no banco de dados o novo cadastro solicitado
     * @param cnpj Objeto para a verificação
     * @throws DadosInvalidosException Caso já haja um cadastro, impedir a ação
     * @throws RegistroException Problemas técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void verificarDuplicidade(String cnpj) throws DadosInvalidosException, RegistroException{
        
        try {
            Fornecedor verificaForn = instancia.pesquisar(cnpj);
            if(verificaForn != null)
                throw new DadosInvalidosException("Cadastro de fornecedor já consta no banco de dados");
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }   
    /**
     * Verifica a existencia de um cadastro no banco de dados
     * @param cnpj Objeto que será verificado
     * @throws DadosInvalidosException Caso o cadastro informado não exista no banco, informar ao usuário
     * @throws RegistroException Problemas técnico (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void verificarExistencia(String cnpj) throws DadosInvalidosException, RegistroException{
        
        try {
            Fornecedor verificaFornExiste = instancia.pesquisar(cnpj);
            if(verificaFornExiste != null)
                throw new DadosInvalidosException("Cadastro de forncedor não existe no banco de dados");
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }   
    /**
     * Insere um novo registro
     * @param forn Objeto que será inserido
     * @throws RegistroException Problemas tecnico(Erro na Conexao com o banco ou Problemas no repositório)
     */ 
    private static void inserirNovo(Fornecedor forn) throws RegistroException{
        
        try {
            instancia.inserir(forn);
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    
    /**
     * Atualizar um novo Registro no banco de dados
     * @param forn Objeto que será atualizado
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void atualizarNovo(Fornecedor forn) throws DadosInvalidosException, RegistroException{
        
        try {
            instancia.atualizar(forn);
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }    
    /**
     * Remover um registro existente no banco de dados
     * @param cnpj Registro que será removido
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void removerNovo(String cnpj) throws RegistroException{
        
        try {
            instancia.remover(cnpj);
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    /**
     * Pesquisar um registro existente no banco de dados
     * @param forn objeto que será pesquisado
     * @return Um registro do banco de dados
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static Fornecedor pesquisarNovo(Fornecedor forn) throws RegistroException{
        
        try {
            return instancia.pesquisar(forn.getForn_cnpj());
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    /**
     * Listar todos os registros existentes no banco de dados
     * @return Todos os registros do banco de dados
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static ArrayList<Fornecedor> listarNovo() throws RegistroException{
        
        try {
            return instancia.listar();
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
}
