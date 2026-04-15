/*
 * Problem: 1226. The Dining Philosophers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-dining-philosophers/
 * Language: java
 * Date: 2026-04-15
 */

class DiningPhilosophers {
    Semaphore[] semaphores = new Semaphore[5];

    public DiningPhilosophers() {
        semaphores[0] = new Semaphore(1);
        semaphores[1] = new Semaphore(0);
        semaphores[2] = new Semaphore(0);
        semaphores[3] = new Semaphore(0);
        semaphores[4] = new Semaphore(0);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {
        semaphores[philosopher].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        semaphores[(philosopher + 1) % 5].release();
    }
}
