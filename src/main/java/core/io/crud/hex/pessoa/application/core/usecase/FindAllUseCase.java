package core.io.crud.hex.pessoa.application.core.usecase;

import core.io.crud.hex.pessoa.adapters.out.client.EnderecoClient;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.in.FindAllInputPort;
import core.io.crud.hex.pessoa.application.ports.out.FindAllOutputPort;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllUseCase implements FindAllInputPort {

    private final FindAllOutputPort findAllOutputPort;
    private final EnderecoClient enderecoClient;

    public FindAllUseCase(FindAllOutputPort findAllOutputPort, EnderecoClient enderecoClient) {
        this.findAllOutputPort = findAllOutputPort;
        this.enderecoClient = enderecoClient;
    }

    @Override
    public List<Pessoa> findAll() {
        return findAllOutputPort.findAll()
                .stream()
                .map(pessoa -> {
                    var endereco = enderecoClient.getEndereco(pessoa.getCep());
                    pessoa.setEndereco(endereco);
                    return pessoa;
                })
                .collect(Collectors.toList());
    }
}
