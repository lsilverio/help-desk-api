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
@Entity(name = "tecnico")
public class Tecnico extends Pessoa {

    private static final long serialVersionUID = -8194331442314679334L;

    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<Chamado>();

    public Tecnico() {
        super();
        addPerfil(PerfilEnum.TECNICO);
    }

    public Tecnico(Long id, String nome, String email, String senha) {
        super(id, nome, email, senha);
        addPerfil(PerfilEnum.TECNICO);
    }
}
