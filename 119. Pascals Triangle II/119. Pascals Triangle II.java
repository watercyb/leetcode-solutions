/*
 * Problem: 119. Pascal's Triangle II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/pascals-triangle-ii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<Integer> getRow(int rowIndex) {
        return Arrays.asList(getRows(rowIndex));
        
    }
    
    public Integer[] getRows(int rowIndex) {
        if (rowIndex==0) return new Integer[] {1};
        if (rowIndex==1) return new Integer[] {1,1};

        Integer[] Li=getRows(rowIndex-1);
        Integer[] re=new Integer[rowIndex+1];
        re[0]=1;
        re[rowIndex]=1;
        for (int i=0;i<rowIndex-1;i++) {
            re[i+1]=Li[i]+Li[i+1];
        }
        return re;
        
    }
}
