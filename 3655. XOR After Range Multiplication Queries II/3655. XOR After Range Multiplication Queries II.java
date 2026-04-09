/*
 * Problem: 3655. XOR After Range Multiplication Queries II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/xor-after-range-multiplication-queries-ii/?envType=daily-question&envId=2026-04-09
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1_000_000_007;
        memes[1] = 1;
        int lim = (int) Math.sqrt(nums.length);
        HashMap<Integer, List<int[]>> HM = new HashMap<>();
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
                if (!HM.containsKey(k)) {
                    List<int[]> list = new ArrayList<>();
                    list.add(queries[i]);
                    HM.put(k, list);
                } else {
                    List<int[]> list = HM.get(k);
                    list.add(queries[i]);
                }
            }
        }
        long[] line = new long[nums.length + lim];
        for (Map.Entry<Integer, List<int[]>> entry : HM.entrySet()) {
            Arrays.fill(line, 1);
            int left = Integer.MAX_VALUE;
            int right = Integer.MIN_VALUE;
            int k = entry.getKey();
            long[] pros = new long[k];
            Arrays.fill(pros, 1);
            for (int[] query : entry.getValue()) {
                int l = query[0];
                int r = query[1];
                int v = query[3];
                r -= (r - l) % k;
                line[l] = line[l] * v % mod;
                line[r + k] = line[r + k] * rev(v, mod) % mod;
                left = Math.min(left, l);
                right = Math.max(right, r);
            }
            for (int i = left; i <= right; i++) {
                int m = i % k;
                pros[m] = pros[m] * line[i] % mod;
                nums[i] = (int) (pros[m] * nums[i] % mod);
            }
        }
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    long[] memes = new long[100001];

    public long rev(long a, int mod) {
        if (memes[(int) a] != 0)
            return memes[(int) a];
        return memes[(int) a] = mod - mod / a * rev(mod % a, mod) % mod;
    }
}
