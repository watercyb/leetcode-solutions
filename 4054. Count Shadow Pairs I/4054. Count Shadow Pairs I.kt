/*
 * Problem: 4054. Count Shadow Pairs I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-shadow-pairs-i/
 * Language: kotlin
 * Date: 2026-09-15
 */

class Solution {
    fun shadowPairs(nums: IntArray): Long {
        val mq =  IntArray(nums.size)
        val counts = IntArray(nums.size)
        var idx=0
        var res: Long=0
        var count=0
        for (num in nums) {
            var c=1;
            while (idx>0&&mq[idx-1]>=num) {
                idx--
                count-=counts[idx]
                if (mq[idx]==num)
                    c+=counts[idx]
            }
            res+=count
            mq[idx]=num
            counts[idx++]=c
            count+=c
        }
        return res
    }
}
