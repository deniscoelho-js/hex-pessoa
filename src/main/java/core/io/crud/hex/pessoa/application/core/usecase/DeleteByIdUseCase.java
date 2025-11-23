package core.io.crud.hex.pessoa.application.core.usecase;

import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.in.DeletePessoaByIdInputPort;
import core.io.crud.hex.pessoa.application.ports.in.FindPessoaByIdInputPort;
import core.io.crud.hex.pessoa.application.ports.out.DeletePessoaByIdOutputPort;

public class DeleteByIdUseCase implements DeletePessoaByIdInputPort {

    private final FindPessoaByIdInputPort findPessoaByIdInputPort;
    private final DeletePessoaByIdOutputPort deletePessoaByIdOutputPort;

    public DeleteByIdUseCase(FindPessoaByIdInputPort findPessoaByIdInputPort,
                             DeletePessoaByIdOutputPort deletePessoaByIdOutputPort) {
        this.findPessoaByIdInputPort = findPessoaByIdInputPort;
        this.deletePessoaByIdOutputPort = deletePessoaByIdOutputPort;
    }

    @Override
    public void deleteById(Long id) {
        findPessoaByIdInputPort.findById(id);
        deletePessoaByIdOutputPort.deleteById(id);
    }
}
