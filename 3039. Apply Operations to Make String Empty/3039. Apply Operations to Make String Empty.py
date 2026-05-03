#
# Problem: 3039. Apply Operations to Make String Empty
# Difficulty: Medium
# Link: https://leetcode.com/problems/apply-operations-to-make-string-empty/
# Language: python3
# Date: 2026-05-03


class Solution:
    def lastNonEmptyString(self, s: str) -> str:
        freq = Counter(s)
        max_count = max(freq.values())
        st = set()
        res = []
        for i in range(len(s) - 1, -1, -1):
            if freq[s[i]] == max_count and s[i] not in st:
                res.append(s[i])
                st.add(s[i])
        return ''.join(reversed(res))

