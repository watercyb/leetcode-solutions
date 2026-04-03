/*
 * Problem: 362. Design Hit Counter
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-hit-counter/
 * Language: java
 * Date: 2026-04-03
 */

class HitCounter {
    Queue<Integer> Qu = new LinkedList<>();

    public HitCounter() {

    }

    public void hit(int timestamp) {
        Qu.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while (!Qu.isEmpty() && Qu.peek() + 300 <= timestamp) {
            Qu.poll();
        }
        return Qu.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
