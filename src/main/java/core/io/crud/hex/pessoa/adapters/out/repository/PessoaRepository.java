package core.io.crud.hex.pessoa.adapters.out.repository;

import core.io.crud.hex.pessoa.adapters.out.repository.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
}
