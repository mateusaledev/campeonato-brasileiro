package br.com.cbf.campeonatobrasileiro.service.rest;

import br.com.cbf.campeonatobrasileiro.dto.ClassificacaoDto;
import br.com.cbf.campeonatobrasileiro.dto.JogoDto;
import br.com.cbf.campeonatobrasileiro.service.JogoFinalizadoDto;
import br.com.cbf.campeonatobrasileiro.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/jogos")
public class JogoRestController {

    @Autowired
    private JogoService jogoService;

    @PostMapping(value = "/gerar-jogos")
    public ResponseEntity<Void> gerarJogos() {
        jogoService.gerarJogos(LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

     @GetMapping
    public ResponseEntity<List<JogoDto>> obterJogos(){
        return ResponseEntity.ok().body(jogoService.listarJogos());
    }

    @PostMapping(value = "/finalizar/{id}")
    public  ResponseEntity<JogoDto> finalizar(@PathVariable Integer id, @RequestBody JogoFinalizadoDto jogoDto) throws Exception {
        return ResponseEntity.ok().body(jogoService.finalizar(id, jogoDto));
    }

    @GetMapping(value = "/classificacao")
    public  ResponseEntity<ClassificacaoDto> classificacao(){
        return ResponseEntity.ok().body(jogoService.obterClassificacao());
    }

    @GetMapping(value = "/jogo/{id}")
    public  ResponseEntity<JogoDto> obterJogo(@PathVariable Integer id){
        return ResponseEntity.ok().body(jogoService.obterJogo(id));
    }
}
