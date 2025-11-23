package core.io.crud.hex.pessoa.application.core.usecase;


import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.in.SavePessoaInputPort;
import core.io.crud.hex.pessoa.application.ports.out.SavePessoaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePessoaUseCase implements SavePessoaInputPort {

    @Autowired
    private final SavePessoaOutputPort savePessoaOutputPort;


    public SavePessoaUseCase(SavePessoaOutputPort savePessoaOutputPort) {
        this.savePessoaOutputPort = savePessoaOutputPort;
    }


    @Override
    public Pessoa save(Pessoa pessoa) {
        return savePessoaOutputPort.save(pessoa);
    }
}
