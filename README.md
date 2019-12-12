# Document

TODO 

#### Inicializa projeto

    $ docker-compose up -d

#### Executar comando para inicializar replicaset mongoDB

     $ docker-compose exec mongo0 mongo --eval "rs.initiate({_id : 'rs0','members' : [{_id : 0, host : 'mongo0:27017'},{_id : 1, host : 'mongo1:27018'},{_id : 2, host : 'mongo2:27019'}]})"

###### Health check:

    $ curl -X GET \
        http://localhost:8080/actuator/health \
        -H 'Accept: */*' \
        -H 'Accept-Encoding: gzip, deflate' \
        -H 'Cache-Control: no-cache' \
        -H 'Connection: keep-alive' \
        -H 'Host: localhost:8080' \
        -H 'cache-control: no-cache'

###### Upload de documento:

    $ curl -X POST \
        http://localhost:8080/api/v1/documents \
        -H 'Accept: */*' \
        -H 'Accept-Encoding: gzip, deflate' \
        -H 'Cache-Control: no-cache' \
        -H 'Connection: keep-alive' \
        -H 'Content-Length: 65914' \
        -H 'Content-Type: application/x-www-form-urlencoded' \
        -H 'Host: localhost:8080' \
        -H 'cache-control: no-cache' \
        -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
        -F file=@/home/msantocardoso/Downloads/simulador_abandonado.jpg \
        -F externalId=9d861995-bff8-4485-8751-275fc30611cb \
        -F productName=AUTO_FIN

###### Lista todos os documentos:

    $ curl -X GET \
        http://localhost:8080/api/v1/documents \
        -H 'Accept: */*' \
        -H 'Accept-Encoding: gzip, deflate' \
        -H 'Cache-Control: no-cache' \
        -H 'Connection: keep-alive' \
        -H 'Host: localhost:8080' \
        -H 'cache-control: no-cache'

###### Lista documento por id:

    $ curl -X GET \
        http://localhost:8080/api/v1/documents/:id \
        -H 'Accept: */*' \
        -H 'Accept-Encoding: gzip, deflate' \
        -H 'Cache-Control: no-cache' \
        -H 'Connection: keep-alive' \
        -H 'Content-Type: application/json' \
        -H 'Host: localhost:8080' \
        -H 'cache-control: no-cache'
