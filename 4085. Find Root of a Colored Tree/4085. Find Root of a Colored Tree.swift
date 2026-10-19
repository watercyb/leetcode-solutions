/*
 * Problem: 4085. Find Root of a Colored Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-root-of-a-colored-tree/
 * Language: swift
 * Date: 2026-10-19
 */

class Solution {
    func findColoredRoot(_ edges: [[Int]], _ colors: String) -> Int {
        let arr: [Character] = Array(colors)
        var nexts: [Int] = Array(repeating: 0, count: colors.count)
        var prvs: [Int] = Array(repeating: 0, count: colors.count)
        for edge in edges {
            if arr[edge[0]]==arr[edge[1]] {
                return -1
            }
            let l=getIdx(arr[edge[0]])
            let r=getIdx(arr[edge[1]])
            if (l+1)%3==r {
                nexts[edge[0]]+=1
                prvs[edge[1]]+=1
            } else {
                prvs[edge[0]]+=1
                nexts[edge[1]]+=1
            }
        }
        var idx = -1
        for i in 0..<nexts.count {
            if nexts[i]+prvs[i] >= 4 || prvs[i]>1 {
                return -1
            } else if prvs[i]==0 {
                if idx != -1 {
                    return -1
                }
                idx=i
            }
        }
        if idx == -1 || nexts[idx]+prvs[idx]>=3  {
            return -1
        }
        return idx
    }

    func getIdx(_ color: Character) -> Int {
        if color=="R" {
            return 0
        } else if color=="B" {
            return 1
        } else {
            return 2
        }
    }
}
