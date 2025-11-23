package core.io.crud.hex.pessoa.adapters.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaRequest {
    private String nome;
    private String email;
    private String senha;
    private String pais;
}
