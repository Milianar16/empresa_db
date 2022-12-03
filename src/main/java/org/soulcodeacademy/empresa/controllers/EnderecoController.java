package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.soulcodeacademy.empresa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EnderecoController {

        @Autowired
        private EnderecoService enderecoService;

        @GetMapping("/enderecos")
        public List<Endereco> listarEndereco(){
            return this.enderecoService.listarEndereco();
        }

        @GetMapping("/enderecos/{idEndereco}")
        public Endereco getEndereco(@PathVariable("idEndereco") Integer idEndereco){
            return this.enderecoService.getEndereco(idEndereco);
        }


        @PostMapping("/enderecos")
        public Endereco salvar(@Valid @RequestBody EnderecoDTO dto){
            return this.enderecoService.salvar(dto);
        }

        @PutMapping("/enderecos/{idEndereco}")
        public Endereco atualizar(@PathVariable("idEndereco") Integer idEndereco, @Valid @RequestBody EnderecoDTO dto) {
            Endereco atualizado = this.enderecoService.atualizar(idEndereco, dto);
            return atualizado;
        }

        @DeleteMapping("/enderecos/{idEndereco}")
        public void deletar(@PathVariable("idEndereco") Integer idEndereco) {
            this.enderecoService.deletar(idEndereco);
        }


    }


