# Cadastro de Usuários - Spring Boot

API REST para cadastro de usuários desenvolvida com Spring Boot.

## Tecnologias
- Java 21
- Spring Data JPA
- Bean Validation
- Lombok
- Maven
- H2 / MySQL 
- Postman

## Funcionalidades
- CRUD completo de usuários
- Validação de dados com mensagens detalhadas
- DTOs para request e response
- Service Layer para regras de negócio
- Tratamento global de exceções (`@ControllerAdvice`)
- Paginação e ordenação com Spring Data (`Pageable`)
- Retornos HTTP padronizados (`ResponseEntity`)

## Endpoints
- POST /usuarios
- GET /usuarios
- GET /usuarios/{id}
- DELETE /usuarios/{id}

## Testes
Os endpoints foram testados utilizando o **Postman**, incluindo:
- Criação de recursos (201 Created)
- Validação de dados (400 Bad Request)
- Recurso não encontrado (404 Not Found)

## Estrutura do projeto
- controller
- service
- repository
- dto
- exception
- model


## Autor
Gustavo Barbosa Inagaki 