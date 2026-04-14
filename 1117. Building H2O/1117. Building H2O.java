/*
 * Problem: 1117. Building H2O
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/building-h2o/
 * Language: java
 * Date: 2026-04-14
 */

class H2O {
    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(0);
    AtomicInteger h1 = new AtomicInteger(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        releaseHydrogen.run();
        h1.incrementAndGet();
        if (h1.get() == 2)
            o.release();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        releaseOxygen.run();
        h1.set(0);
        h.release(2);
    }
}
