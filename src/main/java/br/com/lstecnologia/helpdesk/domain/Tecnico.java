package br.com.lstecnologia.helpdesk.domain;

import br.com.lstecnologia.helpdesk.domain.enums.PerfilEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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
