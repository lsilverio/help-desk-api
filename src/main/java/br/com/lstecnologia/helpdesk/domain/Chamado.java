package br.com.lstecnologia.helpdesk.domain;

import br.com.lstecnologia.helpdesk.domain.enums.PrioridadeChamadoEnum;
import br.com.lstecnologia.helpdesk.domain.enums.StatusChamadoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "chamado")
public class Chamado implements Serializable {

    private static final long serialVersionUID = -7446267388342318885L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "timestamp", name = "data_abertura")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataAbertura;

    @Column(name = "data_encerramento")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEncerramento;

    @Column
    @Enumerated(EnumType.STRING)
    private PrioridadeChamadoEnum prioridade;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusChamadoEnum status;

    @Column
    private String titulo;

    @Column
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
