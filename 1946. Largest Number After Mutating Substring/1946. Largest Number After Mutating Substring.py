#
# Problem: 1946. Largest Number After Mutating Substring
# Difficulty: Medium
# Link: https://leetcode.com/problems/largest-number-after-mutating-substring/
# Language: python3
# Date: 2026-04-22


class Solution:
    def maximumNumber(self, num: str, change: List[int]) -> str:
        res = []
        isChanged = False
        for i in range(len(num)):
            idx = int(num[i])
            if not isChanged:
                if idx >= change[idx]:
                    res.append(num[i])
                else:
                    isChanged = True
                    res.append(str(change[idx]))
            else:
                if idx <= change[idx]:
                    res.append(str(change[idx]))
                else:
                    return "".join(res) + num[i:]
        return "".join(res)

