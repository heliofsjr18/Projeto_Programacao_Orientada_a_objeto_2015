
package Negocio.Basica;

/**
 *
 * @author helio
 */
public class Cliente {
    private Integer cli_codigo;
    private String cli_cpf;
    private String cli_nome;
    private String cli_telefone;
    private String cli_endereco;

    /**
     * @return the cli_codigo
     */
    public Integer getCli_codigo() {
        return cli_codigo;
    }

    /**
     * @param cli_codigo the cli_codigo to set
     */
    public void setCli_codigo(Integer cli_codigo) {
        this.cli_codigo = cli_codigo;
    }

    /**
     * @return the cli_cpf
     */
    public String getCli_cpf() {
        return cli_cpf;
    }

    /**
     * @param cli_cpf the cli_cpf to set
     */
    public void setCli_cpf(String cli_cpf) {
        this.cli_cpf = cli_cpf;
    }

    /**
     * @return the cli_nome
     */
    public String getCli_nome() {
        return cli_nome;
    }

    /**
     * @param cli_nome the cli_nome to set
     */
    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    /**
     * @return the cli_telefone
     */
    public String getCli_telefone() {
        return cli_telefone;
    }

    /**
     * @param cli_telefone the cli_telefone to set
     */
    public void setCli_telefone(String cli_telefone) {
        this.cli_telefone = cli_telefone;
    }

    /**
     * @return the cli_endereco
     */
    public String getCli_endereco() {
        return cli_endereco;
    }

    /**
     * @param cli_endereco the cli_endereco to set
     */
    public void setCli_endereco(String cli_endereco) {
        this.cli_endereco = cli_endereco;
    }
    
    public boolean isCpfNull(){
        if(cli_cpf == null)
            return true;
        return false;        
    }
    public boolean isNomeNull(){
        if(cli_nome == null)
            return true;
        return false;        
    }
    public boolean isTelefoneNull(){
        if(cli_telefone == null)
            return true;
        return false;        
    }
    public boolean isEnderecoNull(){
        if(cli_endereco == null)
            return true;
        return false;        
    }
    
}
