/*
 * Problem: 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int missingInteger(int[] nums) {
        boolean[] seens=new boolean[52];
        seens[nums[0]]=true;
        int idx=1;
        while (idx<nums.length&&nums[idx]==nums[idx-1]+1) {
            seens[nums[idx]]=true;
            idx++;
        }
        int target=(nums[0]+nums[0]+idx-1)*idx/2;
        while (idx<nums.length) {
            seens[nums[idx]]=true;
            idx++;
        }
        for (int i=target;i<seens.length;i++) {
            if (!seens[i]) return i;
        }
        return target;
    }
}
