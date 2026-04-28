#
# Problem: 2545. Sort the Students by Their Kth Score
# Difficulty: Medium
# Link: https://leetcode.com/problems/sort-the-students-by-their-kth-score/
# Language: python3
# Date: 2026-04-28


class Solution:
    def sortTheStudents(self, score: List[List[int]], k: int) -> List[List[int]]:
        score.sort(key=lambda row: -row[k])
        return score

