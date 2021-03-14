package br.com.marcio.treino2.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    public ResponseEntity<?> cadastraUsuario(@Valid @RequestBody NovoUsuarioRequest request) {
        //Valida se existe cpf ou email ja cadastrado
        if (usuarioRepository.existsByEmailOrCpf(request.getEmail(), request.getCpf())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe cadastro com esse email ou cpf");
        }

        Usuario novoUsuario = request.toModel();
        usuarioRepository.save(novoUsuario);

        return ResponseEntity.status(201).build();
    }
}
