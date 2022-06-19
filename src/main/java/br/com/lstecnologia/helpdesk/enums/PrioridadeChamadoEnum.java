package br.com.lstecnologia.helpdesk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum PrioridadeChamadoEnum {

    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private Integer codigo;
    private String descricao;

    PrioridadeChamadoEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @JsonValue
    public Integer getCodigo() {
        return codigo;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static PrioridadeChamadoEnum decode(final Integer codigo) {
        return Stream.of(PrioridadeChamadoEnum.values())
                .filter(targetEnum -> targetEnum.codigo.equals(codigo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Prioridade chamado inválida"));
    }

}
