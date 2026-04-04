/*
 * Problem: 560. Subarray Sum Equals K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/subarray-sum-equals-k/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res=0;
        if (nums.length<100) {
            for (int i=0;i<nums.length;i++) {
                int sum=0;
                for (int j=i;j<nums.length;j++) {
                    sum+=nums[j];
                    if (sum==k) res++;
                }
            }
            return res;
        }

        HashMap<Integer,Integer> HS=new HashMap<>();

        int tmp=0;
        HS.put(0,1);
        

        for (int i=0;i<nums.length;i++){
            tmp+=nums[i];
            res+=HS.getOrDefault(tmp-k,0);
            HS.merge(tmp,1,Integer::sum);

        }

        return res;
        
    }
}
