package core.io.crud.hex.pessoa.adapters.dto.mapper;

import core.io.crud.hex.pessoa.adapters.dto.response.EnderecoResponse;
import core.io.crud.hex.pessoa.application.core.domain.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoResponse toEnderecoResponse(Endereco endereco);
}
