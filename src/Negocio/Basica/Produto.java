
package Negocio.Basica;

/**
 *
 * @author helio
 */
public class Produto {
    private Integer prod_codigo;
    private Fornecedor forn_codigo;
    private String prod_descricao;
    private Integer prod_qtdEstoque;
    private Double prod_valor;
    
    public Produto(){
        forn_codigo = new Fornecedor();
    }

    /**
     * @return the prod_codigo
     */
    public Integer getProd_codigo() {
        return prod_codigo;
    }

    /**
     * @param prod_codigo the prod_codigo to set
     */
    public void setProd_codigo(Integer prod_codigo) {
        this.prod_codigo = prod_codigo;
    }

    /**
     * @return the forn_codigo
     */
    public Fornecedor getForn_codigo() {
        return forn_codigo;
    }

    /**
     * @param forn_codigo the forn_codigo to set
     */
    public void setForn_codigo(Fornecedor forn_codigo) {
        this.forn_codigo = forn_codigo;
    }

    /**
     * @return the prod_descricao
     */
    public String getProd_descricao() {
        return prod_descricao;
    }

    /**
     * @param prod_descricao the prod_descricao to set
     */
    public void setProd_descricao(String prod_descricao) {
        this.prod_descricao = prod_descricao;
    }

    /**
     * @return the prod_qtdEstoque
     */
    public Integer getProd_qtdEstoque() {
        return prod_qtdEstoque;
    }

    /**
     * @param prod_qtdEstoque the prod_qtdEstoque to set
     */
    public void setProd_qtdEstoque(Integer prod_qtdEstoque) {
        this.prod_qtdEstoque = prod_qtdEstoque;
    }

    /**
     * @return the prod_valor
     */
    public Double getProd_valor() {
        return prod_valor;
    }

    /**
     * @param prod_valor the prod_valor to set
     */
    public void setProd_valor(Double prod_valor) {
        this.prod_valor = prod_valor;
    }
    
    public boolean isQtdEstoqueNull(){
        if(prod_qtdEstoque == null)
            return true;
        return false;
    }
    public boolean isValorNull(){
        if(prod_valor == null)
            return true;
        return false;
    }
    public boolean isFornecedorNull(){
        if(forn_codigo == null)
            return true;
        return false;
    }
}
