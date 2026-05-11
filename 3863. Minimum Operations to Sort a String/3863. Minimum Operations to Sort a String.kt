/*
 * Problem: 3863. Minimum Operations to Sort a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-sort-a-string/
 * Language: kotlin
 * Date: 2026-05-11
 */

class Solution {
    fun minOperations(s: String): Int {
        val chrs=s.toCharArray()
        var max=chrs[0]
        var min=chrs[0]
        var maxCount=1;
        var minCount=1;
        var isSorted=true
        for (i in 1 until chrs.size) {
            if (chrs[i] > max) {
                max = chrs[i]
                maxCount=1
            } else if (chrs[i] == max)  {
                maxCount++;
            }
            if (chrs[i] < min) {
                min = chrs[i]
                minCount=1
            } else if (chrs[i] == min)  {
                minCount++;
            }
            if (chrs[i]<chrs[i-1])
                isSorted=false
        }
        if (isSorted) return 0
        if (chrs[0]==min||chrs[chrs.size-1]==max) return 1
        if (chrs[0]==max&&chrs[chrs.size-1]==min){
            if (chrs.size==2) return -1
            if (minCount>1||maxCount>1) return 2
            return 3
        }
        return 2
    }
}
