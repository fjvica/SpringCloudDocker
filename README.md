# SpringCloudDocker

## Comandos para Docker

> Construye una imagen a partir de un archivo Dockerfile
- **docker build .**

> Lista las imagenes que hay disponibles
- **docker images**

> Accede al log del contenedor
- **docker inspect**

> Lista los contenedores
- **docker ps**

> Arranca un contenedor
- **docker start {nombre de la imagen}**

> Para un contenedor
- **docker stop {nombre de la imagen}**

> Elimina un contenedor
- **docker rm {nombre del contenedor}**

> Crea una red interna para los contenedores
- **docker network create {nombre de la red}**

> Arranca un contenedor
- **docker run -p {puerto pc}:{puerto docker} -d --rm --name {nombre del contenedor} --network {nombre de la red} {nombre de la imagen}**

> Arranca un contenedor (de bbdd) con volumenes
- **docker run -p {puerto pc}:{puerto docker} -d --rm --name {nombre del contenedor} --network {nombre de la red} -e {Variable como MYSQL_ROOT_PASSWORD}={valor} -v {nombre del volumen}:{ruta de guardado} {nombre de la imagen}**

> levantar docker-compose
- **docker-compose up**

> detener y eliminar docker-compose
- **docker-compose down**

> detener y eliminar los volumenes y contenedores docker-compose
- **docker-compose down -v**

> eliminar todas las imagenes forzando su detencion
- **docker image prune -a**