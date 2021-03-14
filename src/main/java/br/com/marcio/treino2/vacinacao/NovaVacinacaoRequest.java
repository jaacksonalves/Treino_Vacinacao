package br.com.marcio.treino2.vacinacao;

import br.com.marcio.treino2.usuario.Usuario;
import br.com.marcio.treino2.usuario.UsuarioRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovaVacinacaoRequest {

    @NotBlank
    private String nomeVacina;
    @Email
    @NotBlank
    private String emailUsuario;

    public String getNomeVacina() {
        return nomeVacina;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public Vacinacao toModel(UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario);
        return new Vacinacao(nomeVacina, usuario);
    }
}
