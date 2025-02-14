## Feirinha API 🍎🛒📦

#### Descrição

🚀📌✨ A Feirinha API é um sistema de gerenciamento de itens para um pequeno mercado, permitindo o cadastro, consulta, atualização e remoção de produtos. O projeto foi desenvolvido utilizando Spring Boot, Java 17, e PostgreSQL como banco de dados.

#### Tecnologias Utilizadas 🖥️⚙️📡

- Java 17
- Spring Boot 3.4.2
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

#### Instalação e Execução 🏗️📂💻
Requisitos 🔧⚡📜
- Java 17+
- Maven
- PostgreSQL

#### Configuração do Banco de Dados 🗄️🔑📑

Certifique-se de ter um banco de dados PostgreSQL rodando e crie um banco chamado feirinha_db. Configure as credenciais no arquivo application.properties:

- spring.datasource.url=jdbc:postgresql://localhost:5432/feirinha_db
- spring.datasource.username=seu_usuario
- spring.datasource.password=sua_senha
- spring.jpa.hibernate.ddl-auto=update

#### Endpoints Disponíveis 🌍🔗📡

A API expõe os seguintes endpoints:

#### Criar um novo item 🆕➕📦
- POST /items
{
  "name": "Banana",
  "quantity": 10
}

#### Listar todos os itens 📃🔍📦
- GET /items

#### Buscar um item pelo ID 🔢🔍📦
- GET /items/{id}

#### Atualizar um item ✏️🔄📦
- PUT /items/{id}
{
  "name": "Maçã",
  "quantity": 5
}

#### Deletar um item ❌🗑️📦
- DELETE /items/{id}