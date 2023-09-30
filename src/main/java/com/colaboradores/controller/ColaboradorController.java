package com.colaboradores.controller;

import com.colaboradores.dto.ColaboradorDTO;
import com.colaboradores.model.Colaborador;
import com.colaboradores.repository.ColaboradorRepository;
import com.colaboradores.service.SenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private SenhaService senhaService;

    @GetMapping
    public List<ColaboradorDTO> listarColaboradores() {
        List<Colaborador> colaboradores = colaboradorRepository.findAll();
        List<ColaboradorDTO> colaboradoresDTO = new ArrayList<>();

        for (Colaborador colaborador : colaboradores) {
            ColaboradorDTO colaboradorDTO = new ColaboradorDTO();
            colaboradorDTO.setId(colaborador.getId());
            colaboradorDTO.setNome(colaborador.getNome());

            String senha = colaborador.getSenha();
            int forcaSenha = senhaService.calcularForcaSenha(senha);

            colaboradoresDTO.add(senhaService.validarSenha(forcaSenha, colaboradorDTO));
        }

        return colaboradoresDTO;
    }


    @PostMapping
    public Colaborador criarColaborador(@RequestBody Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    @GetMapping("/{id}")
    public Colaborador buscarColaborador(@PathVariable Long id) {
        return colaboradorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Colaborador atualizarColaborador(@PathVariable Long id, @RequestBody Colaborador colaborador) {
        colaborador.setId(id);
        return colaboradorRepository.save(colaborador);
    }

    @DeleteMapping("/{id}")
    public void deletarColaborador(@PathVariable Long id) {
        colaboradorRepository.deleteById(id);
    }
}

