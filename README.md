# saga-camel-quarkus-distr
Distributing your orchestrated services (in practice) - Part 03/03

Main Objective: Migrate the Saga Camel Order Application to Distributed Microservices

Pre requistes:
JAVA 21 Installed
Docker  Installed
OpenShift Sandbox Account

Quarkus Extensions Used on Project:
RestEasy Reactive - quarkus-resteasy
Camal Saga - camel-quarkus-saga
Camel Direct - camel-quarkus-direct
Camel Bean - camel-quarkus-bean
Kubernetes - quarkus-kubernetes
Container Image Jib - quarkus-container-image-jib

Some Quick Commands

Remove Extensions
./mvnw quarkus:remove-extensions -Dextensions=camel-quarkus-direct,camel-quarkus-saga,camel-quarkus-bean

Add Extensions
./mvnw quarkus:add-extensions -Dextensions=quarkus-kubernetes,quarkus-container-image-jib
./mvnw quarkus:add-extensions -Dextensions=quarkus-rest-client


Connect to OpenShift Sandbox
oc login --token=sha256~1gXwjLiNq2ukl77mbDwv-b4rhfNQyZ-xHkE3FwARWzg --server=https://api.rm2.thpm.p1.openshiftapps.com:6443

Use OpenShift Project
oc project gpfaltz-dev

Login into Docker
docker login

Deploy Application into Kubernetes
./mvnw clean package -Dquarkus.kubernetes.deploy=true

Get Pods Created
kubectl get pod

Get Services Created
kubectl get svc

Expose Service on OpenShift
oc expose service saga-camel-credit

Get Existed Routes
kubectl get route

Testing saga-camel-credit
curl saga-camel-credit-gpfaltz-dev.apps.rm2.thpm.p1.openshiftapps.com/credit/newOrderValue?orderId=1&value=20

Testing saga-camel-order
curl saga-camel-order-gpfaltz-dev.apps.rm2.thpm.p1.openshiftapps.com/order/newOrder?id=1

Testing saga-camel-order Application
curl saga-camel-orchestrator-gpfaltz-dev.apps.rm2.thpm.p1.openshiftapps.com/saga-camel-order/test


