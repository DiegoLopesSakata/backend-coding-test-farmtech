# Product API - Spring Boot

Esta aplicação é um microserviço desenvolvido com **Spring Boot** para cadastro, edição e listagem de produtos, utilizando banco de dados em memória **H2** e documentação via **Swagger (SpringDoc OpenAPI)**.

## Estrutura do projeto

A aplicação Spring Boot está localizada na pasta: product/

É necessário acessar essa pasta para executar os comandos Maven, pois nela está localizado o arquivo `pom.xml`.

## Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- SpringDoc OpenAPI (Swagger)
- Maven

## Funcionalidades implementadas

A API disponibiliza operações para:

- Criar produtos
- Editar produtos
- Listar produtos
- Buscar produto por ID

### Regras de negócio

- O nome do produto é obrigatório
- O nome não pode conter apenas espaços em branco
- O nome deve possuir no mínimo 3 caracteres
- Não pode existir mais de um produto com o mesmo nome
- O campo Status é case-insensitive (ex: "active", "Active", "IN TESTING")
- Cada produto possui:
  - Nome
  - Status (`Active`, `Inactive`, `Discontinued`, `In Testing`)
  - Data de criação
  - Data de atualização

## Endpoints principais

### Criar produto
**POST** `/products`

Request body:
```json
{
  "name": "Premium corn seeds",
  "status": "active",
  "farmer": {
    "document": "12345678900",
    "farmName": "Fazenda Santa Luzia",
    "state": "GO"
  }
}
```

Response (201):
```json
{
  "id": 1,
  "name": "Premium corn seeds",
  "status": "ACTIVE",
  "farmer": {
    "document": "12345678900",
    "farmName": "Fazenda Santa Luzia",
    "state": "GO"
  },
  "createdAt": "2026-01-02T14:18:15.9533101",
  "updatedAt": "2026-01-02T14:18:15.9533101"
}
```
### Atualizar Produto
**PUT** `/products/{id}`

Request Body (exemplo mudando o nome do produto e status):

```json
{
  "name": "Premium corn seeds harvest 24/25",
  "status": "in testing",
  "farmer": {
    "document": "12345678900",
    "farmName": "Fazenda Santa Luzia",
    "state": "GO"
  }
}
```

Response (200):
```json
{
  "id": 1,
  "name": "Premium corn seeds harvest 24/25",
  "status": "IN_TESTING",
  "farmer": {
    "document": "12345678900",
    "farmName": "Fazenda Santa Luzia",
    "state": "GO"
  },
  "createdAt": "2026-01-02T14:16:27.595444",
  "updatedAt": "2026-01-02T14:21:45.974353"
}
```

### Listar produtos
**GET** `/products`
```json
[
  {
    "id": 1,
    "name": "Premium corn seeds harvest 24/25",
    "status": "IN_TESTING",
    "farmer": {
      "document": "12345678900",
      "farmName": "Fazenda Santa Luzia",
      "state": "GO"
    },
    "createdAt": "2026-01-02T14:16:27.595444",
    "updatedAt": "2026-01-02T14:21:45.974353"
  }
]
```

### Buscar produto por ID
**GET** `/products/{id}`

Response (200): mesmo formato que os exemplos de POST e PUT.

## Documentação da API (Swagger)
A documentação da API é gerada automaticamente utilizando SpringDoc OpenAPI e pode ser acessada após a aplicação estar em execução.

Além de documentar os endpoints, o Swagger também pode ser utilizado para testar a API diretamente pelo navegador.

URL da documentação:

http://localhost:8080/swagger-ui.html

ou

http://localhost:8080/swagger-ui/index.html

## Como executar o projeto localmente
1. **Pré-requisitos**
    - Java 17 ou superior

    - Maven instalado

2. **Acessar a pasta do projeto**
No terminal, navegue até a pasta onde está localizado o arquivo pom.xml:

```bash
cd product
```
3. **Gerar o build do projeto**
Execute o comando:

```bash
mvn clean install
```
4. **Executar a aplicação**
Após o build, execute:

```bash
mvn spring-boot:run
```
5. **Acessar a aplicação**
 A aplicação deve subir em `http://localhost:8080`. A interface do Swagger costuma ficar em:
   - `http://localhost:8080/swagger-ui.html`, ou
   - `http://localhost:8080/swagger-ui/index.html`

## Observações finais
- O banco de dados H2 é executado em memória, portanto os dados são reiniciados a cada execução da aplicação.

- Não há autenticação ou autorização implementadas.

- O projeto segue uma separação clara de camadas (controller, service, repository).

- As validações e mensagens de erro são tratadas para facilitar o consumo da API.