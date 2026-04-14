/*
 * Problem: 1114. Print in Order
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/print-in-order/
 * Language: java
 * Date: 2026-04-14
 */

class Foo {
    Semaphore a = new Semaphore(1);
    Semaphore b = new Semaphore(0);
    Semaphore c = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        b.release(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        b.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        c.release(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        c.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
