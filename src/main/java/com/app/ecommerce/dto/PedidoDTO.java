package com.app.ecommerce.dto;

import java.math.BigDecimal;

import com.app.ecommerce.enums.StatusPedido;

import lombok.Data;

@Data
public class PedidoDTO {

    private BigDecimal valor;
    private BigDecimal valorFrete;
    private StatusPedido status;
    private String formaEnvio;


}
