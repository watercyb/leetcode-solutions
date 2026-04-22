/*
 * Problem: 1901. Find a Peak Element II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-a-peak-element-ii/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int l=0;
        int r=mat.length-1;
        while (l<r) {
            int mid=(l+r)>>>1;
            int idx=getMax(mat,mid);
            int left=mid>0?mat[mid-1][idx]:-1;
            int right=mid<mat.length-1?mat[mid+1][idx]:-1;
            if (mat[mid][idx]<left) {
                r=mid;
            } else if (mat[mid][idx]<right) {
                l=mid+1;
            } else {
                return new int[] {mid,idx};
            }
        }
         return new int[] {l,getMax(mat,l)};
    }

    public int getMax(int[][] mat, int i) {
        int res=0;
        for (int j=1;j<mat[0].length;j++) {
            if (mat[i][j]>mat[i][res]) res=j;
        }
        return res;
    }
}
