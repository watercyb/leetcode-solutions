/*
 * Problem: 1492. The kth Factor of n
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-kth-factor-of-n/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int kthFactor(int n, int k) {
        int l = (int) Math.sqrt(n);
        Deque<Integer> Dq = new ArrayDeque<>();
        for (int i = 1; i <= l; i++) {
            if (n % i == 0) {
                Dq.offerFirst(n / i);
                if (k-- == 1)
                    return i;
            }

        }
        if (l * l == n)
            Dq.pollFirst();
        while (!Dq.isEmpty()) {
            int num = Dq.pollFirst();
            if (k-- == 1)
                return num;
        }
        return -1;
    }
}
