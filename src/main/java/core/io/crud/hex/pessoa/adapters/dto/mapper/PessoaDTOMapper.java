package core.io.crud.hex.pessoa.adapters.dto.mapper;

import core.io.crud.hex.pessoa.adapters.dto.request.PessoaRequest;
import core.io.crud.hex.pessoa.adapters.dto.response.PessoaResponse;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface PessoaDTOMapper {

    Pessoa toPessoa(PessoaRequest pessoaRequest);

//    @Mapping(target = "id", source = "id")
    @Mapping(target = "enderecoResponse", source = "endereco") // ✅ mapeia Endereco → EnderecoResponse
    PessoaResponse toPessoaResponse(Pessoa pessoa);
}
