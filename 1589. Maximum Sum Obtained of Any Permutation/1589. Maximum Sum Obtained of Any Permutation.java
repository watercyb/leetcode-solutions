/*
 * Problem: 1589. Maximum Sum Obtained of Any Permutation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int m=1000000007;
        int[] arr = new int[nums.length+1];
        int max=0;
        for (int[] request : requests) {
            arr[request[0]]++;
            arr[request[1]+1]--;
        }
        int[] arr1= new int[nums.length+1];
        int tmp = 0;
        int j=0;
        for (int i = 0; i <= nums.length; i++) {
            tmp += arr[i];
            if (tmp > 0) {
                arr1[j]=tmp;
                j++;
            } 
        }
        Arrays.sort(nums);
        Arrays.sort(arr1);

        int res = 0;
        j = arr1.length-1;
        int k=nums.length-1;
        while (arr1[j]!=0&&j>=0) {
            res += (nums[k] * (long)arr1[j])%m;
            res%=m;
            k--;
            j--;
        }
        return res%m;

    }
}
