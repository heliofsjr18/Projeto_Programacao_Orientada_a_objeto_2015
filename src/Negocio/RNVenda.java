package Negocio;

import Dados.DAOVenda;
import Dados.DAOVendaImpl;
import Excecoes.ConexaoException;
import Excecoes.DadosInvalidosException;
import Excecoes.RegistroException;
import Excecoes.RepositorioException;
import Negocio.Basica.Venda;

/**
 *
 * @author helio
 */
public class RNVenda {
    
    private static DAOVenda instancia;
    
    public RNVenda(){
        instancia = new DAOVendaImpl();
    }
    
    //Verificar Preenchimento
    //inserir uma nova venda
    public void salvarNovo(Venda ven) throws DadosInvalidosException, RegistroException{
        
        RNVenda.verificarPreenchimento(ven);
        
        RNVenda.inserirNovo(ven);
    }
    
    /**
     * Verifica os preenchimentos do objeto e dos campos
     * @param prod Objeto que será verificado
     * @throws DadosInvalidosException Erro de campo não preenchido.
     */
    private static void verificarPreenchimento(Venda ven) throws DadosInvalidosException{
        
        if(ven == null)
            throw new DadosInvalidosException("Objeto não preenchido");
        if(ven.isClienteNull())
            throw new DadosInvalidosException("Cliente não preenchido ou não é válido");
        if(ven.isFuncionarioNull())
            throw new DadosInvalidosException("Funcionario não preenchido ou não é válido");
        if(ven.isPagamentoNull())
            throw new DadosInvalidosException("Pagamento não preenchido ou não é válido");
        if(ven.isProdutosNull())
            throw new DadosInvalidosException("Produtos não preenchido ou não é válido");
        if(ven.isVenDataNull())
            throw new DadosInvalidosException("Campo Data não preenchido ou não é válido");
        if(ven.isVenValorNull())
            throw new DadosInvalidosException("Valor não preenchido ou não é válido");
    }
    /**
     * Insere um novo registro
     * @param ven Objeto que será inserido
     * @throws RegistroException Problemas tecnico(Erro na Conexao com o banco ou Problemas no repositório)
     */ 
    private static void inserirNovo(Venda ven) throws RegistroException{
        try {
            instancia.inserir(ven);
        } catch (ConexaoException | RepositorioException e) {
            throw new RegistroException(e.getMessage());
        }
    }
}


