/*
 * Problem: 3997. Count Dominant Nodes in a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-dominant-nodes-in-a-binary-tree/
 * Language: kotlin
 * Date: 2026-07-19
 */

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun countDominantNodes(root: TreeNode?): Int {
        val res=dfs(root)
        return res[1]
    }

    fun dfs(node: TreeNode?): IntArray {
        if (node==null) return intArrayOf(0, 0)
        var max=0
        var count=0
        var pair=dfs(node.left)
        max=Math.max(max, pair[0])
        count+=pair[1]
        pair=dfs(node.right)
        max=Math.max(max, pair[0])
        count+=pair[1]
        if (max<=node.`val`) {
            count++
            max=node.`val`
        }
        return intArrayOf(max, count)
    }
}
