# SANTANDER DEV WEEK - BACK-END
#### Tecnologia: Java - Spring [Boot,Data] - Maven - MySQL - OpenAPI - Lombok

![Image](https://hermes.digitalinnovation.one/tracks/cover/9618271f-9dd2-4f70-b728-1f627b2a92ab.png "Image Santander Dev Week")

## Configuração

* Ao clonar o projeto configure corretamente o arquivo **application.yml**, com o Driver do banco de sua preferência e usúario e senha corretos.
* Caso encontre erro no start da aplicação, por favor crie o schema/banco dt_santander antes.


## Construção do Projeto

### Modelagem
- **Stock:** classe abstrata que define o modelo de entidade Stock (Investimentos) seus atributos e métodos.
    - **id:** identificador do Stock.
    - **name:** nome ou abreviação do Stock.
    - **price:** preço atual do Stock.
    - **variation:** variação do Stock.
    - **date:**  data do Stock.

### Repository
- **StockRepository:** implementação dos métodos específicos de acesso e manipulação de entidades do tipo Stock.

### Service
- **StockService:** Serviços relativos ao ContaRepository utilizados pela aplicação (save, update,deleteById, findById, findAll)

### Utils
- **MessageUtils:** Afim de manter uma padronização, inserimos aqui a mensagem de retorno de nossas Exceções.


## Dependências Maven - pom.xml

  ```xml
  <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    
        <!-- MySql Driver -> Connector -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
    
        <!-- Spring Data -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
    
        <!-- Bean Validation -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
    
        <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.20</version>
        </dependency>
    
        <!-- https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-ui -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-ui</artifactId>
            <version>1.5.9</version>
        </dependency>

	</dependencies>
  ```

### Application.yml
  ```yml
  server:
    port: 8080
    servlet:
        context-path: /bootcamp

  spring:
    datasource:
        driver-class-name: com.mysql.jdbc.Driver
        url: jdbc:mysql://localhost:3306/dt_santander
        username: root
        password: root123
    jpa:
        show-sql: true
        generate-ddl: true
        hibernate:
          ddl-auto: update

  project:
      version: @project.version@
      name: @project.name@
  ```

## Proprietário
* Guilherme Ribeiro - Guirilima


----
----

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)