package com.app.ecommerce.domain;

import java.math.BigDecimal;

public class FreteAereo implements Frete {

    @Override
    public BigDecimal calcular(BigDecimal valorPedido) {
        return valorPedido.multiply(BigDecimal.valueOf(0.10));
    }
    
}
