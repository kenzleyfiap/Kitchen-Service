package br.com.kenzley.fiap.service.kitchen;

import br.com.kenzley.fiap.service.kitchen.dto.OrderResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "order", url = "${feign.client.config.order.url}")
public interface OrderClient {

    @GetMapping("/kitchen")
    List<OrderResponseDTO> findOrdersByStatusReceivedOrReady();
}
