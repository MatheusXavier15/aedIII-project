package Project;
public class user {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;

    public user(int id, String nome, String email, String senha) {
        this.idUsuario = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public user(){
        return;
    }

    public int getId() {
        return this.idUsuario;
    }

    public void setId(int id) {
        this.idUsuario = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
