package br.com.cbf.campeonatobrasileiro.repository;

import br.com.cbf.campeonatobrasileiro.entity.Jogo;
import br.com.cbf.campeonatobrasileiro.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {

    List<Jogo> findByTime1AndEncerrado(Time time1, Boolean encerrado);
    List<Jogo> findByTime2AndEncerrado(Time time1, Boolean encerrado);
}
