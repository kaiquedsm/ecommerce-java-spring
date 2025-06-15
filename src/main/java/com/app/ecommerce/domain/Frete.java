package com.app.ecommerce.domain;

import java.math.BigDecimal;

// Strategy: A lógica de frete foi extraída para a interface Frete, permitindo que cada tipo de envio tenha sua própria classe 
// com a regra de cálculo. Seguindo o princípio Open/Closed, novos métodos de envio podem ser adicionados sem alterar a classe 
// Pedido, apenas criando novas implementações de Frete.
public interface Frete {
    BigDecimal calcular(BigDecimal valor);    
}