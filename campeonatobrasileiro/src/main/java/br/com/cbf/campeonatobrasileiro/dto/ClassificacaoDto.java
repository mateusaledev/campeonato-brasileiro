package br.com.cbf.campeonatobrasileiro.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClassificacaoDto extends ClassificacaoTimeDto {
    private List<ClassificacaoDto> times = new ArrayList<>();

}
