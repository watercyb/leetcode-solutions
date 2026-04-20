/*
 * Problem: 1756. Design Most Recently Used Queue
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-most-recently-used-queue/
 * Language: java
 * Date: 2026-04-20
 */

class MRUQueue {
    List<Integer> list = new ArrayList<>();

    public MRUQueue(int n) {
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }

    public int fetch(int k) {
        k--;
        int res = list.get(k);
        list.remove(k);
        list.add(res);
        return res;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */
