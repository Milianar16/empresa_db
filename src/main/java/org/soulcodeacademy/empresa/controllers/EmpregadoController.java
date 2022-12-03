package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
public class EmpregadoController {


    @Autowired
    private EmpregadoService empregadoService;

    @GetMapping("/empregados")
    public List<Empregado> listarEmpregado(){
        return this.empregadoService.listarEmpregados();
    }

    @GetMapping("/empregados/{idEmpregado}")
    public Empregado getEmpregado(@PathVariable Integer idEmpregado){
        return this.empregadoService.getEmpregado(idEmpregado);
    }


    @PostMapping("/empregados")
    public Empregado salvar(@Valid @RequestBody EmpregadoDTO dto){
        return this.empregadoService.salvar(dto);
    }

    @PutMapping("/empregados/{idEmpregado}")
    public Empregado atualizar(@PathVariable Integer idEmpregado, @Valid @RequestBody EmpregadoDTO dto) {
        Empregado atualizado = this.empregadoService.atualizar(idEmpregado, dto);
        return atualizado;
    }

    @DeleteMapping("/empregados/{idEmpregado}")
    public void deletar(@PathVariable Integer idEmpregado) {
        this.empregadoService.deletar(idEmpregado);
    }


}
