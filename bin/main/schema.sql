CREATE TABLE pedidos (
	id_pedido BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
	nombre VARCHAR(100) NOT NULL,
	precio VARCHAR(20) NOT NULL, 
	descuento VARCHAR(20) NOT NULL
);
