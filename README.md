# Kitchen-Service
Serviço responsável por operacionalizar o processo de produção do Pedido,
acompanhando a fila de pedidos, atualização de status de cada passo do pedido.

### Arquitetura
<img src="assets/fiap_services.drawio.png" width="400" height="500">

### Evidência sonar
<img src="assets/sonar.png">

## Comandos para rodar os testes

<b>Testes de integração
```
mvn test -P integration-test
```
<b>Testes de sistema
```
mvn test
```
<b>BDD test
```
mvn test -P system-test
```


# Entregável fase 04
### Para essa fase 04 do projeto, estamos implementando os seguintes desafios:
* Quebra do Monolíico em Microserviços conforme a arquitetura acima
* Implementação de qualidade de código com sonar

