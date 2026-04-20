package br.com.faculdadecatolicapb.ms_produto.repository;

import br.com.faculdadecatolicapb.ms_produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
