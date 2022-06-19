package br.com.lstecnologia.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lstecnologia.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

}
