package comprimidos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Admin extends Utilizador {

    public Admin(String nome) {
        super(nome);
    }

    public static void Admin_remove(ArrayList<Utilizador> lista) {

        if (lista.size() > 0) {

            Admin_listarNome(lista);
            System.out.print("\nQual o utilizador que quer remover? ");

            int id = Read.Int() - 1;

            if (id > lista.size() + 1 || id < 0) {
                System.out.println("Utilizador não encontrado.");
                return;
            }

            System.out.print("Tem a certeza que quer remover? (y/n): ");
            char op;
            op = Read.Char();

            while ((op != 'y') || (op != 'n')) {
                switch (op) {
                    case 'y':
                        lista.remove(id);
                        Ficheiro.escrever(lista);
                        return;
                    case 'n':
                        return;
                    default:
                        System.out.println("Opção invalida!");
                        break;
                }
            }
        } else {
            System.out.println("\nNão existem utilizadores!\n");
        }
    }

    public static void Admin_menuInicial() {
        System.out.println("<><><><><><><><><><><><>");
        System.out.println("       Modo Admin      ");
        System.out.println("<><><><><><><><><><><><>");
        System.out.println("   1. Modificar        ");
        System.out.println("   2. Remover          ");
        System.out.println("   3. Terminar         ");
        System.out.println("<><><><><><><><><><><><>");
    }

    public static void Admin_menuModificar() {
        System.out.println("<><><><><><><><><><><><><><><><><><>");
        System.out.println("   Escolha o que pretende alterar   ");
        System.out.println("<><><><><><><><><><><><><><><><><><>");
        System.out.println("      1. Nome                 ");
        System.out.println("      2. Género               ");
        System.out.println("      3. Idade                ");
        System.out.println("      4. Data de nascimento   ");
        System.out.println("      5. Password             ");
        System.out.println("      6. Terminar             ");
        System.out.println("<><><><><><><><><><><><><><><><><><>");
    }

    /*
        - recebe a posição do utilizador na lista dos Utilizadores 
          e a lista dos utilizadores
        - chama menuModificar() para o utilizador escolher o campo a alterar
        - no fim de cada alteraçao mostra toda a informaçao do utilizador com 
          os dados alterados
     */
    public static void Admin_modificar(ArrayList<Utilizador> lista) {

        if (lista.size() > 0) {

            int choice;
            Admin_listarNome(lista);
            System.out.print("Qual o utilizador que quer modificar? ");

            int id = Read.Int() - 1;

            if (id > lista.size() + 1 || id < 0) {
                System.out.println("Utilizador não encontrado.");
                return;
            }

            while (true) {

                Admin_menuModificar();
                System.out.print("Introduza uma opção: ");
                choice = Read.Int();

                switch (choice) {

                    // modificar nome
                    case 1: {
                        System.out.print("Introduza o novo nome: ");
                        String nome = Read.String();
                        
                        lista.get(id).setNome(nome);
                        System.out.println("Utilizador modificado com sucesso.");
                        
                        System.out.println(lista.get(id).toString());
                        System.out.println("\nEscolha outra opção...");
                        break;
                    }
                    //modificar genero
                    case 2: {
                        System.out.print("Introduza o novo genero: ");
                        String genero = Read.String();
                        
                        lista.get(id).setGenero(genero);
                        System.out.println("Utilizador modificado com sucesso.");
                        
                        System.out.println(lista.get(id).toString());
                        System.out.println("\nEscolha outra opção...");
                        break;
                    }
                    //modificar idade
                    case 3: {
                        System.out.print("Introduza a nova idade: ");
                        int idade = Read.Int();
                        
                        lista.get(id).setIdade(idade);
                        System.out.println("Utilizador modificado com sucesso.");
                        
                        System.out.println(lista.get(id).toString());
                        System.out.println("\nEscolha outra opção...");
                        break;
                    }
                    //modificar data de nasc
                    case 4: {
                        System.out.print("Introduza a nova data de nascimento: ");
                        int dia = Read.Int();
                        int mes = Read.Int();
                        int ano = Read.Int();

                        LocalDateTime data_nascimento = LocalDateTime.of(dia, mes, ano, 0, 0);
                        lista.get(id).setDataNascimento(data_nascimento);

                        System.out.println("Utilizador modificado com sucesso.");
                        System.out.println(lista.get(id).toString());
                        System.out.println("\nEscolha outra opção...");

                        break;
                    }

                    /* 
                no fim de fazer as alteraçoes necessarias ao utilizador, 
                alteraçoes feitas ao arraylist utilizadores sao guardadas no 
                ficheiro e retorna-se para o menu MenuUtilizadores() ainda nesta classe
                     */
                    case 5: {
                        System.out.println("Introduza a nova password: ");
                        String pass = Read.String();
                        lista.get(id).setPassword(pass);
                        System.out.println("Password modificada com sucesso.");
                        System.out.println("\nEscolha outra opção...");
                        break;
                    }

                    case 6: {
                        System.out.println("\n");
                        Ficheiro.escrever(lista);
                        return;
                    }

                    default: {
                        System.out.println("Opção inválida.");
                        break;
                    }
                }
            }
        } else {
            System.out.println("\nNão existem utilizadores\n");
        }
    }

    public static void Admin_listarNome(ArrayList<Utilizador> lista) {
        int i;
        for (i = 0; i < lista.size(); i++) {
            System.out.println("Utilizador " + (i+1) + ": " + lista.get(i).getNome() + "\n");
        }
    }
}
