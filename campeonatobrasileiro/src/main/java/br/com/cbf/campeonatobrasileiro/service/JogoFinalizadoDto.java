package br.com.cbf.campeonatobrasileiro.service;

import br.com.cbf.campeonatobrasileiro.dto.TimeDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JogoFinalizadoDto {

    private LocalDateTime data;
    private Integer golsTime1;
    private Integer golsTime2;
    private Integer publicoPagante;


}

