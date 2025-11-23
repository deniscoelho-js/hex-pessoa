package core.io.crud.hex.pessoa.adapters.out.repository.mapper;

import core.io.crud.hex.pessoa.adapters.out.repository.entity.PessoaEntity;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaEntityMapper {

    PessoaEntity toPessoaEntity(Pessoa pessoa);

    Pessoa toPessoa(PessoaEntity pessoaEntity);
}
