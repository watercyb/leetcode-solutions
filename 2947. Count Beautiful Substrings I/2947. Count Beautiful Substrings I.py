#
# Problem: 2947. Count Beautiful Substrings I
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-beautiful-substrings-i/
# Language: python3
# Date: 2026-05-02


class Solution:
    def beautifulSubstrings(self, s: str, k: int) -> int:
        st = set("aeiou")
        mp = {(0, 0): 1}
        res = 0
        count = 0
        diff = 0
        for mod in range(1, k + 1):
            if mod * mod % k == 0:
                break
        for i in range(len(s)):
            if s[i] in st:
                count += 1
                diff += 1
            else:
                diff -= 1
            key = (diff, count % mod)
            val = mp.get(key, 0)
            res += val
            mp[key] = val + 1
        return res

