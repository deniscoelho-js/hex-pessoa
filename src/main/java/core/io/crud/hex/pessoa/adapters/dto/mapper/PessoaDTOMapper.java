package core.io.crud.hex.pessoa.adapters.dto.mapper;

import core.io.crud.hex.pessoa.adapters.dto.request.PessoaRequest;
import core.io.crud.hex.pessoa.adapters.dto.response.PessoaResponse;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaDTOMapper {

    Pessoa toPessoa(PessoaRequest pessoaRequest);

    @Mapping(target = "id", source = "id")
    PessoaResponse toPessoaResponse(Pessoa pessoa);
}
