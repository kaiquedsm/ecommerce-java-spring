package com.app.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ecommerce.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
