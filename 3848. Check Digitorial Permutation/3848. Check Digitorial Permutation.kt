/*
 * Problem: 3848. Check Digitorial Permutation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-digitorial-permutation/
 * Language: kotlin
 * Date: 2026-07-18
 */

class Solution {
    fun isDigitorialPermutation(n: Int): Boolean {
        val facts=IntArray(10)
        facts[0]=1
        var fact=1
        for (i in 1 until 10) {
            fact*=i
            facts[i]=fact
        }
        val counts=IntArray(10)
        var sum=0
        var num=n
        while (num>0) {
            val digit=num%10
            sum+=facts[digit]
            counts[digit]++
            num/=10
        }
        while (sum>0) {
            counts[sum%10]--
            sum/=10
        }
        for (count in counts) {
            if (count!=0) return false
        }
        return true
    }
}
