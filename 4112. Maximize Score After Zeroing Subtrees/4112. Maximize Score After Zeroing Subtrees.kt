/*
 * Problem: 4112. Maximize Score After Zeroing Subtrees
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-score-after-zeroing-subtrees/
 * Language: kotlin
 * Date: 2026-11-18
 */

class Solution {
    fun maxScore(parent: IntArray, op: IntArray, score: IntArray): Int {
        val links = Array(parent.size) { mutableListOf<Int>() }
        for (i in 1 until parent.size) {
            links[parent[i]].add(i)
        }
        return dfs(links,op,score, 0,-1)
    }

    fun dfs(links: Array<MutableList<Int>>, op: IntArray, score: IntArray, i: Int, prv: Int): Int {
        if (links[i].size==0) return score[i]
        var res=score[i]
        var min=Int.MAX_VALUE
        for (next in links[i]) {
            if (next==prv) continue
            val re=dfs(links,op, score, next, i)
            res+=re
            min=minOf(min, re)
        }
        if (op[i]==0) {
            if (min<0) res-=min
        } else {
            res-=min
        }
        return res;
    }
}
