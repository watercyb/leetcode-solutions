#
# Problem: 1899. Merge Triplets to Form Target Triplet
# Difficulty: Medium
# Link: https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
# Language: python3
# Date: 2026-04-21


class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        h = 0
        for triplet in triplets:
            if (
                triplet[0] == target[0]
                and triplet[1] <= target[1]
                and triplet[2] <= target[2]
            ):
                h |= 1
            if (
                triplet[0] <= target[0]
                and triplet[1] == target[1]
                and triplet[2] <= target[2]
            ):
                h |= 2
            if (
                triplet[0] <= target[0]
                and triplet[1] <= target[1]
                and triplet[2] == target[2]
            ):
                h |= 4
            if h == 7:
                return True
        return False

