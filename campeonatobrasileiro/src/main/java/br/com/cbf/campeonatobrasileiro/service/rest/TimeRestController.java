package br.com.cbf.campeonatobrasileiro.service.rest;

import br.com.cbf.campeonatobrasileiro.dto.TimeDto;
import br.com.cbf.campeonatobrasileiro.entity.Time;
import br.com.cbf.campeonatobrasileiro.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/times")
public class TimeRestController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public ResponseEntity<List<TimeDto>> getTimes(){
        return ResponseEntity.ok().body(timeService.listarTime());
    }

//    @ApiOperation(value = "Obtém os dados do time")
    @GetMapping(value = "/{id}")
    public ResponseEntity<TimeDto> getTime(@PathVariable Integer id){
        return ResponseEntity.ok().body(timeService.obterTime(id));
    }

    @PostMapping
    public ResponseEntity<TimeDto> cadastrarTime(@RequestBody TimeDto time) throws Exception {
        return ResponseEntity.ok().body(timeService.cadastrarTime(time));
    }

}
