package Project;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class user implements Project.RegistroHashExtensivel<user> {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private short TAMANHO = 88;

    public user(int id, String nome, String email, String senha) {
        try {
            this.idUsuario = id;
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            if (email.length() + 4> (TAMANHO - 34))
                throw new Exception("Número de caracteres do email maior que o permitido. Os dados serão cortados.");
            if (nome.length() > (TAMANHO - 30))
            throw new Exception("Número de caracteres do email maior que o permitido. Os dados serão cortados.");
            if (senha.length() > (TAMANHO - 10))
            throw new Exception("Número de caracteres do email maior que o permitido. Os dados serão cortados.");
        } catch (Exception ec) {
            ec.printStackTrace();
        }
    }

    public user() {
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

    @Override
    public boolean hashCode(int chave) {
        if(chave == this.idUsuario){
            return true;
        }
        return false;
    }

    // public int hashCode() {
    //     String usuario = this.nome  + this.email + this.senha;
    //     return usuario.hashCode();
    // }

    public short size() {
        return this.TAMANHO;
    }

    public String toString() {
        return this.idUsuario + "|" + this.nome + "|" +  this.email;
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(idUsuario);
        dos.writeUTF(nome);
        dos.writeUTF(email);
        dos.writeUTF(senha);
        byte[] bs = baos.toByteArray();
        byte[] bs2 = new byte[TAMANHO];
        for (int i = 0; i < TAMANHO; i++)
            bs2[i] = ' ';
        for (int i = 0; i < bs.length && i < TAMANHO; i++)
            bs2[i] = bs[i];
        return bs2;
    }

    public void fromByteArray(byte[] ba) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);
        this.idUsuario = dis.readInt();
        this.nome = dis.readUTF();
        this.email = dis.readUTF();
        this.senha = dis.readUTF();
    }

}
