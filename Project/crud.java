package Project;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class crud {
    Scanner in = new Scanner(System.in);
    public byte[] toByteArray(user usuario) throws IOException {
        ByteArrayOutputStream dados = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream( dados );
        saida.writeInt(usuario.getId());//salva um int
        saida.writeUTF(usuario.getNome());//salva uma string
        saida.writeUTF(usuario.getEmail());//salva uma string
        saida.writeUTF(usuario.getSenha());//salva uma string
        return dados.toByteArray(); 
    }

    public void fromByteArray(byte[] bytes) throws IOException {
        user usuario = new user();
        ByteArrayInputStream dados = new ByteArrayInputStream(bytes);
        DataInputStream entrada = new DataInputStream(dados);
        usuario.setId(entrada.readInt()); //lê um inteiro
        usuario.setNome(entrada.readUTF());//lê uma string
        usuario.setEmail(entrada.readUTF());//lê uma string
        usuario.setSenha(entrada.readUTF());//lê uma string
    }

    // public boolean create(user Usuario, HashRehash table){
    //     int id = table.m + 1;
    //     String nome = in.nextLine();
    //     String email = in.nextLine();
    //     String senha = in.nextLine();
    //     user usuario = new user(id,nome,email,senha);
    //     byte[] byteElement = toByteArray(usuario);
    //     String stringElement = byteElement.toString();
    //     int element = Integer.parseInt(stringElement);
    //     table.insert(element);
    //     return true;
    // }

    public boolean delete(int id){
        return true;
    }

    // public String read(int id, String Tab){
    //     boolean find = false;
    //     int i = 0;
    //     while(find == false){
    //         i++;
    //     }
    //     String usuario = new String();
    //     return usuario;
    // }

    public boolean uptade(int id){
        return true;
    }
}
