#
# Problem: 970. Powerful Integers
# Difficulty: Medium
# Link: https://leetcode.com/problems/powerful-integers/
# Language: python3
# Date: 2026-04-10


class Solution:
    def powerfulIntegers(self, x: int, y: int, bound: int) -> List[int]:
        st = set()
        a = 1
        while a < bound:
            b = 1
            while a + b <= bound:
                st.add(a + b)
                if y == 1:
                    break
                b *= y
            if x == 1:
                break
            a *= x
        return list(st)

