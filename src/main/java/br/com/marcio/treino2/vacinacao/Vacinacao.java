package br.com.marcio.treino2.vacinacao;

import br.com.marcio.treino2.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Vacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeVacina;
    @ManyToOne
    private Usuario usuario;
    @Column(updatable = false)
    private final LocalDateTime dataVacinacao = LocalDateTime.now();

    public Vacinacao(@NotBlank String nomeVacina, Usuario usuario) {
        this.nomeVacina = nomeVacina;
        this.usuario = usuario;
    }

    @Deprecated
    public Vacinacao() {
    }

}
