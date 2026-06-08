/*
 * Problem: 3955. Valid Binary Strings With Cost Limit
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/valid-binary-strings-with-cost-limit/
 * Language: kotlin
 * Date: 2026-06-08
 */

class Solution {
    fun generateValidStrings(n: Int, k: Int): List<String> {
        val list=arrayListOf<String>();
        dfs(list, StringBuilder(), 0, false, n, k)
        return list;
    }

    fun dfs(list: MutableList<String>, sb: StringBuilder, i: Int, prv: Boolean, n: Int, k: Int) {
        if (i==n) {
            list.add(sb.toString())
            return
        }
        if (!prv&&k>=i) {
            sb.append('1')
            dfs(list,sb,i+1,true,n,k-i)
            sb.setLength(sb.length-1)
        }
        sb.append('0')
        dfs(list,sb,i+1,false,n,k)
        sb.setLength(sb.length-1)
    }
}
