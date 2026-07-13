#
# Problem: 3991. Sort Array Using Prefix Reversals
# Difficulty: Medium
# Link: https://leetcode.com/problems/sort-array-using-prefix-reversals/
# Language: python3
# Date: 2026-07-13


class Solution:
    def sortArray(self, nums: List[int], pre: List[int]) -> int:
        target = tuple(range(len(nums)))
        t = tuple(nums)
        if t == target:
            return 0
        st = set()
        dq = deque()
        dq.append(t)
        stp = 1
        while len(dq) > 0:
            lim = len(dq)
            for _ in range(lim):
                current = dq.popleft()
                for n in pre:
                    next_arr = current[:n][::-1] + current[n:]
                    t = tuple(next_arr)
                    if t == target:
                        return stp
                    if t not in st:
                        st.add(t)
                        dq.append(t)
            stp += 1
        return -1

