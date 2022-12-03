package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

        @Autowired
        private EnderecoRepository enderecoRepository;

        public List<Endereco> listarEndereco(){
            return this.enderecoRepository.findAll();
        }

        public Endereco getEndereco(Integer idEndereco){
            Optional<Endereco> endereco = this.enderecoRepository.findById(idEndereco);
            if(endereco.isEmpty()){
                throw new RuntimeException("Endereco não foi encontrado");
            }else {
                return endereco.get();
            }

        }

        public Endereco salvar(EnderecoDTO dto){
            Endereco enderecoNovo = new Endereco(null, dto.getCidade(), dto.getUf());
            return this.enderecoRepository.save(enderecoNovo);
        }

        public Endereco atualizar(Integer idEndereco, EnderecoDTO dto){
            Endereco enderecoAtual = this.getEndereco(idEndereco);

            enderecoAtual.setCidade(dto.getCidade());
            enderecoAtual.setUf(dto.getUf());


            return this.enderecoRepository.save(enderecoAtual);
        }

        //Deletar
        public void deletar(Integer idEndereco) {
            this.enderecoRepository.deleteById(idEndereco);
        }


}

