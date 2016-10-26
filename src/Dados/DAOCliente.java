package Dados;

import Excecoes.ConexaoException;
import Excecoes.RepositorioException;
import Negocio.Basica.Cliente;
import java.util.ArrayList;

/**
 *
 * @author helio
 */
public interface DAOCliente {
    
    /**
     * Insere um novo Cadastro no Banco de dados
     * @param cli Objeto de cadastro que será inserido
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void inserir(Cliente cli) throws RepositorioException, ConexaoException;
    /**
     * Atualiza um cadastro existente no banco de dados
     * @param cli Cadastro que será atualizado
     * @param codigo Codigo do cadastro que será atualizado.
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void atualizar(Cliente cli, Integer codigo) throws RepositorioException, ConexaoException;
    /**
     * Atualiza um cadastro existente no banco de dados
     * @param cli Cadastro que será atualizado
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void atualizar(Cliente cli) throws RepositorioException, ConexaoException;
    /**
     * Remove um cadastro existente no banco de dados
     * @param codigo Codigo do cadastro que será removido
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void remover(Integer codigo) throws RepositorioException, ConexaoException;
    /**
     * Remove um cadastro existente no banco de dados
     * @param cpf Cpf do cadastro que será removido
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void remover(String cpf) throws RepositorioException, ConexaoException;
    /**
     * Pesquisar um Cadastro existente no banco de dados
     * @param codigo codigo do cadastro que será usado na pesquisa
     * @return retorna um cadastro existente no banco de dados
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */ 
    public Cliente pesquisar (Integer codigo) throws RepositorioException, ConexaoException;    
    /**
     * Pesquisar um Cadastro existente no banco de dados
     * @param cpf Cpf do cadastro que será usado na pesquisa
     * @return retorna um cadastro existente no banco de dados
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */ 
    public Cliente pesquisar (String cpf) throws RepositorioException, ConexaoException;
    /**
     * Listar todos os cadastros existentes no banco de dados
     * @return Retorna uma lista com todos os cadastros armazenados no banco de dados
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public ArrayList<Cliente> listar() throws RepositorioException, ConexaoException;
}
