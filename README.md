# saga-camel-quarkus-distr
Distributing your orchestrated services (in practice)

Main Objective:

Some Quick Commands

Remove Extensions
./mvnw quarkus:remove-extensions -Dextensions=camel-quarkus-direct,camel-quarkus-saga,camel-quarkus-bean
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


