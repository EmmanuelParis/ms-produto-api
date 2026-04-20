package br.com.faculdadecatolicapb.ms_produto.controller;

import br.com.faculdadecatolicapb.ms_produto.dto.ProdutoRequestDTO;
import br.com.faculdadecatolicapb.ms_produto.dto.ProdutoResponseDTO;
import br.com.faculdadecatolicapb.ms_produto.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrar(ProdutoRequestDTO produtoRequestDTO) {
        return ResponseEntity.ok(produtoService.cadastrar(produtoRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        produtoService.apagar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{/id}")
    public ResponseEntity<ProdutoResponseDTO> editar(@PathVariable Long id, ProdutoRequestDTO produtoRequestDTO) {
        return ResponseEntity.ok(produtoService.editar(id, produtoRequestDTO));
    }
}
