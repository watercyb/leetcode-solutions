/*
 * Problem: 3890. Integers With Multiple Sum of Two Cubes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/integers-with-multiple-sum-of-two-cubes/
 * Language: kotlin
 * Date: 2026-04-07
 */

class Solution {
    fun findGoodIntegers(n: Int): List<Int> {
        val lim=Math.cbrt(n.toDouble()).toInt()
        val hs=HashSet<Int>()
        val hs1=HashSet<Int>()
        for (i in 0..lim) {
            for (j in i..lim) {
                val num=i*i*i+j*j*j
                if (num>n) break;
                if (!hs.add(num)) hs1.add(num)
            }
        }
        val res=ArrayList<Int>(hs1)
        res.sort()
        return res
    }
}
