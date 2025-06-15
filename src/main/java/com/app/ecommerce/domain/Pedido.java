package com.app.ecommerce.domain;

import java.math.BigDecimal;

import com.app.ecommerce.enums.StatusPedido;
import com.app.ecommerce.state.AguardandoPagamento;
import com.app.ecommerce.state.Cancelado;
import com.app.ecommerce.state.Enviado;
import com.app.ecommerce.state.Pago;
import com.app.ecommerce.state.PedidoState;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // private String cliente;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.AGUARDANDO_PAGAMENTO;

    @Transient
    @JsonIgnore
    private PedidoState estadoAtual = new AguardandoPagamento();

    private String formaEnvio;

    private BigDecimal valorFrete;

    public void pagar() {
        estadoAtual.pagar(this);
    }

    public void cancelar() {
        estadoAtual.cancelar(this);
    }

    public void enviar() {
        estadoAtual.enviar(this);
    }

    public void sincronizarEstado() {
        switch (this.status) {
            case AGUARDANDO_PAGAMENTO -> this.estadoAtual = new AguardandoPagamento();
            case CANCELADO -> this.estadoAtual = new Cancelado();
            case PAGO -> this.estadoAtual = new Pago();
            case ENVIADO -> this.estadoAtual = new Enviado();
        }
    }

    public void calcularFrete(Frete frete) {
        // this.valorFrete = frete.calcular(this.valor);
        setValorFrete(frete.calcular(this.valor));
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorFrete() {
        return this.valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getFormaEnvio() {
        return this.formaEnvio;
    }

    public void setFormaEnvio(String formaEnvio) {
        this.formaEnvio = formaEnvio;
    }

    public StatusPedido getStatus() {
        return this.status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setEstadoAtual(PedidoState estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public PedidoState getEstadoAtual() {
        return this.estadoAtual;
    }
}