package br.com.kenzley.fiap.service.kitchen.business;

import br.com.kenzley.fiap.service.kitchen.client.OrderClient;
import br.com.kenzley.fiap.service.kitchen.enums.OrderStatus;
import br.com.kenzley.fiap.service.kitchen.util.KitchenHelper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class KitchenServiceTest {
    @Mock
    private OrderClient orderClient;
    private KitchenService kitchenService;

    AutoCloseable mock;

    @BeforeEach
    void setup(){
        mock = MockitoAnnotations.openMocks(this);
        kitchenService = new KitchenService(
                orderClient
        );
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    void mustAllowUpdateOrderByStatusReceivedOrReady() {

        var orderResponseDTO = KitchenHelper.gerarOrderResponse();
        // Arrange
        when(orderClient.findOrdersByStatusReceivedOrReady()).thenReturn(List.of(orderResponseDTO));
        doNothing().when(orderClient).updateStatusOrder(any(Long.class), any(OrderStatus.class));

        // Act
        kitchenService.updateOrderByStatusReceivedOrReady();

        // Assert
        verify(orderClient, times(1)).updateStatusOrder(any(Long.class), any(OrderStatus.class));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    void mustAllowUpdateOrderByStatus() {

        var orderResponseDTO = KitchenHelper.gerarOrderResponse();
        // Arrange
        when(orderClient.findByOrderStatus(any(OrderStatus.class))).thenReturn(List.of(orderResponseDTO));
        doNothing().when(orderClient).updateStatusOrder(any(Long.class), any(OrderStatus.class));

        // Act
        kitchenService.updateOrderByStatus();

        // Assert
        verify(orderClient, times(1)).updateStatusOrder(any(Long.class), any(OrderStatus.class));
    }


}