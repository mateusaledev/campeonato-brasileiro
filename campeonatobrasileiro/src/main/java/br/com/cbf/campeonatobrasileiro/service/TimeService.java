package br.com.cbf.campeonatobrasileiro.service;

import br.com.cbf.campeonatobrasileiro.dto.TimeDto;
import br.com.cbf.campeonatobrasileiro.entity.Time;
import br.com.cbf.campeonatobrasileiro.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeService {
    @Autowired
    private TimeRepository repository;

    public TimeDto cadastrarTime(TimeDto time) throws Exception {
        Time entity = toEntity(time);

        if(time.getId() == null){
            Integer newId = Math.toIntExact(repository.count() + 1);
            entity.setId(newId);
            entity = repository.save(entity);
            return toDto(entity);
        }else{
            throw new Exception("Time já existe.");
        }
    }

    private Time toEntity(TimeDto time) {
        Time entity = new Time();
        entity.setId(time.getId());
        entity.setEstadio(time.getEstadio());
        entity.setSigla(time.getSigla());
        entity.setNome(time.getNome());
        entity.setUf(time.getUf());
        return entity;
    }

    public TimeDto toDto(Time entity) {
        TimeDto dto = new TimeDto();
        dto.setId(entity.getId());
        dto.setEstadio(entity.getEstadio());
        dto.setSigla(entity.getSigla());
        dto.setNome(entity.getNome());
        dto.setUf(entity.getUf());
        return dto;
    }

    public List<TimeDto> listarTime(){
        return repository.findAll().stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }

    public TimeDto obterTime(Integer id){
        return toDto(repository.findById(id).get());
    }


    public List<Time> findAll() {
        return repository.findAll();
    }
}
