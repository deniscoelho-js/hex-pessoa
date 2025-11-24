package core.io.crud.hex.pessoa.application.ports.out;

import core.io.crud.hex.pessoa.application.core.domain.Pessoa;

import java.util.List;

public interface FindAllOutputPort {
    List<Pessoa> findAll();
}
