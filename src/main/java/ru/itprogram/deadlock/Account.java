package ru.itprogram.deadlock;

import java.util.Objects;

public class Account {
    private long id;
    private long balance;

    public Account(long id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public synchronized void doTransaction(Account destinationAccount, int money) {
        System.out.println("\n" + "На аккаунте: " + destinationAccount.getId() + " денег " + destinationAccount.getBalance());
        System.out.format("id аккаунта: " + "[" + String.valueOf(destinationAccount.getId()) + "]");
        this.setBalance(this.getBalance() - money);
        destinationAccount.doAdd(destinationAccount, money);
    }

    private synchronized void doAdd(Account destinationAccount, int money) {
        destinationAccount.setBalance(destinationAccount.getBalance() + money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                balance == account.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
