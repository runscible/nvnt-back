package com.nvntback.order;

import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<PedidoDAO, Long>{
	PedidoDAO findByIdPedido(Long idPedido); 
	PedidoDAO deleteByIdPedido(Long idPedido);
	PedidoDAO existsByIdPedido(Long idPedido);
	PedidoDAO savePedidoDAO(PedidoDAO pedidoDAO);
}
