package core.io.crud.hex.pessoa.config;

import core.io.crud.hex.pessoa.application.core.usecase.DeleteByIdUseCase;
import core.io.crud.hex.pessoa.application.core.usecase.FindPessoaByIdUseCase;
import core.io.crud.hex.pessoa.application.core.usecase.SavePessoaUseCase;
import core.io.crud.hex.pessoa.application.ports.in.DeletePessoaByIdInputPort;
import core.io.crud.hex.pessoa.application.ports.in.FindPessoaByIdInputPort;
import core.io.crud.hex.pessoa.application.ports.in.SavePessoaInputPort;
import core.io.crud.hex.pessoa.application.ports.out.DeletePessoaByIdOutputPort;
import core.io.crud.hex.pessoa.application.ports.out.FindByIdPessoaOutputPort;
import core.io.crud.hex.pessoa.application.ports.out.SavePessoaOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfiguration {

    @Bean
    public SavePessoaInputPort savePessoaUseCase(SavePessoaOutputPort savePessoaOutputPort) {
        return new SavePessoaUseCase(savePessoaOutputPort);
    }

    @Bean
    public FindPessoaByIdInputPort findPessoaByIdUseCase(FindByIdPessoaOutputPort findByIdPessoaOutputPort) {
        return new FindPessoaByIdUseCase(findByIdPessoaOutputPort);
    }

    @Bean
    public DeletePessoaByIdInputPort deleteByIdUseCase(FindPessoaByIdInputPort findPessoaByIdInputPort,
                                                       DeletePessoaByIdOutputPort deletePessoaByIdOutputPort) {
        return new DeleteByIdUseCase(findPessoaByIdInputPort, deletePessoaByIdOutputPort);
    }
}
