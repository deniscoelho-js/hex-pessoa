package core.io.crud.hex.pessoa.adapters.in.controller;

import core.io.crud.hex.pessoa.adapters.dto.mapper.PessoaDTOMapper;
import core.io.crud.hex.pessoa.adapters.dto.request.PessoaRequest;
import core.io.crud.hex.pessoa.adapters.dto.response.PessoaResponse;
import core.io.crud.hex.pessoa.application.core.domain.Pessoa;
import core.io.crud.hex.pessoa.application.ports.in.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private SavePessoaInputPort savePessoaInputPort;

    @Autowired
    private FindPessoaByIdInputPort findPessoaByIdInputPort;

    @Autowired
    private FindAllInputPort findAllInputPort;

    @Autowired
    private DeletePessoaByIdInputPort deletePessoaByIdInputPort;

    @Autowired
    private UpdatePessoaInputPort updatePessoaInputPort;

    @Autowired
    private PessoaDTOMapper pessoaDTOMapper;

    @PostMapping
    public ResponseEntity<PessoaResponse> save(@RequestBody PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaDTOMapper.toPessoa(pessoaRequest);
        Pessoa pessoaSalva = savePessoaInputPort.save(pessoa);
        PessoaResponse pessoaResponse = pessoaDTOMapper.toPessoaResponse(pessoaSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> findById(@PathVariable Long id) {
        var pessoa = findPessoaByIdInputPort.findById(id);
        var pessoaResponse = pessoaDTOMapper.toPessoaResponse(pessoa);
        return ResponseEntity.ok(pessoaResponse);
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> findAll() {
        List<Pessoa> pessoas = findAllInputPort.findAll();
        List<PessoaResponse> responses = pessoas.stream()
                .map(pessoaDTOMapper::toPessoaResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        deletePessoaByIdInputPort.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> update(@PathVariable Long id, @RequestBody PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaDTOMapper.toPessoa(pessoaRequest);
        pessoa.setId(id);
        Pessoa pessoaAtualizada = updatePessoaInputPort.update(id, pessoa);
        var pessoaResponse = pessoaDTOMapper.toPessoaResponse(pessoaAtualizada);
        return ResponseEntity.ok().body(pessoaResponse);
    }
}
