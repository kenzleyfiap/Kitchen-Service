package br.com.kenzley.fiap.service.kitchen.util;

import br.com.kenzley.fiap.service.kitchen.dto.CustomerRequestDTO;
import br.com.kenzley.fiap.service.kitchen.dto.OrderProductResponseDTO;
import br.com.kenzley.fiap.service.kitchen.dto.OrderResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class KitchenHelper {
    public static OrderResponseDTO gerarOrderResponse() {
        return OrderResponseDTO.builder()
                .dateTimeOrder(LocalDateTime.now())
                .customer(gerarCustomerRequestDTO())
                .id(1L)
                .products(List.of(gerarOrderProductResponseDTO()))
                .build();
    }

    public static CustomerRequestDTO gerarCustomerRequestDTO() {
        return CustomerRequestDTO.builder()
                .name("Teste")
                .cpf("11111111111")
                .build();
    }

    public static OrderProductResponseDTO gerarOrderProductResponseDTO() {
        return OrderProductResponseDTO.builder()
                .productId("teste")
                .category("teste")
                .price(new BigDecimal("10.0"))
                .information("teste")
                .name("teste")
                .build();
    }
}
