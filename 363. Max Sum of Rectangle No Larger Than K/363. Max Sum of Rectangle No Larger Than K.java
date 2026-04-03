/*
 * Problem: 363. Max Sum of Rectangle No Larger Than K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] m=new int[matrix.length+1][matrix[0].length+1];
        int max=Integer.MIN_VALUE;
        for (int i=0;i<matrix.length;i++) {
            int tmp=0;
            for (int j=0;j<matrix[0].length;j++) {
                tmp+=matrix[i][j];
                m[i+1][j+1]=m[i][j+1]+tmp;
                if (matrix[i][j]==k) return matrix[i][j];
            }
        }

        for (int r1=0;r1<matrix.length;r1++) {
            for (int c1=0;c1<matrix[0].length;c1++) {
                for (int r2=r1;r2<matrix.length;r2++) {
                    int r21=r2+1;
                    for (int c2=c1;c2<matrix[0].length;c2++) {
                        int c21=c2+1;
                        int tmp=m[r21][c21]-m[r1][c21]-m[r21][c1]+m[r1][c1];
                        if (tmp==k) {
                            return tmp;
                        } else if (tmp< k && tmp > max) max = tmp;
                    }
                }
            }
        }

        return max;
        
    }
}

