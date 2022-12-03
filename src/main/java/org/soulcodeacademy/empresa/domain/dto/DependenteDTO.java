package org.soulcodeacademy.empresa.domain.dto;

import org.soulcodeacademy.empresa.domain.Empregado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DependenteDTO {


    @NotNull(message = "Campo salário é obrigatório")
    private Integer idade;

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;

    private Empregado responsavel;

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Empregado getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Empregado responsavel) {
        this.responsavel = responsavel;
    }
}
