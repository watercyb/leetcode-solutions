#
# Problem: 2513. Minimize the Maximum of Two Arrays
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimize-the-maximum-of-two-arrays/
# Language: python3
# Date: 2026-04-28


class Solution:
    def minimizeSet(
        self, divisor1: int, divisor2: int, uniqueCnt1: int, uniqueCnt2: int
    ) -> int:
        def get(u: int, d: int) -> int:
            res = u
            while res - res // d < u:
                res = u + res // d
            return res

        return max(
            get(uniqueCnt1, divisor1),
            get(uniqueCnt2, divisor2),
            get(uniqueCnt1 + uniqueCnt2, math.lcm(divisor1, divisor2)),
        )

