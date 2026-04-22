/*
 * Problem: 1943. Describe the Painting
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/describe-the-painting/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        int max=-1;
        int min=100001;
        for (int[] segment:segments) {
            if (segment[0]<min) min=segment[0];
            if (segment[1]>max) max=segment[1];
        }
        List<List<Long>> res = new ArrayList<>();
        long[] arr=new long[max+1];
        boolean[] b=new boolean[max+1];
        for (int[] segment:segments) {
            arr[segment[0]]+=segment[2];
            arr[segment[1]]-=segment[2];
            b[segment[1]]=true;
        }
        int start=-1;
        long tmp=0;
        for (int i=min;i<=max;i++) {
            if (tmp>0&&(arr[i]!=0||b[i])) {
                res.add(Arrays.asList(new Long[] {(long)start,(long)i,(long)tmp}));
                start=-1;
            }
            tmp+=arr[i];
            if (tmp>0&&start==-1) start=i;
        }
        return res;
    }
}
