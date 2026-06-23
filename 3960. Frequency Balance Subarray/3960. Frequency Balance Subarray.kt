/*
 * Problem: 3960. Frequency Balance Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/frequency-balance-subarray/
 * Language: kotlin
 * Date: 2026-06-23
 */

class Solution {
    fun getLength(nums: IntArray): Int {
        var res=0
        val hm=HashMap<Int,Int>()
        for (i in 0 until nums.size) {
            if (hm.containsKey(nums[i])) {
                nums[i]=hm[nums[i]]!!
            } else {
                val idx=hm.size
                hm.put(nums[i],idx)
                nums[i]=idx
            }
        }
        for (i in 0 until nums.size) {
            val counts = IntArray(hm.size)
            val freqs = IntArray(nums.size+1)
            var max=0
            var count=0
            for (j in i until nums.size) {
                val c=counts[nums[j]]++
                if (c==0) count++;
                freqs[c]--
                freqs[c+1]++
                max=max(max, c+1)
                if (res>=j-i+1) continue
                if (count==1 && j-i+1>res)
                    res=j-i+1
                if (max%2==0 && freqs[max/2]!=0 && freqs[max]+freqs[max/2]==count && j-i+1>res)
                    res=j-i+1
            }
        }
        return res
    }
}
