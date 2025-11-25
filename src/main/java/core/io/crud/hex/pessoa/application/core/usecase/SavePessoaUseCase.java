package core.io.crud.hex.pessoa.application.core.usecase;


import core.io.crud.hex.pessoa.adapters.out.client.EnderecoClient;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.in.SavePessoaInputPort;
import core.io.crud.hex.pessoa.application.ports.out.SavePessoaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class SavePessoaUseCase implements SavePessoaInputPort {

    private final SavePessoaOutputPort savePessoaOutputPort;

    private final EnderecoClient enderecoClient;

    public SavePessoaUseCase(SavePessoaOutputPort savePessoaOutputPort, EnderecoClient enderecoClient) {
        this.savePessoaOutputPort = savePessoaOutputPort;
        this.enderecoClient = enderecoClient;
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        var endereco = enderecoClient.getEndereco(pessoa.getCep());
        pessoa.setEndereco(endereco);
        var pessoaSalva = savePessoaOutputPort.save(pessoa);
        pessoaSalva.setEndereco(endereco);

        return pessoaSalva;
    }
}
