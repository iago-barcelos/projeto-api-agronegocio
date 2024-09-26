![Java Spring Boot Banner](images/banner.jfif)

# AgroAPI

**AgroAPI** é uma API desenvolvida para o controle de plantações em fazendas, permitindo o gerenciamento de culturas, campos, safras e outras informações relevantes para o agronegócio. O projeto foi construído utilizando o **Spring Boot** e segue uma arquitetura em camadas para garantir a separação de responsabilidades e facilitar a manutenção.

## Funcionalidades

- Gerenciamento de plantações e safras.
- Controle de informações de campos e culturas.
- Autenticação e autorização via **JWT tokens** com **Spring Security**.
- Operações com banco de dados utilizando **Spring JPA** e **Hibernate**.
- Testes automatizados com foco em **testes unitários** e **testes de integração**.
- Utilização do padrão **DTO** para lidar com objetos de requisição e resposta.

## Tecnologias Utilizadas

- **Java** com **Spring Boot** para a criação da API.
- **Spring JPA** para mapeamento objeto-relacional (ORM).
- **Hibernate** para o gerenciamento automático das tabelas no banco de dados.
- **Spring Security** para autenticação e autorização com JWT.
- **MySQL** como banco de dados relacional.
- **Docker** para facilitar a execução do ambiente de desenvolvimento.
- **JUnit** para testes unitários e de integração.

## Arquitetura

O projeto segue uma arquitetura em camadas, dividida em:

- **Controller**: Recebe as requisições HTTP e direciona para o serviço apropriado.
- **Service**: Contém a lógica de negócios.
- **Repository**: Interface com o banco de dados utilizando Spring Data JPA.
- **Model**: Representação das entidades do sistema.
- **DTO (Data Transfer Object)**: Lida com objetos de requisição e resposta.
- **Security**: Implementação de autenticação e autorização com JWT.

## Como Executar o Projeto

1. **Clone o repositório**:

```bash
git clone https://github.com/seu-usuario/agroapi.git
```

2. **Na raiz do projeto rode o docker compose para iniciar o docker do MySQL**

```bash
docker compose up -d
```

3. **Inicie a aplicação para que o Hibernate crie o banco de dados e as tabelas**

