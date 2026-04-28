#
# Problem: 2564. Substring XOR Queries
# Difficulty: Medium
# Link: https://leetcode.com/problems/substring-xor-queries/
# Language: python3
# Date: 2026-04-28


class Solution:
    def substringXorQueries(self, s: str, queries: List[List[int]]) -> List[List[int]]:
        mp = {}
        max_num = 0
        for i in range(len(queries)):
            target = queries[i][0] ^ queries[i][1]
            max_num = max(max_num, target)
        max_len = max_num.bit_length()
        for i in range(len(s)):
            if s[i] == "0":
                if 0 not in mp:
                    mp[0] = [i, i]
                continue
            num = 0
            for j in range(i, min(i + max_len, len(s))):
                num = (num << 1) | (ord(s[j]) - ord("0"))
                if num not in mp:
                    mp[num] = [i, j]
        res = []
        for i in range(len(queries)):
            target = queries[i][0] ^ queries[i][1]
            res.append(mp.get(target, [-1, -1]))
        return res

