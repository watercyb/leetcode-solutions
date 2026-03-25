/*
 * Problem: 4Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/4sum/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> inLi= new ArrayList<List<Integer>>(); 
        Arrays.sort(nums);
        int n=nums.length;
        int avg=target/4;
        if (nums[n-1]<avg) {return inLi;}
        for (int i=0;i<n-3;i++) {
            int n1=nums[i];
            if ((i>0&&n1==nums[i-1])||n1>avg) {continue;}
            for (int j=i+1;j<n-2;j++) {
                int n2=nums[j];
                if (j>i+1&&n2==nums[j-1]) {continue;}
                int k=j+1;
                int l=n-1;
                long n12=target-((long)n1+n2);
                if (n12-(nums[n-2]+nums[n-1])>0) {continue;}
                if (n12-(nums[k]+nums[k+1])<0) {continue;}
                while (k<l) {
                    int n3=nums[k];
                    int n4=nums[l];
                    long n34=(long)n3+n4;
                    if (k>j+1&&n3==nums[k-1]) {k++;continue;}
                    if (l<n-1&&n4==nums[l+1]) {l--;continue;}
                    if (n34<n12) {k++;}
                    if (n34>n12) {l--;}
                    if (n34==n12) {
                        inLi.add(List.of(n1, n2, n3, n4));
                        k++;
                        l--;
                    }
                }
            }
        }
        return inLi;
    }
}
