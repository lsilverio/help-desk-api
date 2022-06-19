package br.com.lstecnologia.helpdesk.domain;

import br.com.lstecnologia.helpdesk.domain.enums.PerfilEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "pessoa")
public abstract class Pessoa implements Serializable {

    private static final long serialVersionUID = 956644411981685698L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected String nome;
    @Column(unique = true)
    protected String email;
    @Column
    protected String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfil")
    protected Set<Integer> perfis = new HashSet<>();

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "timestamp", name = "data_criacao")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;

    public Pessoa() {
        super();
        addPerfil(PerfilEnum.CLIENTE);
    }

    public Pessoa(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        addPerfil(PerfilEnum.CLIENTE);
    }

    public Set<PerfilEnum> getPerfis() {
        return perfis.stream().map(p -> PerfilEnum.toEnum(p)).collect(Collectors.toSet());
    }

    public void addPerfil(PerfilEnum perfil) {
        this.perfis.add(perfil.getCodigo());
    }

}
