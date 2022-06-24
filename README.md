# MTStore Commons

Commons libs for MTStore platform.

## 🚀 Starting

Instruction to download a local environmet to devlopment and testing.

### 📋 Pre-reqs

* [Open JDK 17 +](https://jdk.java.net/archive/)

```
set JAVA_HOME=C:\jdk-17.0.1
set PATH=%JAVA_HOME%\bin; %PATH%
```

* [Apache Maven 3.8.4 +](https://maven.apache.org/download.cgi#)

```
set M2_HOME=C:\apache-maven-3.8.5
set M2=%M2_HOME%\bin
set PATH=%M2%; %PATH%
```

* [Intellij 2021.3.2 (Comunity Edition) +](https://www.jetbrains.com/pt-br/idea/download)
* [Kafka](https://kafka.apache.org/quickstart) 

```
Windows

Edite: %KAFKA_HOME%\config\server.properties
zookeeper.connection.timeout.ms=60000
#broker.id=0
log.dirs=/kafka_2.13-3.1.0/data/kafka

Edite: %KAFKA_HOME%\config\zookeeper.properties
dataDir=/kafka_2.13-3.1.0/data/zookeeper
```

```
set KAFKA_HOME=C:\kafka_2.13-3.1.0
set PATH = %KAFKA_HOME%; %PATH%
%KAFKA_HOME%\bin\windows\zookeeper-server-start.bat %KAFKA_HOME%\config\zookeeper.properties
%KAFKA_HOME%\bin\windows\kafka-server-start.bat %KAFKA_HOME%\config\server.properties
```

* [Git](https://gitforwindows.org/)
* [Postman](https://www.postman.com/downloads/)

### 🔧 Instalação

Importe os end-points no Postman:

## ⚙️ Executando os testes

Maven

```
mvn clean install
```

## 📦 Desenvolvimento

Executando a amplicação no ambiente de desenvolvimento:

```
java -jar .\Autenticacao.SpringApp\target\Autenticacao.SpringApp.jar
```

## 📐 Referencia de Arquitetura

[Arquitetura Hexagonal](https://reflectoring.io/spring-hexagonal/)

![Arquitetura Hexagonal](https://reflectoring.io/images/posts/spring-hexagonal/hexagonal-architecture_hu6764515d7030d45af6f7f498c79e292b_50897_956x0_resize_box_3.png)

## 📃 Notas do Teste

* Há comentários no `//TODO: Apresentar` por todo o projeto para mostrar os padrões utilizados 
* Ao criar um novo cartão foi ocultado a senha, por questão de segurança e reaproveitamento do objeto de retorno
* No cenário de criação de um novo Cartão, quando o Cartão já existe, foi decidido retornar status 422 com a mensagem de erro:

```
Cartão com número xxx já cadastrado
```

* Ao retornar erro é retornado um objeto com a propriedade erro contendo a mensagem de erro.

## 📌 Versão

Usado [SemVer](http://semver.org/) para controle de versão. Para as versões disponíveis, observe as [tags neste repositório](https://https://github.com/rodsordi/MiniAutorizador/tags).

## ✒️ Autores

* **Rodrigo de Sordi** - *Dev* - [rodsordi](https://github.com/rodsordi)

---