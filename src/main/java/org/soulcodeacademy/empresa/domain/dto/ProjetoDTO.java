package org.soulcodeacademy.empresa.domain.dto;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProjetoDTO {

    @NotBlank(message = "Campo descricao é obrigatório!!")
    private String descricao;

    @NotNull(message = "Campo nome é obrigatório!!")
    private String nome;

    @NotNull(message = "Campo orçamento é obrigatório!")
    private Double orcamento;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }
}
