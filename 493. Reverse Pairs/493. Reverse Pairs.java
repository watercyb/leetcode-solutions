/*
 * Problem: 493. Reverse Pairs
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/reverse-pairs/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
     public int reversePairs(int[] nums) {
       int[] arr=new int[nums.length];
       int res=sep(arr,nums,0,nums.length-1);
       return res;
    }

    public int sep(int[] arr,int[] nums,int l, int r) {
        if (l==r) return 0;
        return sep(arr,nums,l,(l+r)/2)+sep(arr,nums, (l+r)/2+1, r)+merg(arr,nums,l,r);
    }

    public int merg(int[] arr,int[] nums,int l, int r) {
        int i=l;
        int m=(l+r)/2+1;
        int j=m;
        int counts=0;
        while (j<=r) {
            while (nums[i]<=(long)nums[j]*2&&i<m) i++;
            if (i==m) break;
            counts+=m-i;
            j++;
        }
        i=l;
        j=m;
        for (int k=l;k<=r;k++) {
            if (i==m) {
                arr[k]=nums[j];
                j++;
            } else if (j>r) {
                arr[k]=nums[i];
                i++;
            } else if (nums[i]<=nums[j]) {
                arr[k]=nums[i];
                i++;
            } else {
                arr[k]=nums[j];
                j++;
            }
        }
        for (int k=l;k<=r;k++) {
            nums[k]=arr[k];
        }
        return counts;
    }
}
