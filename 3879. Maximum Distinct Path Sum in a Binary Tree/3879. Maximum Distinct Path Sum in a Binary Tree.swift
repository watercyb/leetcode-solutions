/*
 * Problem: 3879. Maximum Distinct Path Sum in a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-distinct-path-sum-in-a-binary-tree/
 * Language: swift
 * Date: 2026-03-26
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
 */
class Solution {
    func maxSum(_ root: TreeNode?) -> Int {
        var links: [Int: [Int]] = [:]
        var values: [Int: Int] = [:]
        dfs_links(root!, -1, &links, &values)
        var res = -100000000;
        for (k, v) in links {
            var seen: Set<Int> = []
            res=max(res, dfs(&links, &values, &seen, k, -1))
        }
        return res
    }

    var idx=0;

    func dfs_links(_ node: TreeNode, _ prv: Int, _ links: inout [Int: [Int]], _ values: inout [Int: Int]) -> Int{
        var arr: [Int]=[]
        let currentIdx=idx
        idx+=1
        if prv != -1 {
            arr.append(prv)
        }
        if node.left != nil {
            arr.append(dfs_links(node.left!, currentIdx, &links, &values))
        }
        if node.right != nil {
            arr.append(dfs_links(node.right!, currentIdx, &links, &values)) 
        }
        links[currentIdx]=arr
        values[currentIdx]=node.val
        return currentIdx
    }

    func dfs(_ links: inout [Int: [Int]], _ values: inout [Int: Int], _ seen: inout Set<Int>, _ i: Int, _ prv: Int) -> Int{
        var res = 0
        let link=links[i]!
        let val=values[i]!
        if seen.contains(val) {
            return -100000000
        }
        seen.insert(val)
        for next in link {
            if next != prv {
                res=max(res, dfs(&links, &values, &seen, next, i))
            }
        }
        seen.remove(val)
        return max(res, 0)+val
    }
}
