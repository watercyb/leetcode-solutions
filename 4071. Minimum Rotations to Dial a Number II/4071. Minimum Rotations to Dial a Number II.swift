/*
 * Problem: 4071. Minimum Rotations to Dial a Number II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-rotations-to-dial-a-number-ii/
 * Language: swift
 * Date: 2026-10-05
 */

class Solution {
    func minRotations(_ n: Int, _ s: String) -> Int {
        let chrs = Array(s)
        var lefts = Array(repeating: 0, count: n)
        var current: Character = "0"
        var sum=0
        for i in 0..<n {
            sum+=getStep(current, chrs[i])
            lefts[i]=sum
            current=chrs[i]
        }
        var res=sum
        let last=chrs[n-1]
        current = last
        sum=0
        for i in (0..<n).reversed() {
            sum+=getStep(current, chrs[i])
            let left=i>0 ? lefts[i-1]+getStep(chrs[i-1], last) : getStep("0", last)
            res=min(res, sum+left)
            current=chrs[i]
        }
        return res
    }

    func getStep(_ a: Character, _ b: Character) -> Int {
        let diff=abs(Int(a.asciiValue ?? 0)-Int(b.asciiValue ?? 0))
        return min(diff, 10-diff);
    }
}
