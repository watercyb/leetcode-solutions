/*
 * Problem: 3858. Minimum Bitwise OR From Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-bitwise-or-from-grid/
 * Language: kotlin
 * Date: 2026-05-11
 */

class Solution {
    fun minimumOR(grid: Array<IntArray>): Int {
        var l=0;
        var r=(1 shl 17)-1
        var res=r
        while (l<r) {
            val mid=(l+r) ushr 1
            if (chk(grid,mid)) {
                r=mid
                res=r
            } else {
                l=mid+1
            }
        }
        return res
    }

    fun chk(grid: Array<IntArray>, mid:Int):Boolean {
        for (row in grid) {
            if (!chkRow(row,mid)) return false
        }
        return true
    }

    fun chkRow(row: IntArray, mid:Int):Boolean {
        for (num in row) {
            if ((num or mid)==mid) return true
        }
        return false
    }
}
