/*
 * Problem: 4053. Minimum Operations to Make Every Element Palindromic
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-every-element-palindromic/
 * Language: kotlin
 * Date: 2026-09-15
 */

class Solution {
    companion object {
        val lists: Array<MutableList<Int>>
        init {
            lists = Array(2) { ArrayList<Int>() }
            lists[0]=ArrayList<Int>(0)
            lists[1]=ArrayList<Int>(0)
            lists[0].add(0)
            for (i in 1..100000) {
                var num=i
                var temp=i
                if (i<=10000){
                    while (temp>0) {
                        num=num*10+temp%10
                        temp/=10
                    }
                    lists[num%2].add(num)
                }
                num=i/10
                temp=i
                while (temp>0) {
                    num=num*10+temp%10
                    temp/=10
                }
                lists[num%2].add(num)
            }
        }
    }

    fun minOperations(nums: IntArray): Long {
        lists[0].sort()
        lists[1].sort()
        var res: Long=0
        for (num in nums) {
            val idx=num%2
            var l=0
            var r=lists[idx].size
            while (l<r) {
                val mid=(r-l)/2+l
                if (lists[idx][mid]>=num) {
                    r=mid
                } else {
                    l=mid+1
                }
            }
            var min=10000000
            if (l>0) min=num-lists[idx][l-1]
            if (l<lists[idx].size) min=minOf(min, lists[idx][l]-num)
            res+=min
        }
        return res/2
    }
}
