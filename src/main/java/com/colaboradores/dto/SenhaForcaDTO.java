package com.colaboradores.dto;

import lombok.Data;

@Data
public class SenhaForcaDTO {
    private String senha;
    private boolean valida;
    private String cor;
    private int porcentagem;
    private int forca;
}
