/*
 * Problem: 547. Number of Provinces
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-provinces/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
   public static int findCircleNum(int[][] isConnected) {
      int[] mark = new int[isConnected.length+1];
      for (int i = 0; i < mark.length; i++) {
         mark[i] = 0;
      }
      for (int i = 0; i < isConnected.length; i++) {
         if (mark[i]==0) {
            mark[mark.length-1]++;
            findcities(isConnected, i, mark);
         }
      }
      return mark[mark.length-1];
   }

   public static int[] findcities(int[][] isConnected,int n, int[] mark) {
      for (int i = 0; i < mark.length-1; i++) {
         if (isConnected[n][i]==1 && mark[i]==0) {
            mark[i]=mark[mark.length-1];
            mark=findcities(isConnected,i, mark);
         }
      }
      return mark;
   }
}
