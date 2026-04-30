/*
 * Problem: 2782. Number of Unique Categories
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-unique-categories/
 * Language: java
 * Date: 2026-04-30
 */

/**
 * Definition for a category handler.
 * class CategoryHandler {
 * public CategoryHandler(int[] categories);
 * public boolean haveSameCategory(int a, int b);
 * };
 */
class Solution {
    public int numberOfCategories(int n, CategoryHandler categoryHandler) {
        int res = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int idx = 0;
        while (idx < n) {
            int i = idx + 1;
            int j = idx + 1;
            while (j < n) {
                if (categoryHandler.haveSameCategory(arr[idx], arr[j])) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            res++;
            idx = i;
        }
        return res;
    }
}
