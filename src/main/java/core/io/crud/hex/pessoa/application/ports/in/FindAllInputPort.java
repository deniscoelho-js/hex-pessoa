package core.io.crud.hex.pessoa.application.ports.in;

import core.io.crud.hex.pessoa.application.core.domain.Pessoa;

import java.util.List;

public interface FindAllInputPort {
    List<Pessoa> findAll();
}
