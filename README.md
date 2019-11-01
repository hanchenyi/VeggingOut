### LeetCodeTutorial
- There are a few examples under path, /src/main/java/com/example/demo/tutorial.
### kafka tutorial
- Start Zookeeper:
zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties
- Start Kafka server:
kafka-server-start /usr/local/etc/kafka/server.properties 
- Create Kafka Topic:
kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic greetings
- Initialize Producer console:
kafka-console-producer --broker-list localhost:9092 --topic greetings
- Initialize Consumer console:
kafka-console-consumer --bootstrap-server localhost:9092 --topic greetings --from-beginning


### Kafka and Zookeeper MultiNode Cluster Setup Reference
- https://medium.com/@kiranps11/kafka-and-zookeeper-multinode-cluster-setup-3511aef4a505