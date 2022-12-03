package org.soulcodeacademy.empresa.domain.dto;


import org.soulcodeacademy.empresa.domain.Endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmpregadoDTO {

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;

    @NotNull(message = "Campo salário é obrigatório")
    private String email;

    @NotNull(message = "Campo salário inválido")
    private Double salario;

    @NotNull(message = "Campo endereço é obrigatório")
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public @NotNull(message = "Campo endereço é obrigatório") Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

