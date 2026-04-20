#
# Problem: 1737. Change Minimum Characters to Satisfy One of Three Conditions
# Difficulty: Medium
# Link: https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/
# Language: python3
# Date: 2026-04-20


class Solution:
    def minCharacters(self, a: str, b: str) -> int:
        count_a = Counter(a)
        count_b = Counter(b)
        len_a = len(a)
        len_b = len(b)
        res = len_a - max(count_a.values()) + len_b - max(count_b.values())
        sum_1 = len_a
        sum_2 = len_b
        for i in string.ascii_lowercase:
            sum_1 -= count_a[i]
            sum_2 -= count_b[i]
            if i == "a":
                res = min(
                    res,
                    sum_1 + count_b[i],
                    sum_2 + count_a[i],
                )
            elif i == "z":
                res = min(
                    res,
                    sum_1 + count_a[i],
                    sum_2 + count_b[i],
                )
            else:
                res = min(
                    res,
                    sum_1 + min(count_a[i], count_b[i]),
                    sum_2 + min(count_a[i], count_b[i]),
                )
            sum_1 += count_b[i]
            sum_2 += count_a[i]
        return res

