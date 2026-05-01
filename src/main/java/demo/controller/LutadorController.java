package demo.controller;

import demo.model.Lutador;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lutadores")
@Tag(name = "Lutadores", description = "Endpoints para gerenciar os lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @GetMapping
    @Operation(summary = "Lista todos os lutadores cadastrados")
    public List<Lutador> listar() {
        return repository.findAll();
    }

    @PostMapping
    @Operation(summary = "Cadastra um novo lutador")
    public Lutador cadastrar(@RequestBody Lutador lutador) {
        return repository.save(lutador);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um lutador específico pelo ID")
    public ResponseEntity<Lutador> buscarPorId(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza os dados de um lutador existente")
    public ResponseEntity<Lutador> atualizar(@PathVariable int id, @RequestBody Lutador lutadorAtualizado) {
        return repository.findById(id)
                .map(lutador -> {
                    // Atualizando todos os campos baseados na sua classe Lutador.java
                    lutador.setNome(lutadorAtualizado.getNome());
                    lutador.setCategoria(lutadorAtualizado.getCategoria());
                    lutador.setApelido(lutadorAtualizado.getApelido());
                    lutador.setArte(lutadorAtualizado.getArte());

                    Lutador salvo = repository.save(lutador);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um lutador do sistema")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        return repository.findById(id)
                .map(lutador -> {
                    repository.delete(lutador);
                    // Status 204 No Content: Sucesso, mas sem corpo na resposta
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}