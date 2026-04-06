/*
 * Problem: 661. Image Smoother
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/image-smoother/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int xL=img.length;
        int yL=img[0].length;
        int[][] res=new int[xL][yL];
        int[] dirts={-1,0,1};
        int tmp=0;
        int n=0;

        for (int i=0;i<xL;i++) {
            for (int j=0;j<yL;j++) {
                tmp=0;
                n=0;
                for (int d1:dirts){
                    for (int d2:dirts){
                        int x=i+d1;
                        int y=j+d2;
                        if (x<0||x>=xL||y<0||y>=yL) continue;
                        tmp+=img[x][y];
                        n++;
                    }
                }
                res[i][j]=tmp/n;

            }
        }
        return res;
        
    }
}
