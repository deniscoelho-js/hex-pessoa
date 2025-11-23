package core.io.crud.hex.pessoa.adapters.out;

import core.io.crud.hex.pessoa.adapters.out.repository.PessoaRepository;
import core.io.crud.hex.pessoa.adapters.out.repository.mapper.PessoaEntityMapper;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.out.FindByIdPessoaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindPessoaByIdAdapter implements FindByIdPessoaOutputPort {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEntityMapper pessoaEntityMapper;

    @Override
    public Optional<Pessoa> findById(Long id) {
        var pessoaEntity = pessoaRepository.findById(id);
        return pessoaEntity.map(entity -> pessoaEntityMapper.toPessoa(entity));
    }
}
