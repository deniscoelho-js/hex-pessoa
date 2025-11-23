package core.io.crud.hex.pessoa.adapters.out;

import core.io.crud.hex.pessoa.adapters.out.repository.PessoaRepository;
import core.io.crud.hex.pessoa.adapters.out.repository.mapper.PessoaEntityMapper;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.out.SavePessoaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePessoaAdapter implements SavePessoaOutputPort {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEntityMapper pessoaEntityMapper;

    @Override
    public Pessoa save(Pessoa pessoa) {
        var entity = pessoaEntityMapper.toPessoaEntity(pessoa);
        var pessoaSalva = pessoaRepository.save(entity);
        System.out.println("ID gerado pelo JPA: " + pessoaSalva.getId());
        return pessoaEntityMapper.toPessoa(pessoaSalva);
    }
}
