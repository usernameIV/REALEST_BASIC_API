package grupo.nomeGrupo.service;

import grupo.nomeGrupo.entity.Pessoa;
import grupo.nomeGrupo.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepo;

    public List<Pessoa> bringAllPessoas() {
        return pessoaRepo.findAll();
    }

    public Pessoa findPessoaById(UUID id){
        return pessoaRepo.findById(id).get();
    }

    public Pessoa createPessoa(Pessoa pessoa) {
        return pessoaRepo.save(pessoa);
    }


}
