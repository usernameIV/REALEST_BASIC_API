package grupo.nomeGrupo.controller;

import grupo.nomeGrupo.entity.Pessoa;
import grupo.nomeGrupo.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    private final PessoaService pServ;

    @GetMapping("/todas")
    public ResponseEntity<List<Pessoa>> retornaTodasPessoas() {
        return ResponseEntity.ok(pServ.bringAllPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> retornaPessoaPorId(@PathVariable UUID id){
        Pessoa pessoaRetornada = pServ.findPessoaById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRetornada);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pServ.createPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

}
