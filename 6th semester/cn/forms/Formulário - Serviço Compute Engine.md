```java
/*
* Start/Stop de uma VM
*/

try (InstancesClient client = InstancesClient.create()) {
    StartInstanceRequest request = StartInstanceRequest.newBuilder()
        .setProject(project)
        .setZone(zone)
        .setInstance(instanceName)
        .build();
        
    OperationFuture<Operation, Operation> fut = client.startAsync(request); // para parar fazer stopAsync
    
    while (!fut.isDone()) {
        Thread.sleep(10000);
    }
}

/*
* Listagem de grupos de instâncias
*/

try (InstanceGroupManagersClient managersClient = InstanceGroupManagersClient.create()) {
    for (InstanceGroupManager manager : managersClient.list(project, zone).iterateAll()) {
        // manager.getName());
        // manager.getInstanceTemplate());
    }
}

/*
* Listagem de VMs num grupo de instâncias
*/

InstanceGroupManagersClient managersClient = InstanceGroupManagersClient.create();
    
ListManagedInstancesInstanceGroupManagersRequest request = ListManagedInstancesInstanceGroupManagersRequest.newBuilder()
    .setInstanceGroupManager(groupName)
    .setProject(project)
    .setReturnPartialSuccess(true)
    .setZone(zone)
    .build();

for (ManagedInstance instance : managersClient.listManagedInstances(request).iterateAll()) {
    // instance.getInstance()
    // instance.getInstanceStatus());
}

/*
* Contagem do número de instâncias a correr num grupo
*/

int totalInstancesSize = 0;

InstancesClient client = InstancesClient.create();
for (Instance curInst : client.list(project, zone).iterateAll()) {
    if (curInst.getName().contains(groupName) && curInst.getStatus().equals("RUNNING"))
        totalInstancesSize++;
}

/*
* Listagem do IP das VMs num grupo de instâncias
*/

try (InstancesClient client = InstancesClient.create()) {
    for (Instance instance : client.list(project, zone).iterateAll()) {
        if (instance.getStatus().compareTo("RUNNING") == 0) {
            if (instance.getName().contains(INST_GROUP)) {
                String ip = instance.getNetworkInterfaces(0).getAccessConfigs(0).getNatIP();
            }
        }
    }
}

/*
* Redimensionar o número de VMs num grupo de instâncias
*/

InstanceGroupManagersClient managersClient = InstanceGroupManagersClient.create();
    
OperationFuture<Operation, Operation> result = managersClient.resizeAsync(
    project, 
    zone, 
    groupName, 
    newSize
);

Operation oper=result.get();
```