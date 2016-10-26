
package Negocio.Basica;

/**
 *
 * @author helio
 */
public class VendaProduto {
    private Integer venProd_codigo;
    private Produto prod_codigo;
    private Venda ven_codigo;
    private Integer venProd_qtdProduto;
    private Double venProd_valorProdutoUnitario;
    private Double venProd_valorTotal;

    public VendaProduto(){
        prod_codigo = new Produto();
        ven_codigo = new Venda();
    }
    /**
     * @return the venProd_codigo
     */
    public Integer getVenProd_codigo() {
        return venProd_codigo;
    }

    /**
     * @param venProd_codigo the venProd_codigo to set
     */
    public void setVenProd_codigo(Integer venProd_codigo) {
        this.venProd_codigo = venProd_codigo;
    }

    /**
     * @return the prod_codigo
     */
    public Produto getProd_codigo() {
        return prod_codigo;
    }

    /**
     * @param prod_codigo the prod_codigo to set
     */
    public void setProd_codigo(Produto prod_codigo) {
        this.prod_codigo = prod_codigo;
    }

    /**
     * @return the ven_codigo
     */
    public Venda getVen_codigo() {
        return ven_codigo;
    }

    /**
     * @param ven_codigo the ven_codigo to set
     */
    public void setVen_codigo(Venda ven_codigo) {
        this.ven_codigo = ven_codigo;
    }

    /**
     * @return the venProd_qtdProduto
     */
    public Integer getVenProd_qtdProduto() {
        return venProd_qtdProduto;
    }

    /**
     * @param venProd_qtdProduto the venProd_qtdProduto to set
     */
    public void setVenProd_qtdProduto(Integer venProd_qtdProduto) {
        this.venProd_qtdProduto = venProd_qtdProduto;
    }

    /**
     * @return the venProd_valorProdutoUnitario
     */
    public Double getVenProd_valorProdutoUnitario() {
        return venProd_valorProdutoUnitario;
    }

    /**
     * @param venProd_valorProdutoUnitario the venProd_valorProdutoUnitario to set
     */
    public void setVenProd_valorProdutoUnitario(Double venProd_valorProdutoUnitario) {
        this.venProd_valorProdutoUnitario = venProd_valorProdutoUnitario;
    }

    /**
     * @return the venProd_valorTotal
     */
    public Double getVenProd_valorTotal() {
        return venProd_valorTotal;
    }

    /**
     * @param venProd_valorTotal the venProd_valorTotal to set
     */
    public void setVenProd_valorTotal(Double venProd_valorTotal) {
        this.venProd_valorTotal = venProd_valorTotal;
    }
    
    public boolean isQtdProdutoNull(){
        if(venProd_qtdProduto == null)
            return true;
        return false;
    }
    public boolean isValorProdutoUnitarioNull(){
        if(venProd_valorProdutoUnitario == null)
            return true;
        return false;
    }
    public boolean isValorTotalNull(){
        if(venProd_valorTotal == null)
            return true;
        return false;
    }
}
