package cadastroRebeldeApp.Rebelde;

import cadastroRebeldeApp.Enum.Raca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Builder

public class Rebelde {
    @NonNull
    private String nome;
    @NonNull
    private int idade;
    private Raca raca;
}
