package cadastroRebeldeApp.Domain;
import cadastroRebeldeApp.Enum.ParametroOrdenacao;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;

@AllArgsConstructor
@Setter
public class MergeSort {
    private ParametroOrdenacao parametroOrdenacao;

    private LinkedList<Rebelde> merge(LinkedList<Rebelde> esquerda, LinkedList<Rebelde> direita){
        LinkedList<Rebelde> arrAuxiliar = new LinkedList<>();
        int tamandoEsquerda = esquerda.size();
        int tamanhoDireita = direita.size();

        switch(parametroOrdenacao){
            case NOME:
                while(tamandoEsquerda != 0 && tamanhoDireita != 0){
                    if(esquerda.peek().getNome().compareTo(direita.peek().getNome()) < 0){
                        arrAuxiliar.add(esquerda.poll());
                        tamandoEsquerda--;
                    } else {
                        arrAuxiliar.add(direita.poll());
                        tamanhoDireita--;
                    }
                }
                break;
            case IDADE:
                while(tamandoEsquerda != 0 && tamanhoDireita != 0){
                    if(esquerda.peek().getIdade() < direita.peek().getIdade()){
                        arrAuxiliar.add(esquerda.poll());
                        tamandoEsquerda--;
                    } else {
                        arrAuxiliar.add(direita.poll());
                        tamanhoDireita--;
                    }
                }
                break;
            case RACA:
                while(tamandoEsquerda != 0 && tamanhoDireita != 0){
                    if(esquerda.peek().getRaca().compareTo(direita.peek().getRaca()) < 0 ){
                        arrAuxiliar.add(esquerda.poll());
                        tamandoEsquerda--;
                    } else {
                        arrAuxiliar.add(direita.poll());
                        tamanhoDireita--;
                    }
                }
                break;
        }

        if(esquerda.size() > 0){
            arrAuxiliar.addAll(esquerda);
        } else if(direita.size() > 0){
            arrAuxiliar.addAll(direita);
        }

        return arrAuxiliar;
    }

    public LinkedList<Rebelde> mergeSort(LinkedList<Rebelde> rebeldes){
        if(rebeldes == null){
            return rebeldes;
        }

        if(rebeldes.size() <= 1){
            return rebeldes;
        }

        int meioLista = (int) Math.floor(rebeldes.size() / 2);

        LinkedList<Rebelde> meioEsquerda = new LinkedList<>(rebeldes.subList(0, meioLista));
        LinkedList<Rebelde> meioDireita = new LinkedList<>(rebeldes.subList(meioLista, rebeldes.size()));
        return merge(mergeSort(meioEsquerda), mergeSort(meioDireita));
    }
}
