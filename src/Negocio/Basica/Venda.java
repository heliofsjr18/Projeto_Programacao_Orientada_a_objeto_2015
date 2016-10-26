package Negocio.Basica;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author helio
 */
public class Venda {
    private Integer ven_codigo;
    private Date ven_data;
    private Double ven_valor;
    private Cliente cli_codigo;
    private Funcionario fun_codigo;
    private Pagamento pag_codigo;
    private ArrayList<VendaProduto> ven_itensDaVenda;
    
    public Venda(){
        fun_codigo = new Funcionario();
        pag_codigo = new Pagamento();
        cli_codigo= new Cliente();
        ven_itensDaVenda = new ArrayList<>();
    }


    /**
     * @return the ven_codigo
     */
    public Integer getVen_codigo() {
        return ven_codigo;
    }

    /**
     * @param ven_codigo the ven_codigo to set
     */
    public void setVen_codigo(Integer ven_codigo) {
        this.ven_codigo = ven_codigo;
    }

    /**
     * @return the ven_data
     */
    public Date getVen_data() {
        return ven_data;
    }

    /**
     * @param ven_data the ven_data to set
     */
    public void setVen_data(Date ven_data) {
        this.ven_data = ven_data;
    }

    /**
     * @return the ven_valor
     */
    public Double getVen_valor() {
        return ven_valor;
    }

    /**
     * @param ven_valor the ven_valor to set
     */
    public void setVen_valor(Double ven_valor) {
        this.ven_valor = ven_valor;
    }

    /**
     * @return the cli_codigo
     */
    public Cliente getCli_codigo() {
        return cli_codigo;
    }

    /**
     * @param cli_codigo the cli_codigo to set
     */
    public void setCli_codigo(Cliente cli_codigo) {
        this.cli_codigo = cli_codigo;
    }

    /**
     * @return the fun_codigo
     */
    public Funcionario getFun_codigo() {
        return fun_codigo;
    }

    /**
     * @param fun_codigo the fun_codigo to set
     */
    public void setFun_codigo(Funcionario fun_codigo) {
        this.fun_codigo = fun_codigo;
    }

    /**
     * @return the pag_codigo
     */
    public Pagamento getPag_codigo() {
        return pag_codigo;
    }

    /**
     * @param pag_codigo the pag_codigo to set
     */
    public void setPag_codigo(Pagamento pag_codigo) {
        this.pag_codigo = pag_codigo;
    }

    /**
     * @return the ven_itensDaVenda
     */
    public ArrayList<VendaProduto> getItensDaVenda() {
        return ven_itensDaVenda;
    }

    /**
     * @param ven_itensDaVenda the ven_itensDaVenda to set
     */
    public void setItensDaVenda(ArrayList<VendaProduto> ven_itensDaVenda) {
        this.ven_itensDaVenda = ven_itensDaVenda;
    }
    
    public boolean isVenDataNull(){
        if(ven_data == null)
            return true;
        return false;
    }
    public boolean isVenValorNull(){
        if(ven_valor == null)
            return true;
        return false;
    }
    public boolean isClienteNull(){
        if(cli_codigo.getCli_codigo() == null)
            return true;
        return false;
    }
    public boolean isPagamentoNull(){
        if(pag_codigo.getPag_codigo() == null)
            return true;
        return false;
    }
    public boolean isFuncionarioNull(){
        if(fun_codigo.getFun_codigo() == null)
            return true;
        return false;
    }
    public boolean isProdutosNull(){
        if(ven_itensDaVenda.isEmpty())
            return true;
        return false;
    }
}
