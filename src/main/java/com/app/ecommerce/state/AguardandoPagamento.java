package com.app.ecommerce.state;

import com.app.ecommerce.domain.Pedido;
import com.app.ecommerce.enums.StatusPedido;

public class AguardandoPagamento implements PedidoState {

    @Override
    public void pagar(Pedido pedido) {
        pedido.setStatus(StatusPedido.PAGO);
        pedido.setEstadoAtual(new Pago());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setStatus(StatusPedido.CANCELADO);
        pedido.setEstadoAtual(new Cancelado());
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido só pode ser enviado se estiver pago");
    }
    
}
