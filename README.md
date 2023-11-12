# Agenda de Contatos

## Descrição
Este projeto implementa uma agenda telefônica simples em Java, utilizando um banco de dados MySQL para armazenar os contatos. Ele inclui classes para representar contatos (`Contato`), serviços de interação com o banco de dados (`AgendaBanco`), uma classe para a lógica de negócios (`Agenda`), e uma classe principal para demonstrar o uso (`Main`).

## Tecnologias Utilizadas
- **Java**: Linguagem de programação principal.
- **JUnit**: Framework de testes.
- **MySQL Connector**: Conector JDBC para interagir com o banco de dados MySQL.

## Estrutura do Projeto

### Módulo `model`
Contém a classe `Contato`, que representa as informações de um contato telefônico.

### Módulo `database`
Contém a classe `AgendaBanco`, responsável por interagir com o banco de dados MySQL para operações relacionadas a contatos.

### Módulo `service`
Contém a classe `Agenda`, que implementa a lógica de negócios da agenda telefônica, incluindo validações e operações.

### Módulo `Main`
Contém a classe principal `Main`, que demonstra o uso das funcionalidades da agenda telefônica.

## Configuração do Banco de Dados
- O banco de dados MySQL é utilizado para armazenar os contatos.
- As configurações de conexão, como URL do banco de dados, usuário e senha, estão definidas no arquivo `dados.properties` no diretório `/src/main/resources/properties/`.

### Arquivo `dados.properties`
```properties
prop.server.host=jdbc:mysql://127.0.0.1:3306/agenda
prop.server.user=root
prop.server.password=Brunna@2023

## Como Executar o Projeto

1. Clone o repositório.
2. Configure o banco de dados MySQL e atualize as configurações no arquivo `dados.properties`.
3. Abra o terminal na pasta do projeto.
4. Execute o comando `./gradlew run` para compilar e executar a aplicação.

## Funcionalidades da Agenda Telefônica

1. **Adicionar Contato**: Permite adicionar um novo contato à agenda.

2. **Remover Contato**: Permite remover um contato da agenda.

3. **Listar Contatos**: Exibe a lista completa de contatos armazenados na agenda.

4. **Buscar Contato por Nome**: Retorna uma lista de contatos correspondentes a um nome fornecido.

5. **Buscar Contato por ID**: Retorna uma lista de contatos correspondentes a um ID fornecido.

6. **Listar em Ordem Alfabética**: Exibe a lista de contatos ordenada em ordem alfabética.

## Instruções de Uso
- Execute a classe `Main` para testar as funcionalidades da agenda.
- Siga as instruções no console para interagir com a agenda.

## Observações
- Este é um projeto simples para fins educacionais, e não representa uma aplicação completa de gerenciamento de contatos.
- As informações sobre os contatos são mantidas em um banco de dados MySQL.
- As validações de entrada são implementadas na classe `Agenda` para garantir dados válidos.

