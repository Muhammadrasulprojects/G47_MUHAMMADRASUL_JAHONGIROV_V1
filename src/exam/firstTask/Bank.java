package exam.firstTask;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int balance;
    private final Lock lock = new ReentrantLock();

    public void increaseBalance(int amount) {
        lock.lock();
        try {
            this.balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        lock.lock();
        try {
            return this.balance;
        } finally {
            lock.unlock();
        }
    }
}
