package com.colaboradores.service;

import com.colaboradores.dto.ColaboradorDTO;
import org.springframework.stereotype.Service;

@Service
public class SenhaService {
    public ColaboradorDTO validarSenha(int forcaSenha, ColaboradorDTO colaboradorDTO) {
        if (forcaSenha <= 20) {
            colaboradorDTO.setCor("vermelha");
            colaboradorDTO.setPorcentagem(10);
        } else if (forcaSenha <= 40) {
            colaboradorDTO.setCor("amarela");
            colaboradorDTO.setPorcentagem(45);
        } else if (forcaSenha <= 60) {
            colaboradorDTO.setCor("verde claro");
            colaboradorDTO.setPorcentagem(60);
        } else {
            colaboradorDTO.setCor("verde escuro");
            colaboradorDTO.setPorcentagem(100);
        }

        return colaboradorDTO;
    }

    public int calcularForcaSenha(String senha) {

        boolean possuiMinimoComprimento = senha.length() >= 8;
        boolean possuiMaiuscula = senha.chars().anyMatch(Character::isUpperCase);
        boolean possuiMinuscula = senha.chars().anyMatch(Character::isLowerCase);
        boolean possuiNumero = senha.chars().anyMatch(Character::isDigit);
        boolean possuiSimbolo = senha.chars().anyMatch(ch -> "!@#$%^&*()_-+=<>?".indexOf(ch) >= 0);

        int criteriosAtendidos = 0;
        if (possuiMinimoComprimento) criteriosAtendidos++;
        if (possuiMaiuscula) criteriosAtendidos++;
        if (possuiMinuscula) criteriosAtendidos++;
        if (possuiNumero) criteriosAtendidos++;
        if (possuiSimbolo) criteriosAtendidos++;

        int forcaSenha = (criteriosAtendidos * 100) / 5;

        return forcaSenha;
    }
}
