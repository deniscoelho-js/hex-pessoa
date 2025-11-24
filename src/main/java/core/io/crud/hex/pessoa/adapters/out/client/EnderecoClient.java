package core.io.crud.hex.pessoa.adapters.out.client;

import core.io.crud.hex.pessoa.application.core.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viaCepApi")
public interface EnderecoClient {
    @GetMapping("{cep}/json")
    Endereco getEndereco(@PathVariable("cep") String cep);
}
