#
# Problem: 1306. Jump Game III
# Difficulty: Medium
# Link: https://leetcode.com/problems/jump-game-iii/
# Language: python3
# Date: 2026-04-16


class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        seens = [False for _ in range(len(arr))]
        dq = deque()
        dq.append(start)

        while dq:
            idx = dq.popleft()
            left = idx - arr[idx]
            right = idx + arr[idx]
            if left >= 0 and not seens[left]:
                if arr[left] == 0:
                    return True
                seens[left] = True
                dq.append(left)
            if right < len(arr) and not seens[right]:
                if arr[right] == 0:
                    return True
                seens[right] = True
                dq.append(right)

        return False

