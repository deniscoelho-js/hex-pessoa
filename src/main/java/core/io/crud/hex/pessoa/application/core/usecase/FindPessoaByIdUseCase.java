package core.io.crud.hex.pessoa.application.core.usecase;

import core.io.crud.hex.pessoa.adapters.out.client.EnderecoClient;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.in.FindPessoaByIdInputPort;
import core.io.crud.hex.pessoa.application.ports.out.FindByIdPessoaOutputPort;

public class FindPessoaByIdUseCase implements FindPessoaByIdInputPort {

    private final FindByIdPessoaOutputPort findByIdPessoaOutputPort;

    private final EnderecoClient enderecoClient;

    public FindPessoaByIdUseCase(FindByIdPessoaOutputPort findByIdPessoaOutputPort, EnderecoClient enderecoClient) {
        this.findByIdPessoaOutputPort = findByIdPessoaOutputPort;
        this.enderecoClient = enderecoClient;
    }

    @Override
    public Pessoa findById(Long id) {
        var pessoa = findByIdPessoaOutputPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        var endereco = enderecoClient.getEndereco(pessoa.getCep());
        pessoa.setEndereco(endereco);
        return pessoa;
    }
}
