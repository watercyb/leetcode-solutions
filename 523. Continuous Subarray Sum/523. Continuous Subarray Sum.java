/*
 * Problem: 523. Continuous Subarray Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/continuous-subarray-sum/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int [] sum=new int [nums.length+1];
        int tmp=-1;
        for (int i=0;i<nums.length;i++) {
            if (tmp==sum[i]&&nums[i]==0) return true;
            sum[i+1]+=sum[i]+nums[i];
            tmp=sum[i];
            
        }

        int j=0;
        int nextJ=0;
        for (int i=0;i<sum.length-2;i++) {    
            j=Math.max(nextJ,i+2);
            while (j<sum.length&&sum[j]-sum[i]<k) j++;
            nextJ=j;
            while (j<sum.length) {
                if ((sum[j]-sum[i])%k==0) return true;
                j++;
            }
            
        }
        return false;
        
    }
}
