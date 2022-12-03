package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private EmpregadoRepository  empregadoRepository;


    public List<Dependente> listarDependente(){
        return this.dependenteRepository.findAll();
    }

    public Dependente getDependente(Integer idDependente){
        Optional<Dependente> dependente = this.dependenteRepository.findById(idDependente);
        if(dependente.isEmpty()){
            throw new RuntimeException("Dependente não encontrado");
        }else {
            return dependente.get();
        }

    }

    public Dependente salvar(DependenteDTO dto){
        Dependente dependenteNovo = new Dependente(null, dto.getNome(), dto.getIdade(), dto.getResponsavel());

        if(!empregadoRepository.exists(Example.of(dependenteNovo.getResponsavel()))){
            empregadoRepository.save(dependenteNovo.getResponsavel());
        }

        return this.dependenteRepository.save(dependenteNovo);
    }

    public Dependente atualizar(Integer idDependente, DependenteDTO dto){
        Dependente DependenteAtual = this.getDependente(idDependente);

        DependenteAtual.setIdade(dto.getIdade());
        DependenteAtual.setNome(dto.getNome());


        return this.dependenteRepository.save(DependenteAtual);
    }

    //Deletar
    public void deletar(Integer idDependente) {
        this.dependenteRepository.deleteById(idDependente);
    }
}


