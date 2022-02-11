package cadastroRebeldeApp.Controller;
import cadastroRebeldeApp.Domain.MergeSort;
import cadastroRebeldeApp.Domain.Rebelde;

import cadastroRebeldeApp.Enum.ParametroOrdenacao;
import lombok.Cleanup;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Random;

@NoArgsConstructor
public class InteligenciaCentral {
    private LinkedList<Rebelde> rebeldes = new LinkedList<>();

    public void cadastrarRebelde(Rebelde rebelde){
        this.rebeldes.add(rebelde);
    }

    public boolean solicitarAcesso(){
        Random randon = new Random();
        boolean acessoLiberado = false;
        double numero = randon.nextDouble();
        if(numero >= 0.3){
            acessoLiberado = true;
        }
        return acessoLiberado;
    }

    public void ordernarLista(ParametroOrdenacao parametrosOrdenacao){
        MergeSort mergeSortOrdenacao = new MergeSort(parametrosOrdenacao);
        this.rebeldes = mergeSortOrdenacao.mergeSort(this.rebeldes);
    }

    public void salvarListaRebeldesArquivo(){
        try {
            @Cleanup
            PrintWriter writer = new PrintWriter("rebeldes.txt", "UTF-8");
            writer.println("Rebeldes");
            int count = 0;
            for(Rebelde rebelde : rebeldes){
                writer.println(count + " - " + rebelde.toString());
                count++;
            }
        } catch(FileNotFoundException exception) {
            exception.printStackTrace();
        } catch(UnsupportedEncodingException exception){
            exception.printStackTrace();
        }
    }

    public void printListaRebeldeConsole(){
        for(Rebelde rebelde: rebeldes){
            System.out.println(rebelde.toString());
        }
    }
}
