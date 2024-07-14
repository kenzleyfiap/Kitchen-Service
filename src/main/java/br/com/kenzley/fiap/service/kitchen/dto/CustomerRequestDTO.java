package br.com.kenzley.fiap.service.kitchen.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CustomerRequestDTO {
    private String name;
    private String cpf;
    private String email;
}
