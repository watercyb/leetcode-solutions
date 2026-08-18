/*
 * Problem: 4022. K-th Digit in Infinite String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/k-th-digit-in-infinite-string/
 * Language: kotlin
 * Date: 2026-08-18
 */

class Solution {
    fun kthDigit(k: Long): Int {
        var l: Long=0
        var r: Long=k
        while (l<r) {
            val mid=(l+r)/2
            if (chk(mid)>=k) {
                r=mid
            } else {
                l=mid+1
            }
        }
        var count=chk(l);
        var num=l;
        if (((l / 10) and 1).toInt() != 0) {
            num = num / 10 * 10 + (9 - num % 10)
        }
        while (count>k) {
            num/=10;
            count--;
        }
        return (num%10).toInt()
    }

    fun chk(mid: Long): Long {
        var len=1
        var prv: Long=1
        var n: Long=10
        var res: Long=0
        while (n<=mid) {
            res+=(n-prv)*len
            len++
            prv=n
            n*=10
        }
        res+=len*(mid-prv+1)
        return res
    }
}
