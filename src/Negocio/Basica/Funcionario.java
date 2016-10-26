
package Negocio.Basica;

/**
 *
 * @author helio
 */
public class Funcionario {
    private Integer fun_codigo;
    private String fun_cpf;
    private String fun_nome;
    private String fun_telefone;
    private String fun_login;
    private String fun_senha;

    /**
     * @return the fun_codigo
     */
    public Integer getFun_codigo() {
        return fun_codigo;
    }

    /**
     * @param fun_codigo the fun_codigo to set
     */
    public void setFun_codigo(Integer fun_codigo) {
        this.fun_codigo = fun_codigo;
    }

    /**
     * @return the fun_cpf
     */
    public String getFun_cpf() {
        return fun_cpf;
    }

    /**
     * @param fun_cpf the fun_cpf to set
     */
    public void setFun_cpf(String fun_cpf) {
        this.fun_cpf = fun_cpf;
    }

    /**
     * @return the fun_nome
     */
    public String getFun_nome() {
        return fun_nome;
    }

    /**
     * @param fun_nome the fun_nome to set
     */
    public void setFun_nome(String fun_nome) {
        this.fun_nome = fun_nome;
    }

    /**
     * @return the fun_telefone
     */
    public String getFun_telefone() {
        return fun_telefone;
    }

    /**
     * @param fun_telefone the fun_telefone to set
     */
    public void setFun_telefone(String fun_telefone) {
        this.fun_telefone = fun_telefone;
    }

    /**
     * @return the fun_login
     */
    public String getFun_login() {
        return fun_login;
    }

    /**
     * @param fun_login the fun_login to set
     */
    public void setFun_login(String fun_login) {
        this.fun_login = fun_login;
    }

    /**
     * @return the fun_senha
     */
    public String getFun_senha() {
        return fun_senha;
    }

    /**
     * @param fun_senha the fun_senha to set
     */
    public void setFun_senha(String fun_senha) {
        this.fun_senha = fun_senha;
    }
    
    public boolean isCpfNull(){
        if(fun_cpf == null)
            return true;
        return false;        
    }
    public boolean isNomeNull(){
        if(fun_nome == null)
            return true;
        return false;        
    }
    public boolean isTelefoneNull(){
        if(fun_telefone == null)
            return true;
        return false;        
    }
    public boolean isLoginNull(){
        if(fun_login == null)
            return true;
        return false;        
    }
    public boolean isSenhaNull(){
        if(fun_senha == null)
            return true;
        return false;        
    }
}
