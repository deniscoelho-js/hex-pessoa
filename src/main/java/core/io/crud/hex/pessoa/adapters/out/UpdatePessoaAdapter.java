package core.io.crud.hex.pessoa.adapters.out;

import core.io.crud.hex.pessoa.adapters.out.repository.PessoaRepository;
import core.io.crud.hex.pessoa.adapters.out.repository.mapper.PessoaEntityMapper;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.out.UpdatePessoaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePessoaAdapter implements UpdatePessoaOutputPort {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEntityMapper pessoaEntityMapper;

    @Override
    public Pessoa update(Long id, Pessoa pessoa) {
        var pessoaEntity = pessoaEntityMapper.toPessoaEntity(pessoa);
        pessoaEntity.setId(id);
        var pessoaAtualizada = pessoaRepository.save(pessoaEntity);
        return pessoaEntityMapper.toPessoa(pessoaAtualizada);
    }
}
