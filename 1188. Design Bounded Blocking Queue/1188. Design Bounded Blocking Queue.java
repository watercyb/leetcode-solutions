/*
 * Problem: 1188. Design Bounded Blocking Queue
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-bounded-blocking-queue/
 * Language: java
 * Date: 2026-04-14
 */

class BoundedBlockingQueue {
    int capacity;
    Deque<Integer> Dq = new ArrayDeque<>();
    Semaphore l = new Semaphore(0);
    Semaphore r = new Semaphore(1);
    Semaphore running = new Semaphore(1);

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        r.acquire();
        running.acquire();
        Dq.offerLast(element);
        if (Dq.size() == 1)
            l.release();
        if (Dq.size() < capacity)
            r.release();
        running.release();
    }

    public int dequeue() throws InterruptedException {
        l.acquire();
        running.acquire();
        int res = Dq.pollFirst();
        if (!Dq.isEmpty())
            l.release();
        if (Dq.size() == capacity - 1)
            r.release();
        running.release();
        return res;
    }

    public int size() {
        return Dq.size();
    }
}
