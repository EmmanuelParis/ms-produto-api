package br.com.faculdadecatolicapb.ms_produto.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "pedido-service", url = "http://pedido:8081")
public interface PedidoClient {

    @GetMapping("/api/v1/pedidos/produto/{produtoId}")
    List<PedidoDTO> buscarPedidosPorProduto(@PathVariable Long produtoId);
}