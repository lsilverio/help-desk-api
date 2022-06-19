package br.com.lstecnologia.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lstecnologia.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
