package core.io.crud.hex.pessoa.application.ports.in;

import core.io.crud.hex.pessoa.application.core.domain.Pessoa;

public interface UpdatePessoaInputPort {
    void update(Long id, Pessoa pessoa);
}
