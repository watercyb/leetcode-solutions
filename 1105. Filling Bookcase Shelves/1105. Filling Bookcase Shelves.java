/*
 * Problem: 1105. Filling Bookcase Shelves
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/filling-bookcase-shelves/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] DP = new int[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            int max = 0;
            int width = shelfWidth;
            DP[i + 1] = Integer.MAX_VALUE;
            int j = i;
            while (j >= 0 && width - books[j][0] >= 0) {
                width -= books[j][0];
                max = Math.max(books[j][1], max);
                DP[i + 1] = Math.min(DP[j] + max, DP[i + 1]);
                j--;
            }
        }
        return DP[books.length];
    }
}
