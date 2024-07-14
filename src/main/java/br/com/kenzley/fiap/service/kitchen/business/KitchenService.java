package br.com.kenzley.fiap.service.kitchen.business;

import br.com.kenzley.fiap.service.kitchen.OrderClient;
import br.com.kenzley.fiap.service.kitchen.dto.OrderResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KitchenService {

    private final OrderClient orderClient;
    @Scheduled(fixedRate = 120000)
    public void updateOrder() {
        List<OrderResponseDTO> ordersByStatusReceivedOrReady = orderClient.findOrdersByStatusReceivedOrReady();

        Optional<OrderResponseDTO> order = ordersByStatusReceivedOrReady.stream()
                .min(Comparator.comparing(OrderResponseDTO::getDateTimeOrder));

        System.out.println(order.get().getCustomer().getName());


    }

}
