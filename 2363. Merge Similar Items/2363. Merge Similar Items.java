/*
 * Problem: 2363. Merge Similar Items
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/merge-similar-items/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] counts=new int[1001];
        for (int[] arr:items1) {
            counts[arr[0]]+=arr[1];
        }
        for (int[] arr:items2) {
            counts[arr[0]]+=arr[1];
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<1001;i++) {
            if (counts[i]>0) res.add(Arrays.asList(new Integer[] {i,counts[i]}));
        }
        return res;
    }
}
