#
# Problem: 2244. Minimum Rounds to Complete All Tasks
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
# Language: python3
# Date: 2026-04-25


class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        counts = Counter(tasks)
        res = 0
        for count in counts.values():
            if count == 1:
                return -1
            if count % 3 != 0:
                res += count // 3 + 1
            else:
                res += count // 3
        return res

