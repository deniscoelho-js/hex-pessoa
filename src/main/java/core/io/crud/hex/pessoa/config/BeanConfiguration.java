package core.io.crud.hex.pessoa.config;

import core.io.crud.hex.pessoa.adapters.out.client.EnderecoClient;
import core.io.crud.hex.pessoa.application.core.usecase.*;
import core.io.crud.hex.pessoa.application.ports.in.*;
import core.io.crud.hex.pessoa.application.ports.out.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfiguration {

    @Bean
    public SavePessoaInputPort savePessoaUseCase(SavePessoaOutputPort savePessoaOutputPort, EnderecoClient enderecoClient) {
        return new SavePessoaUseCase(savePessoaOutputPort, enderecoClient);
    }

    @Bean
    public FindPessoaByIdInputPort findPessoaByIdUseCase(FindByIdPessoaOutputPort findByIdPessoaOutputPort, EnderecoClient enderecoClient) {
        return new FindPessoaByIdUseCase(findByIdPessoaOutputPort, enderecoClient);
    }

    @Bean
    public DeletePessoaByIdInputPort deleteByIdUseCase(FindPessoaByIdInputPort findPessoaByIdInputPort,
                                                       DeletePessoaByIdOutputPort deletePessoaByIdOutputPort) {
        return new DeleteByIdUseCase(findPessoaByIdInputPort, deletePessoaByIdOutputPort);
    }

    @Bean
    public UpdatePessoaInputPort updatePessoaUseCase(UpdatePessoaOutputPort updatePessoaOutputPort,
                                                     FindPessoaByIdInputPort findPessoaByIdInputPort, EnderecoClient enderecoClient) {
        return new UpdatePessoaUseCase(updatePessoaOutputPort, findPessoaByIdInputPort, enderecoClient);
    }

    @Bean
    public FindAllInputPort findAllUseCase(FindAllOutputPort findAllOutputPort, EnderecoClient enderecoClient) {
        return new FindAllUseCase(findAllOutputPort, enderecoClient);
    }
}
