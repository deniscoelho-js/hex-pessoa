package core.io.crud.hex.pessoa.adapters.out;

import core.io.crud.hex.pessoa.adapters.out.repository.PessoaRepository;
import core.io.crud.hex.pessoa.application.ports.out.DeletePessoaByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteByIdAdapter implements DeletePessoaByIdOutputPort {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }
}
