package br.com.lstecnologia.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lstecnologia.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
