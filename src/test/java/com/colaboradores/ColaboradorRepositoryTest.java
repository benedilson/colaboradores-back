package com.colaboradores;

import com.colaboradores.model.Colaborador;
import com.colaboradores.repository.ColaboradorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ColaboradorRepositoryTest {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Test
    public void testSalvarColaborador() {
        Colaborador colaborador = new Colaborador();
        colaborador.setNome("Nome do Colaborador");
        colaborador.setSenha("Senha do Colaborador");

        Colaborador savedColaborador = colaboradorRepository.save(colaborador);

        assertThat(savedColaborador).isNotNull();
        assertThat(savedColaborador.getId()).isNotNull();
        assertThat(savedColaborador.getNome()).isEqualTo("Nome do Colaborador");
        assertThat(savedColaborador.getSenha()).isEqualTo("Senha do Colaborador");
    }

    @Test
    public void testBuscarColaboradorPorNome() {
        Colaborador colaborador = new Colaborador();
        colaborador.setNome("Nome de Teste");
        colaborador.setSenha("Senha de Teste");
        colaboradorRepository.save(colaborador);

        Colaborador foundColaborador = colaboradorRepository. findByNome("Nome de Teste");

        assertThat(foundColaborador).isNotNull();
        assertThat(foundColaborador.getNome()).isEqualTo("Nome de Teste");
        assertThat(foundColaborador.getSenha()).isEqualTo("Senha de Teste");
    }
}
