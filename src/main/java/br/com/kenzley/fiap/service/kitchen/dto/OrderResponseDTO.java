package br.com.kenzley.fiap.service.kitchen.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class OrderResponseDTO {
    private Long id;
    private CustomerRequestDTO customer;
    private List<OrderProductResponseDTO> products;
    private LocalDateTime dateTimeOrder;
}
