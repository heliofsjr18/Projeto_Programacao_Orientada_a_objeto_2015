package Negocio;

import Dados.DAOCliente;
import Dados.DAOClienteImpl;
import Excecoes.ConexaoException;
import Excecoes.DadosInvalidosException;
import Excecoes.RegistroException;
import Excecoes.RepositorioException;
import Negocio.Basica.Cliente;
import java.util.ArrayList;

/**
 *
 * @author helio
 */
public class RNCliente {
    
    private static DAOCliente instancia;
    
    public RNCliente(){
         instancia =  new DAOClienteImpl();
    }
    
    //Verificar Preenchimento
    //Verifica Dupicidade
    //Insere dados no banco
    public void salvarRegistro(Cliente cli) throws DadosInvalidosException, RegistroException{
        
        RNCliente.verificarPreenchimento(cli);
        
        RNCliente.verificarDuplicidade(cli);
        
        RNCliente.inserirNovo(cli);
        
    }
    
    //Verificar Preenchimento
    //Verifica Existência
    //Atualizar dados no banco
    public void atualizarRegistro(Cliente cli) throws DadosInvalidosException, RegistroException{
        
        RNCliente.verificarPreenchimento(cli);
        
        RNCliente.verificarExistencia(cli);
        
        RNCliente.atualizarNovo(cli);
    }
    
    //Verifica Existência
    //Remover Registro do banco de dados
    public void removerRegistro(Cliente cli) throws DadosInvalidosException, RegistroException{
        
        RNCliente.verificarExistencia(cli.getCli_cpf());
        
        RNCliente.removerNovo(cli.getCli_cpf());
        
    }
    
    //Verificar preenchimento
    //Verifica Existência
    //Pesquisar Registro no banco de dados
    public Cliente pesquisarRegistro(Cliente cli) throws DadosInvalidosException, RegistroException{
        
        RNCliente.verificarPreenchimento(cli);
        
        RNCliente.verificarExistencia(cli);
        
        return RNCliente.pesquisarNovo(cli.getCli_cpf());
    }
    
    //Listar Resgistros no banco...
    public ArrayList<Cliente> listarRegistro() throws RegistroException{
        
        return RNCliente.listarNovo();
    }
    
    
 
    
    /*############################################################################
         SEPARAR AS FUNCIONALIDADES DAS FUNÇÕES INTERNAS DA REGRA DE NEGÓCIO
    ############################################################################*/
    
    
    
    
    /**
     * Veirifica os preenchimentos do objeto e dos campos
     * @param cli Objeto que será verificado
     * @throws DadosInvalidosException Erro de campo não preenchido.
     */
    private static void verificarPreenchimento(Cliente cli) throws DadosInvalidosException{
        
        if(cli == null)
            throw new DadosInvalidosException("Objeto não preenchido");
        if((cli.isCpfNull()) || (cli.getCli_cpf().trim().length() < 10))
            throw new DadosInvalidosException("CPF não preenchido ou não é válido");
        if((cli.isNomeNull()) || (cli.getCli_nome().trim().length() < 5))
            throw new DadosInvalidosException("Nome não preenchido ou não é válido");
        if((cli.isEnderecoNull()) || (cli.getCli_endereco().trim().length() < 10))
            throw new DadosInvalidosException("Enderco não preenchido ou não é válido");
        if((cli.isTelefoneNull()) || (cli.getCli_telefone().trim().length() < 8))
            throw new DadosInvalidosException("Telefone não preenchido ou não é válido");
            
    }
    
    /**
     * Verifica Se já consta no banco de dados o novo cadastro solicitado
     * @param cli Objeto para a verificação
     * @throws DadosInvalidosException Caso já haja um cadastro, impedir a ação
     * @throws RegistroException Problemas técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void verificarDuplicidade(Cliente cli) throws DadosInvalidosException, RegistroException{
        try {
            Cliente verificaCli = instancia.pesquisar(cli.getCli_cpf());
            if(verificaCli != null)
                throw new DadosInvalidosException("CPF informado já cadastrado!!!");
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    
    /**
     * Verifica a existencia de um cadastro no banco de dados
     * @param cli Objeto que será verificado
     * @throws DadosInvalidosException Caso o cadastro informado não exista no banco, informar ao usuário
     * @throws RegistroException Problemas técnico (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void verificarExistencia(Cliente cli) throws DadosInvalidosException, RegistroException{
        try {
            Cliente verificaCliExist = instancia.pesquisar(cli.getCli_cpf());
            if(verificaCliExist == null)
                throw new DadosInvalidosException("Cliente não existe no Banco de dados");
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
            Cliente verificaCliExist = instancia.pesquisar(cpf);
            if(verificaCliExist == null)
                throw new DadosInvalidosException("Cliente não existe no Banco de dados");
        } catch (RepositorioException | ConexaoException e) {
            throw new RegistroException(e.getMessage());            
        }
    }
    
    /**
     * Insere um novo registro
     * @param cli Objeto que será inserido
     * @throws RegistroException Problemas tecnico(Erro na Conexao com o banco ou Problemas no repositório)
     */ 
    private static void inserirNovo(Cliente cli) throws RegistroException{
        try {
            instancia.inserir(cli);
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }    
    
    /**
     * Atualizar um novo Registro no banco de dados
     * @param cli Objeto que será atualizado
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static void atualizarNovo(Cliente cli) throws RegistroException{
        try {
            instancia.atualizar(cli);
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
    private static Cliente pesquisarNovo(String cpf) throws RegistroException{
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
    private static ArrayList<Cliente> listarNovo() throws RegistroException{
        try {
            return instancia.listar();
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
}
