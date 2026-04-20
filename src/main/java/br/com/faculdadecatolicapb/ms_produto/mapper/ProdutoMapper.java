package br.com.faculdadecatolicapb.ms_produto.mapper;

import br.com.faculdadecatolicapb.ms_produto.domain.Produto;
import br.com.faculdadecatolicapb.ms_produto.dto.ProdutoRequestDTO;
import br.com.faculdadecatolicapb.ms_produto.dto.ProdutoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    Produto toEntity(ProdutoRequestDTO dto);

    ProdutoResponseDTO toDTO(Produto entity);
}
