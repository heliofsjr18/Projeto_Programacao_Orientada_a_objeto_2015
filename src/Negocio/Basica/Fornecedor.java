
package Negocio.Basica;

/**
 *
 * @author helio
 */
public class Fornecedor {
    private Integer forn_codigo;
    private String forn_cnpj;
    private String forn_razaoSocial;

    /**
     * @return the forn_codigo
     */
    public Integer getForn_codigo() {
        return forn_codigo;
    }

    /**
     * @param forn_codigo the forn_codigo to set
     */
    public void setForn_codigo(Integer forn_codigo) {
        this.forn_codigo = forn_codigo;
    }

    /**
     * @return the forn_cnpj
     */
    public String getForn_cnpj() {
        return forn_cnpj;
    }

    /**
     * @param forn_cnpj the forn_cnpj to set
     */
    public void setForn_cnpj(String forn_cnpj) {
        this.forn_cnpj = forn_cnpj;
    }

    /**
     * @return the forn_razaoSocial
     */
    public String getForn_razaoSocial() {
        return forn_razaoSocial;
    }

    /**
     * @param forn_razaoSocial the forn_razaoSocial to set
     */
    public void setForn_razaoSocial(String forn_razaoSocial) {
        this.forn_razaoSocial = forn_razaoSocial;
    }
    
    public boolean isCnpjNull(){
        if(forn_cnpj == null)
            return true;
        return false;
    }
    public boolean isRazaoSocialNull(){
        if(forn_razaoSocial == null)
            return true;
        return false;
    }
    
}
