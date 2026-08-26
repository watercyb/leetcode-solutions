/*
 * Problem: 1043. Partition Array for Maximum Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-array-for-maximum-sum/
 * Language: java
 * Date: 2026-08-26
 */

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[][] mems=new int[k+1][arr.length];
        for (int i=0;i<=k;i++) {
            Arrays.fill(mems[i],-1);
        }
        return DFS(mems,arr,k,0);
    }

    public int DFS(int[][] mems, int[] arr, int k,int i) {
        if (i==arr.length) return 0;
        if (mems[k][i]!=-1) return mems[k][i];
        int max=0;
        int res=0;
        int lim=Math.min(i+k,arr.length);
        for (int j=i;j<lim;j++) {
            if (max<arr[j]) max=arr[j];
            res=Math.max(res,DFS(mems,arr,k,j+1)+max*(j-i+1));
        }
        mems[k][i]=res;
        return res;
    }
}
