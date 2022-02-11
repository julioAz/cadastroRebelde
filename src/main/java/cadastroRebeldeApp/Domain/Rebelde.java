package cadastroRebeldeApp.Domain;

import cadastroRebeldeApp.Enum.Raca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Rebelde {
    private String nome;
    private int idade;
    private Raca raca;
}
