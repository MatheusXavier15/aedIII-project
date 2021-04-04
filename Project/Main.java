package Project;

import java.util.Scanner;
import java.io.File;

public class Main {

    // Método principal apenas para testes
    public static void main(String[] args) {

        HashExtensivel<user> he;
        Scanner console = new Scanner(System.in);

        try {
            File d = new File("dados");
            if (!d.exists())
                d.mkdir();
            he = new HashExtensivel<>(user.class.getConstructor(), 4, "dados/pessoas.hash_d.db",
                    "dados/pessoas.hash_c.db");

            int opcao;
            do {
                System.out.println("\n\n-------------------------------");
                System.out.println("              MENU");
                System.out.println("-------------------------------");
                System.out.println("1 - Inserir");
                System.out.println("2 - Buscar");
                System.out.println("3 - Excluir");
                System.out.println("4 - Imprimir");
                System.out.println("0 - Sair");
                try {
                    opcao = Integer.valueOf(console.nextLine());
                } catch (NumberFormatException e) {
                    opcao = -1;
                }

                switch (opcao) {
                case 1: {
                    System.out.println("\nINCLUSÃO");

                    System.out.print("ID: ");
                    int id = Integer.valueOf(console.nextLine());
                    System.out.print("Nome: ");
                    String nome = console.nextLine();
                    System.out.print("E-mail: ");
                    String email = console.nextLine();
                    System.out.print("Senha: ");
                    String senha = console.nextLine();
                    he.create(new user(id, nome, email, senha));
                    he.print();
                }
                    break;
                case 2: {
                    System.out.println("\nBUSCA");

                    System.out.print("id: ");
                    Integer id = Integer.valueOf(console.nextLine());
                    System.out.print("Dados: " + he.read(id));
                }
                    break;
                case 3: {
                    System.out.println("\nEXCLUSÃO");

                    System.out.print("id: ");
                    Integer id = Integer.valueOf(console.nextLine());
                    he.delete(id);
                    he.print();
                }
                    break;
                case 4: {
                    he.print();
                }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
                }
            } while (opcao != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        console.close();
    }
}