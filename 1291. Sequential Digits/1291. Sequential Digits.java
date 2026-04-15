/*
 * Problem: 1291. Sequential Digits
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sequential-digits/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    static int[] arr;

    public List<Integer> sequentialDigits(int low, int high) {
        if (arr == null) {
            arr = new int[45];
            int idx=0;
            for (int i = 1; i < 10; i++) {
                for (int j = i; j < 10; j++) {
                    if (i==1) {
                        arr[idx++]=j;
                    } else {
                        arr[idx] = arr[idx++ - 11 + i] * 10 + j;
                    }
                }
            }
        }
        int l=Arrays.binarySearch(arr,low);
        if (l<0) l=-l-1;
        int r=Arrays.binarySearch(arr,high);
        if (r<0) r=-r-2;
        List<Integer> res=new ArrayList<>();
        for (int i=l;i<=r;i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
