# Setup instructions

- Установить docker
- Выполнить `docker-compose up -d`
- Создать топик внутри кафки:
  - Войти внутрь контейнера: `docker exec -ti moex-api-kafka-1 bash`
  - Внутри контейнера выполнить `/opt/bitnami/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --replication-factor 1 --partitions 4 --topic share-prices`