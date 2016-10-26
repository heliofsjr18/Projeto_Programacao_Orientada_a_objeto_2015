package Negocio;

import Dados.DAOFuncionario;
import Dados.DAOFuncionarioImpl;
import Excecoes.ConexaoException;
import Excecoes.DadosInvalidosException;
import Excecoes.RegistroException;
import Excecoes.RepositorioException;
import Negocio.Basica.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author helio
 */
public class RNFuncionario {
    
    private static DAOFuncionario instancia;
    
    public RNFuncionario(){
        instancia = new DAOFuncionarioImpl();
    }
    
    //Verificar Preenchimento
    //Verifica Dupicidade
    //Insere dados no banco
    public void salvarRegistro(Funcionario fun) throws DadosInvalidosException, RegistroException{
        
        RNFuncionario.verificarPreenchimento(fun);
        
        RNFuncionario.verificarDuplicidade(fun);
        
        RNFuncionario.inserirNovo(fun);
        
    }
    
    //Verificar Preenchimento
    //Verifica Existência
    //Atualizar dados no banco
    public void atualizarRegistro(Funcionario fun) throws DadosInvalidosException, RegistroException{
        
        RNFuncionario.verificarPreenchimento(fun);
        
        RNFuncionario.verificarExistencia(fun);
        
        RNFuncionario.atualizarNovo(fun);
    }
    
    //Verifica Existência
    //Remover Registro do banco de dados
    public void removerRegistro(Funcionario fun) throws DadosInvalidosException, RegistroException{
        
        RNFuncionario.verificarExistencia(fun.getFun_cpf());
        
        RNFuncionario.removerNovo(fun.getFun_cpf());
        
    }
    
    //Verificar preenchimento
    //Verifica Existência
    //Pesquisar Registro no banco de dados
    public Funcionario pesquisarRegistro(Funcionario fun) throws DadosInvalidosException, RegistroException{
        
        RNFuncionario.verificarPreenchimento(fun);
        
        RNFuncionario.verificarExistencia(fun);
        
        return RNFuncionario.pesquisarNovo(fun.getFun_cpf());
    }
    
    //Listar Resgistros no banco...
    public ArrayList<Funcionario> listarRegistro() throws RegistroException{
        
        return RNFuncionario.listarNovo();
    }
    
    
 
    
    /*############################################################################
         SEPARAR AS FUNCIONALIDADES DAS FUNÇÕES INTERNAS DA REGRA DE NEGÓCIO
    ############################################################################*/
    
    
    
    
    /**
     * Veirifica os preenchimentos do objeto e dos campos
     * @param cli Objeto que será verificado
     * @throws DadosInvalidosException Erro de campo não preenchido.
     */
    private static void verificarPreenchimento(Funcionario fun) throws DadosInvalidosException{
        
        if(fun == null)
            throw new DadosInvalidosException("Objeto não preenchido");
        if((fun.isCpfNull()) || (fun.getFun_cpf().trim().length() < 10))
            throw new DadosInvalidosException("CPF não preenchido ou não é válido");
        if((fun.isNomeNull()) || (fun.getFun_nome().trim().length() < 5))
            throw new DadosInvalidosException("Nome não preenchido ou não é válido");
        if((fun.isLoginNull()) || (fun.getFun_login().trim().length() < 10))
            throw new DadosInvalidosException("Login não preenchido ou não é válido");
        if((fun.isSenhaNull()) || (fun.getFun_senha().trim().length() < 5))
            throw new DadosInvalidosException("Senha não preenchido ou não é válido");
        if((fun.isTelefoneNull()) || (fun.getFun_telefone().trim().length() < 8))
            throw new DadosInvalidosException("Telefone não preenchido ou não é válido");
            
    }
    /**
     * Verifica Se já consta no banco de dados o novo cadastro solicitado
     * @param cli Objeto para a verificação
     * @throws DadosInvalidosException Caso já haja um cadastro, impedir a ação
     * @throws RegistroException Problemas técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void verificarDuplicidade(Funcionario fun) throws DadosInvalidosException, RegistroException{
        try {
            Funcionario verificaFun = instancia.pesquisar(fun.getFun_cpf());
            if(verificaFun != null)
                throw new DadosInvalidosException("CPF informado já cadastrado!!!");
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    /**
     * Verifica a existencia de um cadastro no banco de dados
     * @param fun Objeto que será verificado
     * @throws DadosInvalidosException Caso o cadastro informado não exista no banco, informar ao usuário
     * @throws RegistroException Problemas técnico (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void verificarExistencia(Funcionario fun) throws DadosInvalidosException, RegistroException{
        try {
            Funcionario verificaFunExist = instancia.pesquisar(fun.getFun_cpf());
            if(verificaFunExist == null)
                throw new DadosInvalidosException("Funcionário não existe no Banco de dados");
        } catch (RepositorioException | ConexaoException e) {
            throw new RegistroException(e.getMessage());            
        }
    }
    /**
     * Verifica a existencia de um cadastro no banco de dados
     * @param cpf cpf que será verificado
     * @throws DadosInvalidosException Caso o cadastro informado não exista no banco, informar ao usuário
     * @throws RegistroException Problemas técnico (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void verificarExistencia(String cpf) throws DadosInvalidosException, RegistroException{
        try {
            Funcionario verificaFunExist = instancia.pesquisar(cpf);
            if(verificaFunExist == null)
                throw new DadosInvalidosException("Funcionario não existe no Banco de dados");
        } catch (RepositorioException | ConexaoException e) {
            throw new RegistroException(e.getMessage());            
        }
    }
    /**
     * Insere um novo registro
     * @param fun Objeto que será inserido
     * @throws RegistroException Problemas tecnico(Erro na Conexao com o banco ou Problemas no repositório)
     */ 
    private static void inserirNovo(Funcionario fun) throws RegistroException{
        try {
            instancia.inserir(fun);
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }    
    /**
     * Atualizar um novo Registro no banco de dados
     * @param fun Objeto que será atualizado
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void atualizarNovo(Funcionario fun) throws RegistroException{
        try {
            instancia.atualizar(fun);
        } catch (RepositorioException | ConexaoException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    /**
     * Remover um registro existente no banco de dados
     * @param cpf Registro que será removido
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void removerNovo(String cpf) throws RegistroException{
        try {
            instancia.remover(cpf);
        } catch (RepositorioException | ConexaoException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    /**
     * Pesquisar um registro existente no banco de dados
     * @param cli objeto que será pesquisado
     * @return Um registro do banco de dados
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static Funcionario pesquisarNovo(String cpf) throws RegistroException{
        try {
            return instancia.pesquisar(cpf);
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    /**
     * Listar todos os registros existentes no banco de dados
     * @return Todos os registros do banco de dados
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static ArrayList<Funcionario> listarNovo() throws RegistroException{
        try {
            return instancia.listar();
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
}
