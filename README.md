# Tivia
#### Este projeto é um projeto de teste

Crie uma aplicação utilizando Java e Spring Boot que forneça uma API REST para manter o cadastro
de beneficiários de um plano de saúde.
Devem ser expostos endpoints para executar as seguintes operações:
- Cadastrar um beneficiário junto com seus documentos;
- Listar todos os beneficiários cadastrados;
- Listar todos os documentos de um beneficiário a partir de seu id;
- Atualizar os dados cadastrais de um beneficiário;
- Remover um beneficiário.

### Estrutura do projeto
 - Java 17
 - Spring boot
 - Jwt
 - H2
 - Maven
 - Swagger

### Fazendo build

O projeto foi desenvolvido com intelij, recomendo uso do mesmo, para excecutar aplicação, mas é livre a 
escolha de outra IDE.
A base de dados é criada em memoria, com uso do H2, sendo assim, toda vez que aplicação for iniciada o banco 
é reconstruido. 
Há um setup automático que irá criar um usuário para autenticação e também beneficiários e seus documentos.

### Collection postman
Esta disponivel junto ao projeto a collection postman.

### Informações utéis
- Autenticação
  - Nome de usuário: admin
  - Senha: admin
- Banco de dados
  - Nome de usuário: sa
  - Senha: sa
  - http://localhost:8080/h2
- Swagger
  - http://localhost:8080/swagger-ui/index.html

![img.png](img.png)



