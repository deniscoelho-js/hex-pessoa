package core.io.crud.hex.pessoa.application.ports.out;

import core.io.crud.hex.pessoa.adapters.dto.request.PessoaRequest;
import core.io.crud.hex.pessoa.adapters.dto.response.PessoaResponse;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import org.springframework.context.annotation.Configuration;


public interface SavePessoaOutputPort {
    Pessoa save(Pessoa pessoa);
}
