/*
 * Problem: 733. Flood Fill
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/flood-fill/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target=image[sr][sc];
        filling(image,sr,sc,color,target);
        return image;
    }

    public void filling(int[][] image, int sr, int sc, int color, int target) {
        if (sr>=image.length || sr<0 ||sc>=image[sr].length || sc<0) return;
        if (image[sr][sc]==color) return;
        if (image[sr][sc]!=target) return;
        image[sr][sc]=color;
        filling(image,sr+1,sc,color, target);
        filling(image,sr-1,sc,color,  target);
        filling(image,sr,sc+1,color,  target);
        filling(image,sr,sc-1,color,  target);
    }
}
