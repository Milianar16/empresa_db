package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Empregado> listarEmpregados(){
        return this.empregadoRepository.findAll();
    }

    public Empregado getEmpregado(Integer idEmpregado){
        Optional<Empregado> empregado = this.empregadoRepository.findById(idEmpregado);
        if(empregado.isEmpty()){
            throw new RuntimeException("Empregado não foi encontrado");
        }else {
            return empregado.get();
        }

    }

    public Empregado salvar(EmpregadoDTO dto){
        Empregado empregadoNovo = new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario(), dto.getEndereco());

        if(!enderecoRepository.exists(Example.of(empregadoNovo.getEndereco()))){
            enderecoRepository.save(empregadoNovo.getEndereco());
        }

        return this.empregadoRepository.save(empregadoNovo);
    }

    public Empregado atualizar(Integer idEmpregado, EmpregadoDTO dto){
        Empregado empregadoAtual = this.getEmpregado(idEmpregado);

        empregadoAtual.setNome(dto.getNome());
        empregadoAtual.setEmail(dto.getEmail());
        empregadoAtual.setSalario(dto.getSalario());
        empregadoAtual.getProjetos().remove(new Projeto());

        return this.empregadoRepository.save(empregadoAtual);
    }
    public void adicionarProjeto(Integer idEmpregado, Integer idProjeto){

        Empregado empregado = empregadoRepository.findById(idEmpregado).get();
        Projeto projeto = new Projeto();
        projeto.setIdProjeto(idProjeto);

        empregado.getProjetos().add(projeto);

        empregadoRepository.save(empregado);

    }

    public void removerProjeto(Integer idEmpregado, Integer idProjeto){
        Empregado empregado = empregadoRepository.findById(idEmpregado).get();

        Projeto projeto = new Projeto();
        projeto.setIdProjeto(idProjeto);

        empregado.getProjetos().remove(projeto);

        empregadoRepository.save(empregado);
    }


    //Deletar
    public void deletar(Integer idEmpregado) {
        Empregado empregado = this.getEmpregado(idEmpregado); //puxa o empregado pelo id
        this.empregadoRepository.delete(empregado); // repository manipula o banco e deleta
    }
}