package cadastroRebeldeApp.View;

import cadastroRebeldeApp.Rebelde.Rebelde;

import java.util.Scanner;

public class Menu {
    public static void apresentarMenu(){
        apresentarHeader();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo jovem humano, gree ou rakata, o que gostaria de fazer hoje ?");
        System.out.println("1 - Cadastrar novo rebelde;");
        System.out.println("2 - Listar os rebeldes cadastrados;");
        System.out.println("3 - Sair do sistema.");
        switch (sc.nextInt()) {
            case 1:
                System.out.println("Digite o nome, depois a idade, e por ultimo a raça");
                break;
            case 2:
                System.out.println("A lista de rebeldes é :");
                break;
            case 3:
            default:
        }
    }

    public static void apresentarHeader(){
        System.out.println("\n" +
                " _____           _           _              ______     _          _     _      \n" +
                "/  __ \\         | |         | |             | ___ \\   | |        | |   | |     \n" +
                "| /  \\/ __ _  __| | __ _ ___| |_ _ __ ___   | |_/ /___| |__   ___| | __| | ___ \n" +
                "| |    / _` |/ _` |/ _` / __| __| '__/ _ \\  |    // _ \\ '_ \\ / _ \\ |/ _` |/ _ \\\n" +
                "| \\__/\\ (_| | (_| | (_| \\__ \\ |_| | | (_) | | |\\ \\  __/ |_) |  __/ | (_| |  __/\n" +
                " \\____/\\__,_|\\__,_|\\__,_|___/\\__|_|  \\___/  \\_| \\_\\___|_.__/ \\___|_|\\__,_|\\___|\n" +
                "                                                                               \n" +
                "                                                                               \n");
    }
}
