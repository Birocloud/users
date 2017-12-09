## Simplest way of running

#### Run the database in docker

docker run -d --name postgres-users -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=users -p 5433:5432 postgres:latest

#### Set config.yaml database url to localhost:5433

#### Set UsersBean base_url to localhost:5433

#### Set config.yaml url to localhost:8081

#### Build the project in maven

#### Run api/target .jar

## Simple way of running in docker

#### Run the database in docker

docker run -d --name postgres-users -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=users -p 5433:5432 postgres:latest

#### Set config.yaml database url to docker.for.mac.localhost:5433

#### Set config.yaml url to localhost:8080

#### Set UsersBean base_url to docker.for.mac.localhost:5433

#### Build the project in maven

#### Build the docker image
docker build -t users-api .

#### Run the container

docker run -d --name usersapi -p 8081:8080 users-api

enjoy using.