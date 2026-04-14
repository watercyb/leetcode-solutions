/*
 * Problem: 1195. Fizz Buzz Multithreaded
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/fizz-buzz-multithreaded/
 * Language: java
 * Date: 2026-04-14
 */

class FizzBuzz {
    private int n;
    private AtomicInteger i = new AtomicInteger(1);
    private Semaphore semaphore = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            semaphore.acquire();
            if (i.get() > n) {
                semaphore.release();
                return;
            }
            if (i.get() % 3 == 0 && i.get() % 5 != 0) {
                printFizz.run();
                i.incrementAndGet();
            }
            semaphore.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            semaphore.acquire();
            if (i.get() > n) {
                semaphore.release();
                return;
            }
            if (i.get() % 3 != 0 && i.get() % 5 == 0) {
                printBuzz.run();
                i.incrementAndGet();
            }
            semaphore.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            semaphore.acquire();
            if (i.get() > n) {
                semaphore.release();
                return;
            }
            if (i.get() % 3 == 0 && i.get() % 5 == 0) {
                printFizzBuzz.run();
                i.incrementAndGet();
            }
            semaphore.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            semaphore.acquire();
            if (i.get() > n) {
                semaphore.release();
                return;
            }
            if (i.get() % 3 != 0 && i.get() % 5 != 0) {
                printNumber.accept(i.get());
                i.incrementAndGet();
            }
            semaphore.release();
        }
    }
}
