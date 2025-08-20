# Backend Notification Challenge

This challenge I asked to Gemini, so you can ask for challenges here:
[Link](https://gemini.google.com/)
![Image](https://img.freepik.com/vetores-gratis/sino-de-notificacao-azul-com-uma-notificacao_78370-6899.jpg?semt=ais_hybrid&w=740)

---

## 📌 Sobre o Projeto

Este repositório implementa uma API REST para **gerenciamento de notificações**.  
O sistema permite criar, consultar e excluir notificações que podem ser enviadas por diferentes canais (ex: e-mail, SMS, push).  

Foi desenvolvido como parte de um **desafio técnico de backend**.

---

## ⚙️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot** (Web, Validation, Data JPA)
- **H2 Database** (banco em memória)
- **Maven**

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos
- [Java 17+](https://jdk.java.net/17/)
- [Maven](https://maven.apache.org/)

### Passos
1. Clone o repositório:
   git clone https://github.com/MarioCcomp/backend-challenge-gemini.git

2. Entre no diretório:
   cd backend-challenge-gemini

3. Rode a aplicação:
   mvn spring-boot:run

4. A API estará disponível em:
   http://localhost:8080/api/v1

---

## 📡 Endpoints da API

### ➕ Criar uma notificação
POST /api/v1/notifications

Body (JSON):
{
  "channel": "EMAIL",
  "scheduledTo": "2025-08-20T10:00:00",
  "message": "Bem-vindo ao sistema!",
  "sendTo": "user@email.com"
}

Resposta:
201 Created

---

### 🔍 Buscar notificação por ID
GET /api/v1/notifications/{id}

Exemplo de Resposta:
{
  "id": 1,
  "channel": "EMAIL",
  "scheduledTo": "2025-08-20T10:00:00",
  "message": "Bem-vindo ao sistema!",
  "sendTo": "user@email.com"
}

---

### ❌ Deletar notificação
DELETE /api/v1/notifications/{id}

Resposta:
200 OK

---

## 🧪 Testes

Para rodar os testes automatizados:
mvn test

---

## 📌 Melhorias Futuras
- Implementar atualização de notificações (PUT/PATCH)
- Adicionar autenticação JWT
- Criar fila de envio de notificações (ex: RabbitMQ, Kafka)
- Integração real com serviços de e-mail/SMS

---

## 📜 Licença
Este projeto foi desenvolvido apenas para fins de estudo e avaliação técnica.
