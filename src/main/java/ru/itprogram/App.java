package ru.itprogram;


public class App {
    public static void main( String[] args ) {
        /* Вызов метода закоментирован так как вызывает deadlock
        *  Для проверки на deadlock раскоментировать метод dead();*/
//        dead(deadLockAccountOne, deadLockAccountTwo);

        unDead();


    }

    public static void dead() {
        final ru.itprogram.deadlock.Account deadLockAccountOne = new  ru.itprogram.deadlock.Account(0, 10000);
        final ru.itprogram.deadlock.Account deadLockAccountTwo = new  ru.itprogram.deadlock.Account(1, 600);
        final int TRANSFER_AMOUNT_ONE = 500;
        final int TRANSFER_AMOUNT_TWO = 200;

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLockAccountOne.doTransaction(deadLockAccountTwo, TRANSFER_AMOUNT_ONE);
                System.out.println("На аккаунте [" + deadLockAccountOne.getId() + "] теперь: " + deadLockAccountOne.getBalance());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLockAccountTwo.doTransaction(deadLockAccountOne, TRANSFER_AMOUNT_TWO);
                System.out.println("На аккаунте теперь: " + deadLockAccountTwo.getBalance());
            }
        }).start();
    }

    public static void unDead() {
        final ru.itprogram.undeadlock.Account undeadLockAccountOne = new ru.itprogram.undeadlock.Account(0, 10000);
        final ru.itprogram.undeadlock.Account undeadLockAccountTwo = new ru.itprogram.undeadlock.Account(1, 600);
        final int TRANSFER_AMOUNT_ONE = 500;
        final int TRANSFER_AMOUNT_TWO = 200;

        new Thread(new Runnable() {
            @Override
            public void run() {
                undeadLockAccountOne.doTransaction(undeadLockAccountTwo, TRANSFER_AMOUNT_ONE);
                System.out.println("На аккаунте [" + undeadLockAccountOne.getId() + "] теперь: " + undeadLockAccountOne.getBalance());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                undeadLockAccountTwo.doTransaction(undeadLockAccountOne, TRANSFER_AMOUNT_TWO);
                System.out.println("На аккаунте теперь: " + undeadLockAccountTwo.getBalance());
            }
        }).start();
    }
}
