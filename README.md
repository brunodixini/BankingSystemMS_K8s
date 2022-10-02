# BankingSystemMS_K8s

## A banking system in microservice architecture, running in a local kubernetes cluster.

### The following is an instruction list to have the cluster running in your local machine.

- Install JDK 8, Docker and Minikube in your machine.

- Create the docker images from applications and save it in your docker repo (brunodixini is mine)
  - docker build -t brunodixini/cashback:1.0
    (this command in the project dockerFile folder)

- Start the cluster
  - minikube start
  - minikube addons enable ingress

- Create deployments
  - kubectl create -f cashbackDep.yaml
  - kubectl create -f contaCorrenteDep.yaml
  - (this commands inside deployments folder)

- Create services
  - kubectl create -f cashbackSvc.yaml
  - kubectl create -f contaCorrenteSvc.yaml
  - (this command inside services folder)

- Create ingress
  - kubectl create -f ingress.yaml
  - (this command inside ingress folder)

- Create namespace "monitoring", install prometheus stack to send metrics to Grafana
  - kubectl create ns monitoring
  - kubectl config set-context --current --namespace=monitoring
  - helm install prometheus prometheus-community/kube-prometheus-stack

- Come back to namespace "default"
  - kubectl config set-context --current --namespace=default

- Create metrics-server deployment
  - kubectl apply -f .
  - (this command inside metricsServer folder)

- Create hpa
  - kubectl create -f cashbackAutoscaler.yaml
  - kubectl describe hpa cashback-hpa
  - (this command inside hpa folder)

- Expose ingress
  - minikube tunnel

- Enable access to Grafana
  - kubectl port-forward deployment/prometheus-grafana 3000 --namespace=monitoring
