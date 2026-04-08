/*
 * Problem: 752. Open the Lock
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/open-the-lock/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public static int openLock(String[] deadends, String target) {
        int tar = Integer.valueOf(target);
        if (tar == 0)
            return 0;
        boolean[] seens = new boolean[10000];
        for (String deadend : deadends) {
            int tmp = Integer.valueOf(deadend);
            if (tmp == 0)
                return -1;
            seens[tmp] = true;
        }
        Queue<Integer> Qu = new LinkedList<>();
        Qu.offer(0);
        seens[0] = true;
        int stp = 1;
        while (!Qu.isEmpty()) {
            int n = Qu.size();
            for (int i = 0; i < n; i++) {
                int next = Qu.poll();
                for (int j = 1; j <= 1000; j *= 10) {
                    if (next / j % 10 == 9) {
                        int tmp = next - 9 * j;
                        if (tmp == tar)
                            return stp;
                        if (!seens[tmp]) {
                            seens[tmp] = true;
                            Qu.offer(tmp);
                        }
                    } else {
                        int tmp = next + j;
                        if (tmp == tar)
                            return stp;
                        if (!seens[tmp]) {
                            seens[tmp] = true;
                            Qu.offer(tmp);
                        }
                    }
                    if (next / j % 10 == 0) {
                        int tmp = next + 9 * j;
                        if (tmp == tar)
                            return stp;
                        if (!seens[tmp]) {
                            seens[tmp] = true;
                            Qu.offer(tmp);
                        }
                    } else {
                        int tmp = next - j;
                        if (tmp == tar)
                            return stp;
                        if (!seens[tmp]) {
                            seens[tmp] = true;
                            Qu.offer(tmp);
                        }
                    }
                }
            }
            stp++;
        }
        return -1;
    }
}
