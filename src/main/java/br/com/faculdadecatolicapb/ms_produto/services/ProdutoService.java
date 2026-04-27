package br.com.faculdadecatolicapb.ms_produto.services;

import br.com.faculdadecatolicapb.ms_produto.domain.Produto;
import br.com.faculdadecatolicapb.ms_produto.dto.ProdutoRequestDTO;
import br.com.faculdadecatolicapb.ms_produto.dto.ProdutoResponseDTO;
import br.com.faculdadecatolicapb.ms_produto.mapper.ProdutoMapper;
import br.com.faculdadecatolicapb.ms_produto.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoResponseDTO cadastrar(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoMapper.toEntity(produtoRequestDTO);

        produto = produtoRepository.save(produto);

        return produtoMapper.toDTO(produto);
    }

    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto protudo = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("O produto não foi encontrado."));

        return produtoMapper.toDTO(protudo);
    }

    public List<ProdutoResponseDTO> buscarTodos() {
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream().map(produtoMapper::toDTO).toList();
    }

    public void deletar(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("O produto não foi encontrado."));

        produtoRepository.delete(produto);
    }

    public ProdutoResponseDTO editar(Long id, ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("O produto não foi encontrado."));

        produto.setNome(produtoRequestDTO.nome());
        produto.setValor(produtoRequestDTO.valor());
        produto.setEstoque(produtoRequestDTO.estoque());

        produto = produtoRepository.save(produto);

        return produtoMapper.toDTO(produto);
    }

    public void reduzirEstoque(Long id, Integer quantidade) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        if (produto.getEstoque() < quantidade) {
            throw new RuntimeException("Estoque insuficiente");
        }

        produto.setEstoque(produto.getEstoque() - quantidade);
        produtoRepository.save(produto);
    }
}
