/*
 * Problem: 3853. Merge Close Characters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/merge-close-characters/
 * Language: kotlin
 * Date: 2026-05-11
 */

class Solution {
    fun mergeCharacters(s: String, k: Int): String {
        val arr=IntArray(26)
        Arrays.fill(arr,-k-1)
        val SB=StringBuilder()
        var idx=0;
        for (i in 0 until s.length) {
            if (idx-arr[s[i]-'a']<=k)
                continue;
            arr[s[i]-'a']=idx
            SB.append(s[i])
            idx++
        }
        return SB.toString()
    }
}
