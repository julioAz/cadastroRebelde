package cadastroRebeldeApp.View;

import cadastroRebeldeApp.Controller.InteligenciaCentral;
import cadastroRebeldeApp.Domain.Rebelde;
import cadastroRebeldeApp.Enum.ParametroOrdenacao;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class ICView {

    private InteligenciaCentral inteligenciaCentral;
    private RebeldeView rebeldeView;

    public void apresentarMenu(){
        System.out.println("\n" +
                " _____           _           _              ______     _          _     _      \n" +
                "/  __ \\         | |         | |             | ___ \\   | |        | |   | |     \n" +
                "| /  \\/ __ _  __| | __ _ ___| |_ _ __ ___   | |_/ /___| |__   ___| | __| | ___ \n" +
                "| |    / _` |/ _` |/ _` / __| __| '__/ _ \\  |    // _ \\ '_ \\ / _ \\ |/ _` |/ _ \\\n" +
                "| \\__/\\ (_| | (_| | (_| \\__ \\ |_| | | (_) | | |\\ \\  __/ |_) |  __/ | (_| |  __/\n" +
                " \\____/\\__,_|\\__,_|\\__,_|___/\\__|_|  \\___/  \\_| \\_\\___|_.__/ \\___|_|\\__,_|\\___|\n" +
                "                                                                               \n");
        System.out.println("Bem vindo jovem humano, gree ou rakata, o que gostaria de fazer hoje ?");
        System.out.println("1 - Cadastrar novo rebelde;");
        System.out.println("0 - Sair do sistema.");

        Scanner sc = new Scanner (System.in);
        String opcao = sc.next();

        switch (opcao) {
            case "1":
                Rebelde rebelde = this.rebeldeView.cadastrarRebelde();
                boolean solicitarAcesso = this.inteligenciaCentral.solicitarAcesso();
                if (solicitarAcesso) {
                    System.out.println("Acesso Garantido. Bem-vindo!");
                    this.inteligenciaCentral.cadastrarRebelde(rebelde);
                    menuSalvar();
                    this.inteligenciaCentral.salvarListaRebeldesArquivo();
                    this.inteligenciaCentral.printListaRebeldeConsole();
                    System.out.println("-----------------------------------------");
                } else {
                    System.out.println("Você ainda está aqui? Vá embora, acabou. Seu acesso foi negado.");
                }
                menuSalvar();
                break;
            case "0":
                System.exit(0);
                sc.close();
                break;
            default:
                System.out.println("Opção inválida, escolha uma opção válida.");
                menuSalvar();
        }
    }

    public void menuSalvar(){
        Scanner sc = new Scanner(System.in);
        String opcao = sc.next();

        switch (opcao){
            case "1":
                this.inteligenciaCentral.ordernarLista(ParametroOrdenacao.NOME);
                break;
            case "2":
                this.inteligenciaCentral.ordernarLista(ParametroOrdenacao.IDADE);
                break;
            case "3":
                this.inteligenciaCentral.ordernarLista(ParametroOrdenacao.RACA);
                break;
            default:
                System.out.println("Opção inválida, escolha uma opção válida.");
                apresentarMenu();
        }
    }
}
