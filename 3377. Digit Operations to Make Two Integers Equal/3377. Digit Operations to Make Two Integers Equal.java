/*
 * Problem: 3377. Digit Operations to Make Two Integers Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/digit-operations-to-make-two-integers-equal/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minOperations(int n, int m) {
        if (nonPrime == null)
            getPrime();
        if (!nonPrime[n] || !nonPrime[m])
            return -1;
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PQ.offer(new int[] { n, n });
        int[] stps = new int[10000];
        Arrays.fill(stps, Integer.MAX_VALUE);
        stps[n] = n;
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            int idx = current[0];
            int stp = current[1];
            if (idx == m)
                return stp;
            char[] chrs = String.valueOf(idx).toCharArray();
            for (int i = 0; i < chrs.length; i++) {
                if (chrs[i] > '0') {
                    chrs[i]--;
                    int nextIdx = getNum(chrs);
                    int nextStp = nextIdx + stp;
                    if (nextStp < stps[nextIdx] && nonPrime[nextIdx]) {
                        stps[nextIdx] = nextStp;
                        PQ.offer(new int[] { nextIdx, nextStp });
                    }
                    chrs[i]++;
                }
                if (chrs[i] < '9') {
                    chrs[i]++;
                    int nextIdx = getNum(chrs);
                    int nextStp = nextIdx + stp;
                    if (nextStp < stps[nextIdx] && nonPrime[nextIdx]) {
                        stps[nextIdx] = nextStp;
                        PQ.offer(new int[] { nextIdx, nextStp });
                    }
                    chrs[i]--;
                }
            }
        }
        return -1;
    }

    public int getNum(char[] chrs) {
        int res = 0;
        for (char chr : chrs) {
            res = res * 10 + chr - '0';
        }
        return res;
    }

    static boolean[] nonPrime;

    public boolean[] getPrime() {
        nonPrime = new boolean[10000];
        nonPrime[0] = true;
        nonPrime[1] = true;
        for (int i = 2; i < 10000; i++) {
            if (nonPrime[i])
                continue;
            for (int j = i * i; j < 10000; j += i) {
                nonPrime[j] = true;
            }
        }
        return nonPrime;
    }
}
