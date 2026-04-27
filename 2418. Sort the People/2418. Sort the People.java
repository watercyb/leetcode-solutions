/*
 * Problem: 2418. Sort the People
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sort-the-people/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        sep(names,heights,0,names.length-1);
        return names;
    }

    public void sep(String[] names, int[] heights, int l, int r) {
        if (l==r) return;
        int mid=(l+r)/2;
        sep(names,heights,l,mid);
        sep(names, heights, mid+1, r);
        merge(names, heights,l,r);
    }

    public void merge(String[] names, int[] heights, int l, int r) {
        int mid=(l+r)/2;
        String[] strs=new String[r-l+1];
        int[] arr=new int[r-l+1];
        int i=l;
        int j=mid+1;
        int idx=0;
        while (i<=mid&&j<=r) {
            if (heights[i]<heights[j]) {
                arr[idx]=heights[j];
                strs[idx]=names[j];
                j++;
            } else {
                arr[idx]=heights[i];
                strs[idx]=names[i];
                i++;
            }
            idx++;
        }
         while (i<=mid) {
            arr[idx]=heights[i];
                strs[idx]=names[i];
                i++;
            idx++;
        }
        while (j<=r) {
           arr[idx]=heights[j];
                strs[idx]=names[j];
                j++;
            idx++;
        }
        idx=0;
        for (int k=l;k<=r;k++) {
            heights[k]=arr[idx];
            names[k]=strs[idx];
            idx++;
        }
    }
}
