/*
 * Problem: 4015. Weighted Sum of a Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/weighted-sum-of-a-tree/
 * Language: kotlin
 * Date: 2026-08-10
 */

class Solution {
    fun weightedSum(parent: IntArray, nums: IntArray): Long {
        val links=mutableListOf<MutableList<Int>>()
        for (i in 0 until parent.size) {
            links.add(mutableListOf<Int>())
        }
        for (i in 1 until parent.size) {
            links[parent[i]].add(i)
        }
        val h=dfsHeight(links, 0)
        return dfsSum(links, nums, 0, h)
    }

    fun dfsHeight(links: List<List<Int>>, i: Int): Int {
        var res=0
        for (next in links[i]) {
            res=Math.max(res, dfsHeight(links, next))
        }
        return res+1
    }

    fun dfsSum(links: List<List<Int>>, nums: IntArray, i: Int, h: Int): Long {
        var res=nums[i].toLong()*h
        for (next in links[i]) {
            res+=dfsSum(links, nums, next, h-1)
        }
        return res
    }
}
