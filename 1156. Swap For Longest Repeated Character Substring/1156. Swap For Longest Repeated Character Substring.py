#
# Problem: 1156. Swap For Longest Repeated Character Substring
# Difficulty: Medium
# Link: https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
# Language: python3
# Date: 2026-04-14


class Solution:
    def maxRepOpt1(self, text: str) -> int:
        res = 0
        for ch in string.ascii_lowercase:
            count = 0
            diff = 0
            max_len = 0
            j = 0
            for i in range(len(text)):
                if text[i] == ch:
                    count += 1
                else:
                    diff += 1
                while diff == 2:
                    if text[j] != ch:
                        diff -= 1
                    j += 1
                max_len = max(max_len, i - j + 1)
            res = max(res, min(max_len, count))
        return res

