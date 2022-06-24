# MTStore IaC

MTStore platform Infrastructure as code scripts.

## 📋 Pre-reqs

* [Docker](https://docs.docker.com/desktop/windows/install/)

* Download [Jenkins Mount](https://github.com/rodsordi/MTStore.JenkinsMount) in `/D/mt-volumes/jenkins`

* Download [Openjdk-17](https://jdk.java.net/archive/) linux version in `/D/mt-volumes/openjdks/jdk-17.0.2`

* Download [Maven](https://maven.apache.org/download.cgi) linux version in `/D/mt-volumes/mavens/apache-maven-3.8.5`

## ⚙️ Environment

* Environment variables

```
set MTS_IAC_HOME=C:\git\MTStore.IaC
set MTS_IAC_VOLUME_PATH=D:\mt-volumes\jenkins
```

## 🚢 Docker Desktop

* General -> Uncheck: Use the WSL 2 based engine
* Resources -> FILE SHARING -> + -> D:\mt-volumes

## 🎼 Kubernetes

* Terminal

```
kubectl apply -f C:/git/MTStore.IaC/mt-jenkins-deployment.yml
kubectl apply -f C:/git/MTStore.IaC/mt-jenkins-nodeport.yml

kubectl apply -f ${Env:MTS_IAC_HOME}/mts-auth-deployment.yml
kubectl apply -f ${Env:MTS_IAC_HOME}/mts-auth-nodeport.yml
kubectl apply -f ${Env:MTS_IAC_HOME}/mts-auth-clusterip.yml

kubectl apply -f ${Env:MTS_IAC_HOME}/mts-store-deployment.yml

kubectl apply -f ${Env:MTS_IAC_HOME}/mts-orders-pod.yml

kubectl apply -f ${Env:MTS_IAC_HOME}/mts-products-pod.yml
```

## 🍸 Jenkins

* [Home](http://localhost:30000)

* Credentials

```
initialAdminPassword: c49f7484a447498fab8a275f1e63e76c
user: admin
pass: admin123
email: rodsordi@gmail.com
```