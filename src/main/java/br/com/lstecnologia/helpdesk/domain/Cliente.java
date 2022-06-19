package br.com.lstecnologia.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.lstecnologia.helpdesk.domain.enums.PerfilEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "cliente")
public class Cliente extends Pessoa {

    private static final long serialVersionUID = -6651632085359182585L;

    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<Chamado>();

    public Cliente() {
        super();
        addPerfil(PerfilEnum.CLIENTE);
    }

    public Cliente(Long id, String nome, String email, String senha) {
        super(id, nome, email, senha);
        addPerfil(PerfilEnum.CLIENTE);
    }
}
