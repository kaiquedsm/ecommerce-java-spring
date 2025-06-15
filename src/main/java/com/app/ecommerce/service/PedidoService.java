package com.app.ecommerce.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.ecommerce.domain.Frete;
import com.app.ecommerce.domain.Pedido;
import com.app.ecommerce.dto.PedidoDTO;
import com.app.ecommerce.repository.PedidoRepository;

// Facade: O padrão Facade foi utilizado para centralizar e simplificar o acesso à lógica de negócio relacionada aos pedidos. Ele permite 
// que a camada de controle interaja com o sistema por meio de uma interface única e direta, sem precisar conhecer os detalhes de 
// implementação. Isso promove baixo acoplamento, organização do código e facilidade de manutenção
@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido criarPedido(String formaEnvio, BigDecimal valor, Frete frete) {
        Pedido pedido = new Pedido();
        pedido.setFormaEnvio(formaEnvio);
        pedido.setValor(valor);
        pedido.calcularFrete(frete);
        return repository.save(pedido);
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Pedido pagar(Long id) {
        Pedido pedido = buscarPorId(id).orElseThrow();
        pedido.sincronizarEstado();
        pedido.pagar();
        return repository.save(pedido);
    }
    
    public Pedido cancelar(Long id) {
        Pedido pedido = buscarPorId(id).orElseThrow();
        pedido.sincronizarEstado();
        pedido.cancelar();
        return repository.save(pedido);
    }
    
    public Pedido enviar(Long id) {
        Pedido pedido = buscarPorId(id).orElseThrow();
        pedido.sincronizarEstado();
        pedido.enviar();
        return repository.save(pedido);
    }

    public List<PedidoDTO> listarPedidos() {
        return repository.findAll().stream().map(p -> {
            PedidoDTO dto = new PedidoDTO();
            dto.setValor(p.getValor());
            dto.setValorFrete(p.getValorFrete());
            dto.setFormaEnvio(p.getFormaEnvio());
            dto.setStatus(p.getStatus());
            return dto;
        }).collect(Collectors.toList());
    }
    
}
