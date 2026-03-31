/*
 * Problem: 3881. Direction Assignments with Exactly K Visible People
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/direction-assignments-with-exactly-k-visible-people/
 * Language: swift
 * Date: 2026-03-31
 */

class Solution {
    func countVisiblePeople(_ n: Int, _ pos: Int, _ k: Int) -> Int {
        let mod:Int64=1_000_000_007
        let k=Int64(k)
        var a:Int64=2
        var b:Int64=1
        var num=Int64(n-1)
        if (k==0) {
            return 2
        }
        for i in 1...k {
            a=a*num%mod
            b=b*i%mod
            num-=1
        }
        a=a*rev(b,mod)%mod
        return Int(a)
    }

    func rev(_ a: Int64, _ mod: Int64) -> Int64 {
        if a==1 {
            return 1
        }
        return (mod-mod/a)*rev(mod%a,mod)%mod;
    }
}
