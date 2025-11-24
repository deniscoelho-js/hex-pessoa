package core.io.crud.hex.pessoa.adapters.out;

import core.io.crud.hex.pessoa.adapters.out.repository.PessoaRepository;
import core.io.crud.hex.pessoa.adapters.out.repository.mapper.PessoaEntityMapper;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.out.FindAllOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllAdapter implements FindAllOutputPort {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEntityMapper pessoaEntityMapper;

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoaEntityMapper::toPessoa)
                .collect(Collectors.toList());
    }
}
