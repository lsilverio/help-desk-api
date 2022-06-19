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
