package br.com.marcio.treino2.vacinacao;

import br.com.marcio.treino2.usuario.UsuarioRepository;
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
@RequestMapping("/api/vacinacao")
public class VacinacaoController {

    @Autowired
    private VacinacaoRepository vacinacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    public ResponseEntity<?> cadastraVacinacao(@Valid @RequestBody NovaVacinacaoRequest request) {
        if (!usuarioRepository.existsByEmail(request.getEmailUsuario())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não encontrado");
        }

        Vacinacao vacinacao = request.toModel(usuarioRepository);
        vacinacaoRepository.save(vacinacao);

        return ResponseEntity.status(201).build();
    }

}
