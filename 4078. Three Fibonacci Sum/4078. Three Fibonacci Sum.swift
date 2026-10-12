/*
 * Problem: 4078. Three Fibonacci Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/three-fibonacci-sum/
 * Language: swift
 * Date: 2026-10-12
 */

class Solution {
    func threeFibonacciSum(_ n: Int) -> Bool {
        if n%2==1||n==1 {
            return false
        }
        var a=0
        var b=1
        var c=1
        var n=n/2
        while (c<n) {
            a=b
            b=c
            c=a+b
        }
        return c==n
    }
}
