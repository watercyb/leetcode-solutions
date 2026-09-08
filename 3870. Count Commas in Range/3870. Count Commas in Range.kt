/*
 * Problem: 3870. Count Commas in Range
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-commas-in-range/?envType=daily-question&envId=2026-09-08
 * Language: kotlin
 * Date: 2026-09-08
 */

class Solution {
    fun countCommas(n: Int): Int {
        var base: Long=1000;
        var res=0;
        while (base<=n) {
            res+=n-base.toInt()+1;
            base*=1000;
        }
        return res;
    }
}
