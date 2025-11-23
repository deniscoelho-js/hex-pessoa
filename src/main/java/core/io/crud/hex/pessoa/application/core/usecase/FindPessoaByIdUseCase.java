package core.io.crud.hex.pessoa.application.core.usecase;

import core.io.crud.hex.pessoa.application.ports.in.FindPessoaByIdInputPort;
import core.io.crud.hex.pessoa.application.ports.out.FindByIdPessoaOutputPort;

public class FindPessoaByIdUseCase implements FindPessoaByIdInputPort {

    private final FindByIdPessoaOutputPort findByIdPessoaOutputPort;

    public FindPessoaByIdUseCase(FindByIdPessoaOutputPort findByIdPessoaOutputPort) {
        this.findByIdPessoaOutputPort = findByIdPessoaOutputPort;
    }

    @Override
    public void findById(Long id) {

    }
}
