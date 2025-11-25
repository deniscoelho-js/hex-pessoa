package core.io.crud.hex.pessoa.application.core.usecase;

import core.io.crud.hex.pessoa.adapters.out.client.EnderecoClient;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.in.FindPessoaByIdInputPort;
import core.io.crud.hex.pessoa.application.ports.in.UpdatePessoaInputPort;
import core.io.crud.hex.pessoa.application.ports.out.UpdatePessoaOutputPort;

public class UpdatePessoaUseCase implements UpdatePessoaInputPort {

    private final UpdatePessoaOutputPort updatePessoaOutputPort;
    private final FindPessoaByIdInputPort findPessoaByIdInputPort;
    private final EnderecoClient enderecoClient;

    public UpdatePessoaUseCase(UpdatePessoaOutputPort updatePessoaOutputPort,
                               FindPessoaByIdInputPort findPessoaByIdInputPort,
                               EnderecoClient enderecoClient) {
        this.updatePessoaOutputPort = updatePessoaOutputPort;
        this.findPessoaByIdInputPort = findPessoaByIdInputPort;
        this.enderecoClient = enderecoClient;
    }

    @Override
    public Pessoa update(Long id, Pessoa pessoa) {
        findPessoaByIdInputPort.findById(id);
        var endereco = enderecoClient.getEndereco(pessoa.getCep());
        pessoa.setEndereco(endereco);
        var pessoaAtualizada = updatePessoaOutputPort.update(id, pessoa);
        pessoaAtualizada.setEndereco(endereco);
        return pessoaAtualizada;
    }
}
