/*
 * Problem: 832. Flipping an Image
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/flipping-an-image/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int j = 0;
            int k = image.length - 1;
            while (j < k) {
                int tmp = 1 - image[i][j];
                image[i][j] = 1 - image[i][k];
                image[i][k] = tmp;
                j++;
                k--;
            }
            if (j == k)
                image[i][j] = 1 - image[i][j];
        }
        return image;
    }
}
