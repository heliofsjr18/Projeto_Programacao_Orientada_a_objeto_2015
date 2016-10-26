package Dados;

import Excecoes.ConexaoException;
import Excecoes.RepositorioException;
import Negocio.Basica.Produto;
import java.util.ArrayList;

/**
 *
 * @author helio
 */
public interface DAOProduto {
    /**
     * Insere um novo Cadastro no Banco de dados
     * @param prod Objeto de cadastro que será inserido
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void inserir(Produto prod) throws RepositorioException, ConexaoException;
    /**
     * Atualiza um cadastro existente no banco de dados
     * @param prod Cadastro que será atualizado
     * @param codigo Codigo do Cadastro que será atualizado
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void atualizar(Produto prod, Integer codigo) throws RepositorioException, ConexaoException;
    /**
     * Remove um cadastro existente no banco de dados
     * @param codigo Codigo do cadastro que será removido
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public void remover(Integer codigo) throws RepositorioException, ConexaoException;
    /**
     * Pesquisar um Cadastro existente no banco de dados
     * @param codigo codigo do cadastro que será usado na pesquisa
     * @return retorna um cadastro existente no banco de dados
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */ 
    public Produto pesquisar (Integer codigo) throws RepositorioException, ConexaoException;    
    /**
     * Listar todos os cadastros existentes no banco de dados
     * @return Retorna uma lista com todos os cadastros armazenados no banco de dados
     * @throws RepositorioException Erro no repositório
     * @throws ConexaoException Erro na conexao com o banco de dados
     */
    public ArrayList<Produto> listar() throws RepositorioException, ConexaoException;
}
