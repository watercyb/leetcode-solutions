/*
 * Problem: 933. Number of Recent Calls
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-recent-calls/
 * Language: java
 * Date: 2026-04-10
 */

class RecentCounter {
    int[] Dq = new int[10001];
    int l = 0;
    int r = 0;

    public RecentCounter() {

    }

    public int ping(int t) {
        Dq[r++] = t;
        while (Dq[l] + 3000 < t) {
            l++;
        }
        return r - l;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
