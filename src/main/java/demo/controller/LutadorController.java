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
}