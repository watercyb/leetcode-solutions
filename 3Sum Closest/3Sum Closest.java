/*
 * Problem: 3Sum Closest
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/3sum-closest/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int diff = Integer.MAX_VALUE;
        byte[] counts = new byte[2001];
        for (int num : nums) {
            counts[num + 1000]++;
        }
        int idx = 0;
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[idx++] = i - 1000;
            }
        }
        int l = 0;
        int sum = nums[nums.length - 1] + nums[nums.length - 2];
        while (l < nums.length - 2) {
            if (sum + nums[l] >= target)
                break;
            l++;
        }
        l=Math.max(l-1,0);
        int r = nums.length - 1;
        sum = nums[0] + nums[1];
        while (r > 1) {
            if (sum + nums[r] <= target)
                break;
            r--;
        }
        r=Math.min(r+1,nums.length-1);
        int prvI = Integer.MIN_VALUE;
        for (int i = l; i <= r - 2; i++) {
            if (nums[i] == prvI)
                continue;
            int prvJ = Integer.MIN_VALUE;
            int k = r;
            for (int j = i + 1; j < k; j++) {
                if (nums[j] == prvJ)
                    continue;
                sum = nums[i] + nums[j] - target;
                while (k > j) {
                    int tmp = sum + nums[k];
                    if (Math.abs(tmp) < diff) {
                        diff = Math.abs(tmp);
                        res = tmp + target;
                        if (res==target) return target;
                    }
                    if (tmp < 0) {
                        break;
                    }
                    k--;
                }
                prvJ = nums[j];
            }
            prvI = nums[i];
        }
        return res;
    }
}
