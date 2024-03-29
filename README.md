# MTStore IaC

Inrastructure as Code for MTStore platform.

### 📋 Pre-reqs

[Jenkins]()
[Telegraf](https://portal.influxdata.com/downloads/)

### Environment

TELEGRAF_HOME=C:\telegraf-1.23.0
TELEGRAF_CONFIG_PATH=C:\telegraf-1.23.0\telegraf.conf

### 🔧 Instalation

* Docker

```
cd C:\Users\Rodrigo\.docker
edit daemon.json
add "hosts": ["tcp://0.0.0.0:2375"]
```

* Jenkins
Run mts-iac-dev job

* Telegraf

```
[[outputs.influxdb]]
urls = ["http://127.0.0.1:30202"]
```

```
[[inputs.docker]]
endpoint = "tcp://127.0.0.1:2375"
container_name_include = []
container_name_exclude = []
timeout = "5s"
```

```
[[inputs.logparser]]
files = ["/D/mt-volumes/app-logs/mts-auth.log"]
from_beginning = true
[inputs.logparser.grok]
patterns = ["%{COMBINED_LOG_FORMAT}"]
measurement = "app_log"
```

```
cd ${Env:TELEGRAF_HOME}
.\telegraf.exe
```

### Testing

* Postman

https://www.postman.com/rodsordi/workspace/mtstore


### TMP

```
cd C:\kafka_2.13-3.1.0

Remove-Item ./data/zookeeper/* -Recurse -Force
Remove-Item ./data/kafka01/* -Recurse -Force
Remove-Item ./data/kafka02/* -Recurse -Force
Remove-Item ./data/kafka03/* -Recurse -Force

./bin/windows/zookeeper-server-start.bat ./config/zookeeper.properties

./bin/windows/kafka-server-start.bat ./config01/server.properties
./bin/windows/kafka-server-start.bat ./config02/server.properties
./bin/windows/kafka-server-start.bat ./config03/server.properties

./bin/windows/kafka-topics.bat --describe --bootstrap-server=localhost:9291
./bin/windows/kafka-topics.bat --describe --bootstrap-server=localhost:9292
./bin/windows/kafka-topics.bat --describe --bootstrap-server=localhost:9293
```

```
kubectl get pods
kubectl exec -it mts-kafka-... -- bash
cd opt/bitnami/kafka/
./bin/kafka-topics.sh --bootstrap-server=localhost:30201 --list
./bin/kafka-topics.sh --describe --bootstrap-server=localhost:30201
```

```
cd C:\kafka_2.13-3.1.0
bin/windows/zookeeper-server-start.bat config/zookeeper.properties
bin/windows/kafka-server-start.bat config/server.properties
```

```
docker build -t my-ubuntu .
kubectl apply -f my-ubuntu.yml
kubectl exec -it my-ubuntu-0 -- bash
```


