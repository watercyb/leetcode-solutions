/*
 * Problem: 3671. Sum of Beautiful Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-beautiful-subsequences/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int totalBeauty(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        List<Integer>[] lists = new ArrayList[max + 1];
        for (int i = 1; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        int lim = (int) Math.sqrt(max);
        long[] counts = new long[max + 1];
        for (int num : nums) {
            for (int i = 1; i <= lim; i++) {
                if (num % i == 0) {
                    int n = num / i;
                    lists[i].add(n);
                    if (n > lim && n != i)
                        lists[n].add(i);
                }
            }
        }
        for (int i = 1; i <= max; i++) {
            if (lists[i].isEmpty())
                continue;
            if (lists[i].size() == 1) {
                counts[i] = 1;
                continue;
            }
            int maxNum = 0;
            for (int num : lists[i]) {
                maxNum = Math.max(maxNum, num);
            }
            BIT = new long[maxNum + 2];
            long sum = 0;
            for (int num : lists[i]) {
                long count = get(num - 1) + 1;
                sum += count;
                insert(num, count);
            }
            counts[i] = sum % mod;
        }
        long res = 0;
        for (int i = max; i >= 0; i--) {
            long sum = counts[i];
            if (sum == 0)
                continue;
            int idx = i + i;
            while (idx <= max) {
                sum -= counts[idx];
                idx += i;
            }
            sum = (sum % mod + mod) % mod;
            counts[i] = sum;
            res = (res + sum * i) % mod;
        }
        return (int) res;
    }

    int mod = 1_000_000_007;
    long[] BIT;

    public void insert(int i, long num) {
        i++;
        while (i < BIT.length) {
            BIT[i] = (BIT[i] + num) % mod;
            i += i & -i;
        }
    }

    public long get(int i) {
        i++;
        long res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res % mod;
    }
}
