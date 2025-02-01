package br.com.cbf.campeonatobrasileiro.dto;

import br.com.cbf.campeonatobrasileiro.entity.Jogo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JogoDto {

    private Integer id;
    private LocalDateTime data;
    private Integer golsTime1;
    private Integer golsTime2;
    private Integer publicoPagante;
    private Boolean encerrado;
    private Integer rodada;
    private TimeDto time1;
    private TimeDto time2;

}
