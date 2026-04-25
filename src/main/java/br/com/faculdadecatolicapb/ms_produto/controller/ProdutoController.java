package br.com.faculdadecatolicapb.ms_produto.controller;

import br.com.faculdadecatolicapb.ms_produto.client.PedidoDTO;
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

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrar(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        return ResponseEntity.ok(produtoService.cadastrar(produtoRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> editar(@PathVariable Long id, @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        return ResponseEntity.ok(produtoService.editar(id, produtoRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}/pedidos")
    public ResponseEntity<List<PedidoDTO>> buscarPedidos(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPedidosDoProduto(id));
    }

    @PostMapping("/{id}/reduzir-estoque")
    public ResponseEntity<Void> reduzirEstoque(@PathVariable Long id, @RequestParam Integer quantidade) {

        produtoService.reduzirEstoque(id, quantidade);
        return ResponseEntity.ok().build();
    }
}
