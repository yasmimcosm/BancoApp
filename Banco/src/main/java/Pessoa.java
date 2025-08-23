public class Pessoa {

    private String cpf;
    private String nome;
    private Conta conta;
    private String senha;

    public Pessoa (String oCpf, String nm, String passwd) {
        this.senha = passwd;
        this.nome = nm;
        this.cpf = oCpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta c) {
        this.conta = c;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nm) {
        this.nome = nm;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String pass) {
        this.senha = pass;
    }

    public boolean validar() {
        if (nome == null || nome.trim().isEmpty()) return false;
        if (cpf == null || !cpf.matches("\\d{11}")) return false; // 11 dígitos numéricos
        return true;
    }
}