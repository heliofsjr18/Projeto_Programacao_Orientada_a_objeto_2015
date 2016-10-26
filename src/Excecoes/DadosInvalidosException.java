package Excecoes;

/**
 *
 * @author helio
 */
public class DadosInvalidosException extends Exception {
    public DadosInvalidosException(){
        super();
    }
    public DadosInvalidosException(String messagem){
        super(messagem);
    }
}
