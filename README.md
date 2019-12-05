# Document

TODO 

## Começo rápido

* URL Local: http://localhost:8080
* [Documentação da API (local via Swagger)](http://localhost:8080/swagger-ui.html)

Alguns *targets* interessantes do Gradle (sistema de build):

* `./gradlew dependencies`: Baixa as dependências
* `./gradlew build`: Faz a build do projeto inteiro (baixa as dependências também)

### Usando Docker

Supondo que você tenha instalado:

* [Docker][]
* [Docker Compose][]

[Docker]: https://docs.docker.com/install/ "About Docker CE"
[Docker Compose]: https://docs.docker.com/compose/install/#install-compose "Install Docker Compose"

Executar o ambiente:

    $ docker-compose up -d

Para verificar se a aplicação subiu com sucesso, basta chamar o health check:

[http://localhost:8080/health](http://localhost:8080/health)

## Inicializa cluster mongoDB

     $ docker-compose exec mongo0 mongo --eval "rs.initiate({_id : 'rs0','members' : [{_id : 0, host : 'mongo0:27017'},{_id : 1, host : 'mongo1:27018'},{_id : 2, host : 'mongo2:27019'}]})"
