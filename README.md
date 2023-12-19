# dapr-pub-sub-examples
Various examples of using Dapr with the pubsub building block across runtimes.

## Running locally
1. Install some type of Kubernetes cluster. An easy method is to just enable [Kubernetes in Docker Desktop](https://docs.docker.com/desktop/kubernetes/#:~:text=To%20turn%20on%20Kubernetes%20in%20Docker%20Desktop%3A%201,and%20installs%20the%20%2Fusr%2Flocal%2Fbin%2Fkubectl%20command%20on%20your%20machine.)
2. Each language folder has a `local-k8s` sub folder. This contains a `pubsub.yaml`, `deployment.yaml` and `service.yaml` file.
   - Prior to deployment, update the `pubsub.yaml` with the required values needed
3. Build the image with the `Dockerfile` in the language folder being used. If the image name is not the same name in `deployment.yaml`, then update `deployment.yaml`
4. Deploy the project with `kubectl apply -f local-k8s/`

## Using Container Apps
1. Create a Container App and Container App environment
2. Push the image built from the language `Dockerfile` to an Azure Container Registry
3. Create a `pubsub` dapr component, with the following:
  - ![image](https://github.com/Ajsalemo/dapr-pub-sub-examples/assets/31021304/32d2f13d-f62e-42d6-ba1c-ae5e724335de)
  - Add in the same `metaData` thats in the `local-k8s` folders in the examples
  - `connectionString`: EventHub connection string
  - `storageAccountName`: Storage account name
  - `storageAccountKey`: Storage account key
  - `storageContainerName`: Storage ontainer name
  - `consumerID`: Name of the consumer ID, if not defined, it uses the `appId`
  - Add the component to the application by specifying it in `scopes`
4. Enable dapr on the Container App
5. Ensure ingress is set to the appropriate port for the language example being used
