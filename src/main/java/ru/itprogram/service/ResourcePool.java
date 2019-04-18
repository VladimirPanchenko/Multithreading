package ru.itprogram.service;

import ru.itprogram.entity.Resource;

import java.util.ArrayList;
import java.util.List;

public class ResourcePool {
    private static ResourcePool instance;
    private List<Resource> resources;

    private ResourcePool() {
        resources = new ArrayList<>();
        initialize();
    }

    public static ResourcePool getInstance() {
        if (instance == null) {
            instance = new ResourcePool();
        }
        return instance;
    }

    private void initialize() {
        resources.add(new Resource(0 , false));
        resources.add(new Resource(1 , false));
        resources.add(new Resource(2 , false));
        resources.add(new Resource(3 , false));
        resources.add(new Resource(4 , false));
        resources.add(new Resource(5 , false));
        resources.add(new Resource(6 , false));
    }

    public List<Resource> getResources() {
        return resources;
    }

    public Resource getOneResource(int item) {
        return resources.get(item);
    }

    public void setResource(Resource resource) {
        resources.add(resource);
    }

    public int sizePool() {
        return resources.size();
    }
}
