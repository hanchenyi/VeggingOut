# LeetCodeTutorial

- kafka tutorial
```
Start Zookeeper:
zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties
Start Kafka server:
kafka-server-start /usr/local/etc/kafka/server.properties 
Create Kafka Topic:
kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
Initialize Producer console:
kafka-console-producer --broker-list localhost:9092 --topic test
Initialize Consumer console:
kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning
```
