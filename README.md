# Workshop Spring Boot com MongoDB

Este é um projeto de exemplo feito no Workshop Spring Boot com MongoDB. Ele apresenta uma aplicação simples que utiliza o Spring Boot e o MongoDB para criar e manipular dados de usuários.

## Tecnologias Utilizadas

- Java 11+
- Spring Boot 2.4.5
- MongoDB 4.4.5
- Maven 3.6.3

## Pré-requisitos

Antes de executar o projeto, é necessário ter as seguintes ferramentas instaladas na sua máquina:

- [Java JDK 11+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Spring Tool Suite (STS)](https://spring.io/tools) ou outra IDE compatível com projetos Maven/Spring Boot.

## Uso

A aplicação é uma API REST que disponibiliza os seguintes endpoints:

### GET /users

Retorna todos os usuários cadastrados no banco de dados.

#### Parâmetros

Nenhum.

#### Exemplo de resposta

```json
[
  {
    "id": "6098a67b1c562c070ad64f0a",
    "name": "João",
    "email": "joao@mail.com",
    "phone": "123456789"
  },
  {
    "id": "6098a6a91c562c070ad64f0b",
    "name": "Maria",
    "email": "maria@mail.com",
    "phone": "987654321"
  }
]
```

### GET /users/{id}

Retorna um usuário com o ID correspondente.

#### Parâmetros

| Parâmetro | Descrição   |
| --------- | ----------- |
| id        | ID do usuário |

#### Exemplo de resposta

```json
{
  "id": "6098a67b1c562c070ad64f0a",
  "name": "João",
  "email": "joao@mail.com",
  "phone": "123456789"
}
```

### POST /users

Adiciona um novo usuário ao banco de dados.

#### Parâmetros

| Parâmetro | Descrição                   |
| --------- | ---------------------------|
| name      | Nome do usuário (obrigatório)|
| email     | E-mail do usuário (obrigatório)|
| phone     | Telefone do usuário (opcional)|

#### Exemplo de requisição

```json
{
  "name": "Ana",
  "email": "ana@mail.com",
  "phone": "456789123"
}
```

#### Exemplo de resposta

```json
{
  "id": "6098a6f11c562c070ad64f0c",
  "name": "Ana",
  "email": "ana@mail.com",
  "phone": "456789123"
}
```

## Executando o Projeto

1. Clone o repositório do projeto:

   ```
   git clone https://github.com/ccaioadriano/workshop-spring-boot-mongodb.git
   ```
   
2. Abra o Spring Tool Suite (STS) e importe o projeto:
   
   - Clique em **File > Import**
   - Selecione **Maven > Existing Maven Projects**
   - Na janela que aparece, selecione o diretório do projeto clonado e clique em **
   - 3. Aguarde até que as dependências do projeto sejam baixadas pelo Maven.

4. Abra o arquivo `src/main/resources/application.properties` e verifique se as configurações do banco de dados estão corretas. Por padrão, o projeto está configurado para se conectar a um banco de dados MongoDB local.

5. Execute o projeto:

   - Clique com o botão direito no projeto no **Project Explorer**
   - Selecione **Run As > Spring Boot App**
   
6. Aguarde até que o projeto seja iniciado. Isso pode levar alguns segundos, dependendo do desempenho do seu computador.

7. Acesse a API em http://localhost:8080/users e teste os endpoints utilizando uma ferramenta de requisições HTTP, como o [Postman](https://www.postman.com/) ou o [Insomnia](https://insomnia.rest/).

## Contribuindo
- Faça o fork do projeto (https://github.com/ccaioadriano/workshop-spring-boot-mongodb/fork)
- Crie uma branch para sua modificação (git checkout -b feature/sua-feature)
- Faça o commit (git commit -am 'Add some feature')
- Push (git push origin feature/sua-feature)
- Crie um novo Pull Request.
