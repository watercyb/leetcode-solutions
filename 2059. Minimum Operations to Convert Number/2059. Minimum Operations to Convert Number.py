#
# Problem: 2059. Minimum Operations to Convert Number
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-operations-to-convert-number/
# Language: python3
# Date: 2026-04-23


class Solution:
    def minimumOperations(self, nums: List[int], start: int, goal: int) -> int:
        dp = [1001] * 1001
        dp[start] = 0
        dq = deque()
        dq.append(start)
        stp = 1
        while len(dq) > 0:
            for _ in range(len(dq)):
                current = dq.popleft()
                for num in nums:
                    next_idx = current + num
                    if next_idx == goal:
                        return stp
                    if next_idx >= 0 and next_idx <= 1000 and dp[next_idx] == 1001:
                        dp[next_idx] = stp
                        dq.append(next_idx)
                    next_idx = current - num
                    if next_idx == goal:
                        return stp
                    if next_idx >= 0 and next_idx <= 1000 and dp[next_idx] == 1001:
                        dp[next_idx] = stp
                        dq.append(next_idx)
                    next_idx = current ^ num
                    if next_idx == goal:
                        return stp
                    if next_idx >= 0 and next_idx <= 1000 and dp[next_idx] == 1001:
                        dp[next_idx] = stp
                        dq.append(next_idx)
            stp += 1
        return -1

