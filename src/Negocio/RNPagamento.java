package Negocio;

import Dados.DAOPagamento;
import Dados.DAOPagamentoImpl;
import Excecoes.ConexaoException;
import Excecoes.DadosInvalidosException;
import Excecoes.RegistroException;
import Excecoes.RepositorioException;
import Negocio.Basica.Pagamento;
import java.util.ArrayList;

/**
 *
 * @author helio
 */
public class RNPagamento {
    
    
    private static DAOPagamento instancia;
    
    public RNPagamento(){
        instancia = new DAOPagamentoImpl();
    }
    
    //Verificar Preenchimentos
    //Inserir
    public void inserirRegistro(Pagamento pag)throws DadosInvalidosException, RegistroException{
        
        RNPagamento.verificarPreenchimento(pag);
        
        RNPagamento.inserirNovo(pag);
    }
    //listar registros
    public ArrayList<Pagamento> listarRegistros() throws RegistroException{
        
        return RNPagamento.listarNovo();
    }
    /**
     * Verifica os preenchimentos do objeto e dos campos
     * @param prod Objeto que será verificado
     * @throws DadosInvalidosException Erro de campo não preenchido.
     */
    private static void verificarPreenchimento(Pagamento pag) throws DadosInvalidosException{
        
        if(pag == null)
            throw new DadosInvalidosException("Objeto não preenchido");
        if((pag.isTipoNull()) || (pag.getPag_tipo().trim().length() < 4))
            throw new DadosInvalidosException("Tipo não preenchido ou não é válido");
    }
    /**
     * Insere um novo registro
     * @param pag Objeto que será inserido
     * @throws RegistroException Problemas tecnico(Erro na Conexao com o banco ou Problemas no repositório)
     */ 
    private static void inserirNovo(Pagamento pag) throws RegistroException{
        try {
            instancia.inserir(pag);
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
    /**
     * Listar todos os registros existentes no banco de dados
     * @return Todos os registros do banco de dados
     * @throws RegistroException Problemas Técnicos (Erro na conexão com o banco ou Problemas no repositório)
     */
    private static ArrayList<Pagamento> listarNovo() throws RegistroException{
        try {
            return instancia.listar();
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
}
