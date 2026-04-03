/*
 * Problem: 446. Arithmetic Slices II - Subsequence
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[][] arr = new int[nums.length][nums.length];
        HashMap<Integer, int[]> HM1 = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] tmp = HM1.getOrDefault(nums[i], new int[50]);
            if (tmp[0] == 0) {
                tmp[0] = 1;
                tmp[1] = i;
                HM1.put(nums[i], tmp);
            } else {
                tmp[0]++;
                tmp[tmp[0]] = i;
                if (tmp[0]>2) {
                    tmp[48]+=tmp[0]-2;
                    int t=tmp[49]+tmp[48];
                    res+=t;
                    tmp[49]+=t;      
                }
            }
            for (int j = 0; j < i; j++) {
                long n = (long) nums[j] * 2 - nums[i];
                if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE)
                    continue;
                int in = (int) n;
                if (nums[i] != nums[j]) {
                    if (HM1.containsKey(in)) {
                        int[] tmp1 = HM1.get(in);
                        for (int k = 1; k <= tmp1[0]; k++) {
                            if (tmp1[k] >= j)
                                break;
                            arr[i][j] += arr[j][tmp1[k]] + 1;
                        }
                    }
                }
                res += arr[i][j];
            }
        }
        return res;

    }
}
