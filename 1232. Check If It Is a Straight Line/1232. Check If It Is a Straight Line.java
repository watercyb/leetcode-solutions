/*
 * Problem: 1232. Check If It Is a Straight Line
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-it-is-a-straight-line/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
              if (coordinates.length == 2) {
         return true;
      }
      int[][] c = new int[coordinates.length-1][2];
      c[0][0] = coordinates[1][0] - coordinates[0][0];
      c[0][1] = coordinates[1][1] - coordinates[0][1];
      int n = 0;
      boolean a = true;
      if (c[0][0] == 0&&c[0][1] == 0) {a = false;}
      if (c[0][0] != 0) {n = 1;}
      for (int i = 1; i < coordinates.length - 1; i++) {
         c[i][0] = coordinates[i+1][0] - coordinates[i][0];
         c[i][1] = coordinates[i+1][1] - coordinates[i][1];
        if (c[i][0] == 0&&c[i][1] != 0&&n==1) { return false;}
        if (c[i][0] != 0&&n==0) { return false;}
        if (c[i][0] != 0&&n==1) { if ((double)(c[i][1])/(double)(c[i][0])==(double)(c[i-1][1])/(double)(c[i-1][0])){a=true;}else{return false;}}
   }
      return a;
    }
}
