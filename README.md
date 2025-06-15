ECOMMERCE

Este projeto é uma aplicação Java Spring Boot que simula a criação e gerenciamento de pedidos em um sistema de e-commerce, aplicando os padrões de projeto **Strategy**, **State** e **Facade** para promover um código limpo, desacoplado e extensível.

Tecnologias utilizadas:

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- PgAdmin
- Maven
- Visual Studio Code
- Git

Configurando o banco de dados:

1. Crie o banco de dados no PgAdmin
 - Clique com o botão direito na versão do PostgreSQL instalada
 - Clique em CREATE DATABASE
 - Nomeie-o como "ecommerce" ou outro nome de interesse

2. Configure o arquivo "application.properties"
 - Edite as propriedades de banco no arquivo, baseado em como está nomeado no banco:

 spring.datasource.url=jdbc:postgresql://localhost:5432/{nome-do-banco-de-dados}
 spring.datasource.username={nome-do-usuario}
 spring.datasource.password={senha}

Como executar o projeto:

1. Clone o repositório:
 - Execute o git bash
 - Digite git clone https://github.com/kaiquedsm/ecommerce-java-spring.git
2. Acesse a pasta do projeto:
 - cd ecommerce
3. Abra o projeto no editor:
 - code .
4. Baixe a extensão Extension Pack for Java da Microsoft
 - Clique no ícone de extensões do Visual Studio Code
 - Pesquise pelo mesmo nome citado
 - Instale-o
4. Execute o projeto com Maven:
 - Digite mvn spring-boot:run no terminal
5. Acesse o projeto no navegador:
 - Digite http://localhost:8080/swagger-ui/index.html

Padrões de projetos utilizados:

- Strategy: A lógica de frete foi extraída para a interface Frete, permitindo que cada tipo de envio tenha sua própria classe 
com a regra de cálculo. Seguindo o princípio Open/Closed, novos métodos de envio podem ser adicionados sem alterar a classe 
Pedido, apenas criando novas implementações de Frete.

- State: Cada estado do pedido foi encapsulado em uma classe específica, permitindo que o próprio estado controle seu  
comportamento. Com isso, a classe Pedido deixa de ter if, else ou switch para validar ações como pagar(), cancelar() e enviar(). 
Isso evitaalterações frequentes em Pedido sempre que novos estados forem adicionados, tornando o sistema mais organizado, 
extensível e de fácil manutenção.

- Facade: O padrão Facade foi utilizado para centralizar e simplificar o acesso à lógica de negócio relacionada aos pedidos. Ele permite que a camada de controle interaja com o sistema por meio de uma interface única e direta, sem precisar conhecer os detalhes de implementação. Isso promove baixo acoplamento, organização do código e facilidade de manutenção