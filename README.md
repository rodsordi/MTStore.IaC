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
kubectl get pods
kubectl exec -it mts-kafka-... -- bash
cd opt/bitnami/kafka/
./bin/kafka-topics.sh --bootstrap-server=localhost:30200 --list
```

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


