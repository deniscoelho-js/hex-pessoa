package core.io.crud.hex.pessoa.application.ports.out;

import core.io.crud.hex.pessoa.application.core.domain.Pessoa;

public interface UpdatePessoaOutputPort {
    void update(Long id, Pessoa pessoa);
}
