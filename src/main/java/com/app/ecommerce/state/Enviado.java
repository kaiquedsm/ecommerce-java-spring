package com.app.ecommerce.state;

import com.app.ecommerce.domain.Pedido;
import com.app.ecommerce.enums.StatusPedido;

public class Enviado implements PedidoState {

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está pago");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido não pode mais ser cancelado");
    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.setStatus(StatusPedido.ENVIADO);
        pedido.setEstadoAtual(new Enviado());
    }
    
}
