/*
 * Problem: 3624. Number of Integers With Popcount-Depth Equal to K II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-integers-with-popcount-depth-equal-to-k-ii/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int[] popcountDepth(long[] nums, long[][] queries) {
        BITs = new int[6][nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int d = getLen(nums[i]);
            insert(BITs[d], i, 1);
            nums[i] = d;
        }
        int count = 0;
        for (long[] query : queries) {
            if (query[0] == 1)
                count++;
        }
        int[] res = new int[count];
        int idx = 0;
        for (long[] query : queries) {
            if (query[0] == 1) {
                int l = (int) query[1];
                int r = (int) query[2];
                int k = (int) query[3];
                res[idx++] = get(BITs[k], r) - get(BITs[k], l - 1);
            } else {
                int id = (int) query[1];
                long val = query[2];
                int d = getLen(val);
                if (nums[id] == d)
                    continue;
                insert(BITs[(int) nums[id]], id, -1);
                insert(BITs[d], id, 1);
                nums[id] = d;
            }
        }
        return res;
    }

    int[][] BITs;

    public int getLen(long num) {
        if (num == 1)
            return 0;
        int count = Long.bitCount(num);
        int res = 1;
        while (count > 1) {
            count = Integer.bitCount(count);
            res++;
        }
        return res;
    }

    public void insert(int[] bit, int i, int num) {
        i++;
        while (i < bit.length) {
            bit[i] += num;
            i += i & -i;
        }
    }

    public int get(int[] bit, int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += bit[i];
            i -= i & -i;
        }
        return res;
    }
}
