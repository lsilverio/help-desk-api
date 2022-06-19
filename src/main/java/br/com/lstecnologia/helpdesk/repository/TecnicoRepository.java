package br.com.lstecnologia.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lstecnologia.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{

}
