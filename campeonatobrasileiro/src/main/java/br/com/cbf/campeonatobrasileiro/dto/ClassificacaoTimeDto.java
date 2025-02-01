package br.com.cbf.campeonatobrasileiro.dto;

import lombok.Data;

@Data
public class ClassificacaoTimeDto implements Comparable<ClassificacaoTimeDto> {

    private String time;
    private Integer idTime;
    private Integer posicao;
    private Integer pontos;
    private Integer jogos;
    private Integer vitorias;
    private Integer empates;
    private Integer derrotas;
    private Integer golsMarcados;
    private Integer golsSofridos;


    @Override
    public int compareTo(ClassificacaoTimeDto o) {
        return this.getPontos().compareTo(o.getPontos());
    }
}
