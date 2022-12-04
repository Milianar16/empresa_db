package org.soulcodeacademy.empresa.services;



import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;


@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarProjeto() {
        return this.projetoRepository.findAll();
    }


    public Projeto getProjeto(Integer idProjeto) {
        Optional<Projeto> projeto = this.projetoRepository.findById(idProjeto);
        if (projeto.isEmpty()) {
            throw new RuntimeException("Projeto não encontrado");
        } else {
            return projeto.get();
        }

    }
        public Projeto salvar(ProjetoDTO dto)
        {
            Projeto projetoNovo = new Projeto(null, dto.getNome(), dto.getOrcamento(), dto.getDescricao());

            return this.projetoRepository.save(projetoNovo);
        }

        public Projeto atualizar (Integer idProjeto, ProjetoDTO dto){

            Projeto projeto = new Projeto();
            projeto.setIdProjeto(idProjeto);
            projeto.setDescricao(dto.getDescricao());
            projeto.setNome(dto.getNome());
            projeto.setOrcamento(dto.getOrcamento());

            Projeto atualizado = this.projetoRepository.save(projeto);
            return atualizado;
        }

        public void deletar (Integer idProjeto){
            this.projetoRepository.deleteById(idProjeto);
        }


    }




