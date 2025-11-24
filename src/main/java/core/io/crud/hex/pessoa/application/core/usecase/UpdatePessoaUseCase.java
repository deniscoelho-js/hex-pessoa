package core.io.crud.hex.pessoa.application.core.usecase;

import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.in.FindPessoaByIdInputPort;
import core.io.crud.hex.pessoa.application.ports.in.UpdatePessoaInputPort;
import core.io.crud.hex.pessoa.application.ports.out.UpdatePessoaOutputPort;

public class UpdatePessoaUseCase implements UpdatePessoaInputPort {

    private final UpdatePessoaOutputPort updatePessoaOutputPort;

    private final FindPessoaByIdInputPort findPessoaByIdInputPort;

    public UpdatePessoaUseCase(UpdatePessoaOutputPort updatePessoaOutputPort, FindPessoaByIdInputPort findPessoaByIdInputPort) {
        this.updatePessoaOutputPort = updatePessoaOutputPort;
        this.findPessoaByIdInputPort = findPessoaByIdInputPort;
    }

    @Override
    public Pessoa update(Long id, Pessoa pessoa) {
        findPessoaByIdInputPort.findById(id);
        return updatePessoaOutputPort.update(id, pessoa);
    }
}
