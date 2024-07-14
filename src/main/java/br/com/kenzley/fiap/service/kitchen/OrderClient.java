package br.com.kenzley.fiap.service.kitchen;

import br.com.kenzley.fiap.service.kitchen.dto.OrderResponseDTO;
import br.com.kenzley.fiap.service.kitchen.enums.OrderStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "order", url = "${feign.client.config.order.url}")
public interface OrderClient {

    @GetMapping("/kitchen")
    List<OrderResponseDTO> findOrdersByStatusReceivedOrReady();

    @GetMapping("/status/{statusOrder}")
    List<OrderResponseDTO> findByOrderStatus(@PathVariable("statusOrder") OrderStatus orderStatus);
    @PutMapping("/{id}/{statusOrder}")
    void updateStatusOrder(@PathVariable Long id, @PathVariable OrderStatus statusOrder);
}
