package com.app.ecommerce.state;

import com.app.ecommerce.domain.Pedido;

// State: Cada estado do pedido foi encapsulado em uma classe específica, permitindo que o próprio estado controle seu  
// comportamento. Com isso, a classe Pedido deixa de ter if, else ou switch para validar ações como pagar(), cancelar() e enviar(). 
// Isso evitaalterações frequentes em Pedido sempre que novos estados forem adicionados, tornando o sistema mais organizado, 
// extensível e de fácil manutenção.
public interface PedidoState {
    void pagar(Pedido pedido);
    void cancelar(Pedido pedido);
    void enviar(Pedido pedido);
}
