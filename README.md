# MTStore IaC

Inrastructure as Code for MTStore platform.

```
cd C:\kafka_2.13-3.1.0
bin/windows/zookeeper-server-start.bat config/zookeeper.properties
bin/windows/kafka-server-start.bat config/server.properties
```

```
docker build -t my-ubuntu .
kubectl apply -f my-ubuntu.yml
kubectl exec -it my-ubuntu-57b8894f5-t2txw -- bash
```