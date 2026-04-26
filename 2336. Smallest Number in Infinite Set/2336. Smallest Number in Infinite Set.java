/*
 * Problem: 2336. Smallest Number in Infinite Set
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-number-in-infinite-set/
 * Language: java
 * Date: 2026-04-26
 */

class SmallestInfiniteSet {
    int min = 1;
    PriorityQueue<Integer> PQ = new PriorityQueue<>();

    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        if (!PQ.isEmpty()) {
            int res = PQ.poll();
            while (!PQ.isEmpty() && PQ.peek() == res) {
                PQ.poll();
            }
            return res;
        } else {
            return min++;
        }
    }

    public void addBack(int num) {
        if (num < min)
            PQ.offer(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
