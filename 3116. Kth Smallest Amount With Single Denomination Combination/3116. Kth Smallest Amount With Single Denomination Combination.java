/*
 * Problem: 3116. Kth Smallest Amount With Single Denomination Combination
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        int count = coins.length;
        for (int i = 0; i < coins.length - 1; i++) {
            if (coins[i] == Integer.MAX_VALUE)
                continue;
            for (int j = i + 1; j < coins.length; j++) {
                if (coins[j] != Integer.MAX_VALUE && coins[j] % coins[i] == 0) {
                    coins[j] = Integer.MAX_VALUE;
                    count--;
                }
            }
        }
        Arrays.sort(coins);
        coins = Arrays.copyOf(coins, count);
        long l = k;
        long r = (long) k * coins[0];
        long[] lcm = new long[1 << coins.length];
        lcm[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            lcm[1 << i] = coins[i];
        }
        getLCM(coins, lcm);
        while (l < r) {
            long mid = (l + r) >>> 1;
            if (chk(lcm, mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public void getLCM(int[] coins, long[] lcm) {
        int leading = 0;
        for (int i = 1; i < lcm.length; i++) {
            int a = i & -i;
            int b = i - a;
            lcm[i] = lcm[a] / GCD(lcm[a], lcm[b]) * lcm[b];
        }
    }

    public long chk(long[] lcm, long mid) {
        long res = 0;
        for (int i = 1; i < lcm.length; i++) {
            if (Integer.bitCount(i) % 2 == 1) {
                res += mid / lcm[i];
            } else {
                res -= mid / lcm[i];
            }
        }
        return res;
    }

    public long GCD(long a, long b) {
        while (b > 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
