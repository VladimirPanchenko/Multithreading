package ru.itprogram.service;

import ru.itprogram.entity.Resource;

import java.util.Random;

public class GeneratorThread extends Thread {
    private static final int DELAY_TIME = 2000;
    private Random random;
    private Resource resource;
    private ResourcePool resourcePool;

    public GeneratorThread() {
        random = new Random();
        resourcePool = ResourcePool.getInstance();
    }

    public GeneratorThread(int countThread) {
        for (int i = 0; i < countThread; i++) {
            new GeneratorThread().start();
        }
    }

    @Override
    public synchronized void run() {
        resource = resourcePool.getOneResource(random.nextInt(resourcePool.sizePool()));
        resource.setUsing(true);
            System.out.println("Объект c ID [" + resource.getId()
                    + "] находится в потоке с именем [" + getName() + "] в работе");
        resource.setWeight(resource.getWeight() + 1);
            System.out.println("Объект c ID [" + resource.getId()
                    + "] имеет вес: [" + resource.getWeight() + "]"
                    + " находится в потоке с именем [" + getName() + "]");
        try {
            Thread.currentThread().sleep(DELAY_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Объект c ID [" + resource.getId()
                + "] находится в потоке с именем [" + getName() + "] освобождён");
        resource.setUsing(false);
    }
}
