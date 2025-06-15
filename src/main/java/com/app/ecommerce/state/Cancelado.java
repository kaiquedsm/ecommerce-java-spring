package com.app.ecommerce.state;

import com.app.ecommerce.domain.Pedido;

public class Cancelado implements PedidoState {

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido não pode mais ser pago");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido não pode mais ser cancelado");
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido não pode mais ser enviado");
    }
}
