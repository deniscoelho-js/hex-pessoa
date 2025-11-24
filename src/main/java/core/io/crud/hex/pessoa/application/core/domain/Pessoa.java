package core.io.crud.hex.pessoa.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String pais;
    private String cep;
}
