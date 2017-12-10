Now available on dockerhub!

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

## Running ETCD

- Create a new instance 

docker run -d -p 2379:2379 \
     --name etcd \
     --volume=/tmp/etcd-data:/etcd-data \
     quay.io/coreos/etcd:latest \
     /usr/local/bin/etcd \
     --name my-etcd-1 \
     --data-dir /etcd-data \
     --listen-client-urls http://0.0.0.0:2379 \
     --advertise-client-urls http://0.0.0.0:2379 \
     --listen-peer-urls http://0.0.0.0:2380 \
     --initial-advertise-peer-urls http://0.0.0.0:2380 \
     --initial-cluster my-etcd-1=http://0.0.0.0:2380 \
     --initial-cluster-token my-etcd-token \
     --initial-cluster-state new \
     --auto-compaction-retention 1 \
     -cors="*"
     
- perform operations on this instance

docker exec etcd etcdctl --endpoints //0.0.0.0:2379 set /environments/dev/services/users-service/1.0.0/config/rest-properties/external-dependencies/accountoptions-service/enabled true

docker exec etcd etcdctl --endpoints //0.0.0.0:2379 get /environments/dev/services/users-service/1.0.0/config/rest-properties/external-dependencies/accountoptions-service/enabled