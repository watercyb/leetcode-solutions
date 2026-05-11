/*
 * Problem: 3860. Unique Email Groups
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unique-email-groups/
 * Language: kotlin
 * Date: 2026-05-11
 */

class Solution {
    fun uniqueEmailGroups(emails: Array<String>): Int {
        val HS=HashSet<String>()
        for (email in emails) {
            HS.add(getName(email))
        }
        return HS.size
    }

    fun getName(email:String): String {
        val SB=StringBuilder()
        var idx=0
        while (idx<email.length) {
            if (email[idx]=='@') {
                SB.append(email.substring(idx).lowercase())
                return SB.toString()
            } else if (email[idx]=='+') {
                while (email[idx]!='@') {
                    idx++
                }
                SB.append(email.substring(idx).lowercase())
                return SB.toString()
            } else if (email[idx]!='.') {
                SB.append(email[idx].lowercase())
            }
            idx++
        }
        return SB.toString()
    }
}
