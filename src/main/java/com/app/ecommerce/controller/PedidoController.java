package com.app.ecommerce.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecommerce.domain.FreteAereo;
import com.app.ecommerce.domain.FreteMaritimo;
import com.app.ecommerce.domain.FreteTerrestre;
import com.app.ecommerce.domain.Pedido;
import com.app.ecommerce.dto.PedidoDTO;
import com.app.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service; 
    }

    @PostMapping("/criar")
    public Pedido criar(@RequestParam BigDecimal valor, @RequestParam String formaEnvio) {
        if ("aereo".equalsIgnoreCase(formaEnvio)) {
            return service.criarPedido(formaEnvio, valor, new FreteAereo());
        } else if("maritimo".equalsIgnoreCase(formaEnvio)) {
            return service.criarPedido(formaEnvio, valor, new FreteMaritimo());
        } else {
            return service.criarPedido(formaEnvio, valor, new FreteTerrestre());
        }
    }

    @PostMapping("/{id}/pagar")
    public Pedido pagar(@PathVariable Long id) {
        return service.pagar(id);
    }

    @PostMapping("/{id}/cancelar")
    public Pedido cancelar(@PathVariable Long id) {
        return service.cancelar(id);
    }

    @PostMapping("/{id}/enviar")
    public Pedido enviar(@PathVariable Long id) {
        return service.enviar(id);
    }

    @GetMapping("/pedidos")
    public List<PedidoDTO> listar() {
        return service.listarPedidos();
    }

}
