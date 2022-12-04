package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.soulcodeacademy.empresa.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
public class EmpregadoController {


    @Autowired
    private EmpregadoService empregadoService;

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/empregados")
    public List<Empregado> listarEmpregado() {
        return this.empregadoService.listarEmpregados();
    }

    @GetMapping("/empregados/{idEmpregado}")
    public Empregado getEmpregado(@PathVariable Integer idEmpregado) {
        return this.empregadoService.getEmpregado(idEmpregado);
    }


    @PostMapping("/empregados")
    public Empregado salvar(@Valid @RequestBody EmpregadoDTO dto) {
        return this.empregadoService.salvar(dto);
    }

    @PutMapping("/empregados/{idEmpregado}")
    public Empregado atualizar(@PathVariable Integer idEmpregado, @Valid @RequestBody EmpregadoDTO dto) {
        Empregado atualizado = this.empregadoService.atualizar(idEmpregado, dto);
        return atualizado;
    }


    @PutMapping("/empregados/{idEmpregado}/projetos/{idProjeto}/adicionar")
    public ResponseEntity adicionarProjeto(@PathVariable Integer idEmpregado, @PathVariable Integer idProjeto) {

        empregadoService.adicionarProjeto(idEmpregado, idProjeto);

        return ResponseEntity.ok().body("Projeto "+idProjeto+" adicionado ao empregado: "+idEmpregado);

    }

    @PutMapping("/empregados/{idEmpregado}/projetos/{idProjeto}/deletar")
    public ResponseEntity deletarProjeto(@PathVariable Integer idEmpregado, @PathVariable Integer idProjeto) {

        empregadoService.removerProjeto(idEmpregado, idProjeto);

        return ResponseEntity.ok().body("Projeto "+idProjeto+" removido do empregado: "+idEmpregado);
    }


    @DeleteMapping ("/empregados/{idEmpregado}")
    public void deletar(@PathVariable Integer idEmpregado) {
        this.empregadoService.deletar(idEmpregado);
    }

}


