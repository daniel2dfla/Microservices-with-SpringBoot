# 📋 Microservices-with-SpringBoot

### Descrição

O objetivo é criar um projeto de microsserviços que atravéz de dados de crédito do cliente (no nosso caso é randômico), autorize ou não o emprestimo solicitado pelo cliente. 

### Proposta

- A aplicação deve ser construida usando Java com SpringBoot.
- Usar banco de dados para salvar os dados do cliente.
- Usar o servico SNS(Amazon Simple Notification Service) da AWS para enviar notificações via SMS para o cliente.
- Deve ser criado uma lógica para calcular o Score do cliente de forma aleatória.
- Usar o RabbitMQ para criar as Exchanges e as Queues necessárias para o projeto, são elas:
  * Queue proposta-concluida.ms-notificacao
  * Queue proposta-concluida.ms-proposta
  * Queue proposta-pendente.dlq
  * Queue proposta-pendente.ms-analise-credito
  * Queue proposta-pendente.ms-notificacao
 
### Evidencias
- Solicitação do empréstimo solicitada pelo usuário.
<img src="https://github.com/daniel2dfla/Microservices-with-SpringBoot/blob/main/img/SolicitacaoProposta.png" width="500"  alt="Solicitação do emprestimo">

- Resultado da solicitação (baseado em dados aleatório do score).
<img src="https://github.com/daniel2dfla/Microservices-with-SpringBoot/blob/main/img/Resultado.png" width="900"  alt="Resultado">

- Detalhe da resposta respondida pelo sistema.
<img src="https://github.com/daniel2dfla/Microservices-with-SpringBoot/blob/main/img/DetalheDoResultado.png" width="900"  alt="Detalhe do resultado">

- Persistência dos dados no banco de dados PostgreSQL.
<img src="https://github.com/daniel2dfla/Microservices-with-SpringBoot/blob/main/img/PersistenciaDB.png" width="900"  alt="Detalhe do resultado">

- Exchanges criadas no RabbitMQ.
<img src="https://github.com/daniel2dfla/Microservices-with-SpringBoot/blob/main/img/Exchanges.png" width="500"  alt="Detalhe do resultado">

- Queues criadas como solicitado.
<img src="https://github.com/daniel2dfla/Microservices-with-SpringBoot/blob/main/img/Queues.png" width="700"  alt="Detalhe do resultado">

- SMS recebido.
<img src="https://github.com/daniel2dfla/Microservices-with-SpringBoot/blob/main/img/SMS.jpg" width="200"  alt="Detalhe do resultado">

- Valores gastos com serviços SMS, pela AWS (em ambiente de estudos ainda sim tem gastos, é importante se atentar com isso e gerar uma prévia de gastos para serviços mais robustos).
<img src="https://github.com/daniel2dfla/Microservices-with-SpringBoot/blob/main/img/TaxaAWS.png" width="600"  alt="Detalhe do resultado">

### Tecnologias utilizadas
- Java / SpringBoot
- RabbitMQ
- SNS Amazon Simple Notification Service
- DBeaver / PostgreSQL
- Docker

### Pré requisitos para rodar o projeto
- Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
  [Java](https://www.java.com/pt-BR/), [docker desktop](https://docs.docker.com/desktop/install/windows-install/), [DBeaver](https://dbeaver.io/download/), [Postgres](https://www.postgresql.org/)
- Importante destacar que para rodar o microsserviço de notificação é necessário ter as credenciais da AWS salvas no PATH(variaveis de ambientes) do seu computador.
- Dê um clone no projeto e roda o maven.
- Com o docker desktop aberto, use o comando " docker-compose up --build -d "
- Agora é só rodar cada projeto, lembrando que o RabbitMQ esta rodando na porta 15672 e a imagem do front na porta 80.

### Contribuição
- Esse projeto foi feito com o curso "Microsserviços com Spring e RabbitMQ + AWS" da udemy , projeto meramente para fins estudantis.

### 📩 Contato
Para mais informaçãoes me deixo a disposição pelo email: daniel_2dfla@hotmail.com

