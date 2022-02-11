package cadastroRebeldeApp.View;

import cadastroRebeldeApp.Domain.Rebelde;
import cadastroRebeldeApp.Enum.Raca;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RebeldeView {
    private Rebelde rebelde;

    public Rebelde cadastrarRebelde(){
        this.rebelde = new Rebelde();
        this.rebelde.setNome(perguntaNome());
        this.rebelde.setRaca(perguntaRaca());
        this.rebelde.setIdade(perguntaIdade());
        return this.rebelde;
    }

    private String perguntaNome() {
        System.out.println("Informe o nome do rebelde .");
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        if(nome.isBlank()){
            System.out.println("Nome não pode ser vazio ou nulo");
            return perguntaNome();
        }
        return nome;
    }

    private Raca perguntaRaca() {
        List<Raca> listaRacas = Arrays.asList(Raca.values());
        System.out.println("Qual a raça que gostaria de cadastrar ?");
        System.out.println("OBS: Utilize o número correspondente");
        int index = 0;
        for(Raca raca : listaRacas) {
            System.out.printf("[%d] - %s. %n", index, raca);
            index++;
        }

        Scanner sc = new Scanner(System.in);
        String opcaoRaca = sc.next();

        switch(opcaoRaca){
            case "0":
                return Raca.HUMANO;
            case "1":
                return Raca.GREE;
            case "2":
                return Raca.RAKATA;
            default:
                System.out.println("Opção inválida, por favor escolha uma opção válida.");
                return perguntaRaca();
        }
    }

    private int perguntaIdade(){
        System.out.println("Qual a idade do rebelde ?");
        Scanner sc = new Scanner(System.in);
        int idade;

        try {
            idade = sc.nextInt();
            return idade;
        } catch (InputMismatchException exception){
            System.out.println("Idade inválida, por favor apenas números.");
            return perguntaIdade();
        }
    }
}
