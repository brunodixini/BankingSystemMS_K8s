# BankingSystemMS_K8s
A banking system in microservice architecture, running in a local k8s cluster

- Create the docker images from aplications and save it in your docker repo (brunodixini is mine)
  docker build -t brunodixini/cashback:1.0
  (this command in the DockerFile paste, inside each microservice project)

- Start the cluster
  minikube start
  minikube addons enable ingress

- Create deployments
  kubectl create -f cashbackDep.yaml
  kubectl create -f contaCorrenteDep.yaml
  (this command inside deployments paste)

- Create services
  kubectl create -f cashbackSvc.yaml
  kubectl create -f contaCorrenteSvc.yaml
  (this command inside services paste)

- Create ingress
  kubectl create -f ingress.yaml
  (this command inside ingress paste)

- Create namespace "monitoring", install prometheus stack to send metrics to Grafana
  kubectl create ns monitoring
  kubectl config set-context --current --namespace=monitoring
  helm install prometheus prometheus-community/kube-prometheus-stack

- Come back to namespace "default"
  kubectl config set-context --current --namespace=default

- Create metrics-server deployment
  kubectl apply -f .
  (this command inside metricsServer paste)

- Create hpa
  kubectl create -f cashbackAutoscaler.yaml
  kubectl describe hpa cashback-hpa
  (this command inside hpa paste)

- Expose ingress
  minikube tunnel

- Enable access to Grafana
  kubectl port-forward deployment/prometheus-grafana 3000 --namespace=monitoring