/*
 * Problem: 3653. XOR After Range Multiplication Queries I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/xor-after-range-multiplication-queries-i/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1_000_000_007;
        int lim = (int) Math.sqrt(nums.length);
        List<Integer>[][] arr = new ArrayList[lim][];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int k = queries[i][2];
            if (k >= lim) {
                int r = queries[i][1];
                long v = queries[i][3];
                for (int j = l; j <= r; j += k) {
                    nums[j] = (int) (v * nums[j] % mod);
                }
            } else {
                int m = l % k;
                if (arr[k] == null)
                    arr[k] = new ArrayList[k];
                if (arr[k][m] == null)
                    arr[k][m] = new ArrayList<>();
                arr[k][m].add(i);
            }
        }
        long[] pros = new long[nums.length];
        long[] divs = new long[nums.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
                continue;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != null) {
                    if (arr[i][j].size() == 1) {
                        int idx = arr[i][j].getFirst();
                        int l = queries[idx][0];
                        int r = queries[idx][1];
                        long v = queries[idx][3];
                        for (int n = l; n <= r; n += i) {
                            nums[n] = (int) (v * nums[n] % mod);
                        }
                    } else {
                        Arrays.fill(pros, 1);
                        Arrays.fill(divs, 1);
                        for (int idx : arr[i][j]) {
                            int l = queries[idx][0];
                            int r = queries[idx][1];
                            r -= (r - l) % i;
                            pros[l] = pros[l] * queries[idx][3] % mod;
                            divs[r] = divs[r] * queries[idx][3] % mod;
                        }
                        long pro = 1;
                        for (int n = j; n < nums.length; n += i) {
                            pro = pro * pros[n] % mod;
                            nums[n] = (int) (pro * nums[n] % mod);
                            pro = pro * rev(divs[n], mod) % mod;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public long rev(long a, int mod) {
        if (a == 1)
            return 1;
        return mod - mod / a * rev(mod % a, mod) % mod;
    }
}
