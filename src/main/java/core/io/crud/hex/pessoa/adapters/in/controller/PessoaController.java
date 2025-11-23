package core.io.crud.hex.pessoa.adapters.in.controller;

import core.io.crud.hex.pessoa.adapters.dto.mapper.PessoaDTOMapper;
import core.io.crud.hex.pessoa.adapters.dto.request.PessoaRequest;
import core.io.crud.hex.pessoa.adapters.dto.response.PessoaResponse;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.in.SavePessoaInputPort;
import core.io.crud.hex.pessoa.application.ports.out.SavePessoaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private SavePessoaInputPort savePessoaInputPort;

    @Autowired
    private PessoaDTOMapper pessoaDTOMapper;

    @PostMapping
    public ResponseEntity<PessoaResponse> save(@RequestBody PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaDTOMapper.toPessoa(pessoaRequest);
        Pessoa pessoaSalva = savePessoaInputPort.save(pessoa);
        PessoaResponse pessoaResponse = pessoaDTOMapper.toPessoaResponse(pessoaSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaResponse);
    }
}
