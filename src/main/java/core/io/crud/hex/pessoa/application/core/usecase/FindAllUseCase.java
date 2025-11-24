package core.io.crud.hex.pessoa.application.core.usecase;

import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.in.FindAllInputPort;
import core.io.crud.hex.pessoa.application.ports.out.FindAllOutputPort;

import java.util.List;

public class FindAllUseCase implements FindAllInputPort {

    private final FindAllOutputPort findAllOutputPort;

    public FindAllUseCase(FindAllOutputPort findAllOutputPort) {
        this.findAllOutputPort = findAllOutputPort;
    }

    @Override
    public List<Pessoa> findAll() {
        return findAllOutputPort.findAll();
    }
}
