
package Negocio.Basica;

/**
 *
 * @author helio
 */
public class Pagamento {
    private Integer pag_codigo;
    private String pag_tipo;
    private Integer pag_qtdParcelas;
    private Double pag_juros;
    private Double pag_desconto;

    /**
     * @return the pag_codigo
     */
    public Integer getPag_codigo() {
        return pag_codigo;
    }

    /**
     * @param pag_codigo the pag_codigo to set
     */
    public void setPag_codigo(Integer pag_codigo) {
        this.pag_codigo = pag_codigo;
    }

    /**
     * @return the pag_tipo
     */
    public String getPag_tipo() {
        return pag_tipo;
    }

    /**
     * @param pag_tipo the pag_tipo to set
     */
    public void setPag_tipo(String pag_tipo) {
        this.pag_tipo = pag_tipo;
    }

    /**
     * @return the pag_qtdParcelas
     */
    public Integer getPag_qtdParcelas() {
        return pag_qtdParcelas;
    }

    /**
     * @param pag_qtdParcelas the pag_qtdParcelas to set
     */
    public void setPag_qtdParcelas(Integer pag_qtdParcelas) {
        this.pag_qtdParcelas = pag_qtdParcelas;
    }

    /**
     * @return the pag_juros
     */
    public Double getPag_juros() {
        return pag_juros;
    }

    /**
     * @param pag_juros the pag_juros to set
     */
    public void setPag_juros(Double pag_juros) {
        this.pag_juros = pag_juros;
    }

    /**
     * @return the pag_desconto
     */
    public Double getPag_desconto() {
        return pag_desconto;
    }

    /**
     * @param pag_desconto the pag_desconto to set
     */
    public void setPag_desconto(Double pag_desconto) {
        this.pag_desconto = pag_desconto;
    }
    
    public boolean isTipoNull(){
        if(pag_tipo == null)
            return true;
        return false;
    }
}
