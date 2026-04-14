/*
 * Problem: 1167. Minimum Cost to Connect Sticks
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int connectSticks(int[] sticks) {
        int[] counts = new int[10001];
        for (int stick : sticks) {
            counts[stick]++;
        }
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                sticks[idx++] = i;
                counts[i]--;
            }
        }
        Queue<Integer> Qu = new LinkedList<>();
        idx = 0;
        int res = 0;
        while (idx < sticks.length || Qu.size() > 1) {
            int a = 0;
            if (idx == sticks.length) {
                a = Qu.poll();
            } else if (Qu.isEmpty()) {
                a = sticks[idx++];
            } else {
                if (Qu.peek() < sticks[idx]) {
                    a = Qu.poll();
                } else {
                    a = sticks[idx++];
                }
            }
            int b = 0;
            if (idx < sticks.length || !Qu.isEmpty()) {
                if (idx == sticks.length) {
                    b = Qu.poll();
                } else if (Qu.isEmpty()) {
                    b = sticks[idx++];
                } else {
                    if (Qu.peek() < sticks[idx]) {
                        b = Qu.poll();
                    } else {
                        b = sticks[idx++];
                    }
                }
                res += a + b;
                Qu.offer(a + b);
            }
        }
        return res;
    }
}
