package core.io.crud.hex.pessoa.application.ports.in;

import core.io.crud.hex.pessoa.application.core.domain.Pessoa;

public interface FindPessoaByIdInputPort {
    Pessoa findById(Long id);
}
