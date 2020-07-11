package com.nvntback.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private PedidoRepository pedidoRepository; 
	
	@GetMapping("/home")
	public String home() {
		return "alo home";
	}
	
	@GetMapping("/get-order-by-id")
	public List<PedidoDAO> getOrderByIDOrNone(@RequestParam(required=false) Long id) {
		List<PedidoDAO> pedidos = new ArrayList<PedidoDAO>();
		if ( id == 0 ) {
			Iterable<PedidoDAO> results = this.pedidoRepository.findAll();
			results.forEach(val -> {
				pedidos.add(val);
			});
		} else {
			PedidoDAO pedido = this.pedidoRepository.findByIdPedido(id);
			if ( pedido != null ) {
				pedidos.add(pedido);
			}
		}
		return pedidos;
	}
	
	@GetMapping("/insert-or-update")
	public void insertOrUpdate(
				@RequestParam(required=true) Long id,
				@RequestParam(required=false) String nombre,
				@RequestParam(required=false) String precio,
				@RequestParam(required=false) String discount) {
			try {
				// save en el crudrepository hace las veces de save or update jejeje... 
				
				PedidoDAO insertPedido = new PedidoDAO(nombre, precio, discount);
				this.pedidoRepository.savePedidoDAO(insertPedido);
			} catch (Exception e ) {
				e.printStackTrace();
			}
	}
	
	@GetMapping("/delete-order")
	public void deleteOrder(@RequestParam(required=true) Long id) {
		try {
			PedidoDAO pedido = this.pedidoRepository.deleteByIdPedido(id);
		} catch (Exception e ) {
			e.printStackTrace();
		}
	}
	
}
