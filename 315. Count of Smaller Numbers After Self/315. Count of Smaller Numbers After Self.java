/*
 * Problem: 315. Count of Smaller Numbers After Self
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max)
                max = num;
            if (num < min)
                min = num;
        }
        int min1=min-1;
        int[] BT = new int[max - min1];
        Integer[] res = new Integer[nums.length];
        res[nums.length - 1] = 0;
        updateSum(BT, nums[nums.length - 1] - min1, 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            updateSum(BT, nums[i] - min1, 1);
            res[i] = getSum(BT, nums[i] - min);
        }
        return Arrays.asList(res);
    }

    public void updateSum(int[] BT, int i, int num) {
        while (i < BT.length) {
            BT[i] += num;
            i += i & -i;
        }
    }

    public int getSum(int[] BT, int i) {
        if (i==0) return 0;
        int sum = 0;
        while (i > 0) {
            sum += BT[i];
            i -= i & -i;
        }
        return sum;
    }
}
