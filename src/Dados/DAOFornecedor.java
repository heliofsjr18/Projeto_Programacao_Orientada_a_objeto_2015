package Dados;

import Excecoes.ConexaoException;
import Excecoes.RepositorioException;
import Negocio.Basica.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author helio
 */
public interface DAOFornecedor {
    /**
     * Insere um novo Cadastro no Banco de dados
     * @param forn Objeto de cadastro que será inserido
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void inserir(Fornecedor forn) throws RepositorioException, ConexaoException;
    /**
     * Atualiza um cadastro existente no banco de dados
     * @param forn Cadastro que será atualizado
     * @param codigo Codigo do cadastro que será atualizado
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void atualizar(Fornecedor forn, Integer codigo) throws RepositorioException, ConexaoException;
    /**
     * Atualiza um cadastro existente no banco de dados
     * @param forn Cadastro que será atualizado     
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void atualizar(Fornecedor forn) throws RepositorioException, ConexaoException;
    /**
     * Remove um cadastro existente no banco de dados
     * @param codigo Codigo do cadastro que será removido
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void remover(Integer codigo) throws RepositorioException, ConexaoException;
    /**
     * Remove um cadastro existente no banco de dados
     * @param cnpj Cnpj do cadastro que será removido
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void remover(String cnpj) throws RepositorioException, ConexaoException;
    /**
     * Pesquisar um Cadastro existente no banco de dados
     * @param codigo codigo do cadastro que será usado na pesquisa
     * @return retorna um cadastro existente no banco de dados
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */ 
    public Fornecedor pesquisar (Integer codigo) throws RepositorioException, ConexaoException;    
    /**
     * Pesquisar um Cadastro existente no banco de dados
     * @param cnpj Cnpj do cadastro que será usado na pesquisa
     * @return retorna um cadastro existente no banco de dados
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */ 
    public Fornecedor pesquisar (String cnpj) throws RepositorioException, ConexaoException;
    /**
     * Listar todos os cadastros existentes no banco de dados
     * @return Retorna uma lista com todos os cadastros armazenados no banco de dados
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public ArrayList<Fornecedor> listar() throws RepositorioException, ConexaoException;
}
