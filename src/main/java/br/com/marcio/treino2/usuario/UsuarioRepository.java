package br.com.marcio.treino2.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmailOrCpf(String email, String cpf);

    boolean existsByEmail(String email);

    Usuario findByEmail(String email);
}
