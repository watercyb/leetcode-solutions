#
# Problem: 3207. Maximum Points After Enemy Battles
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-points-after-enemy-battles/
# Language: python3
# Date: 2026-05-05


class Solution:
    def maximumPoints(self, enemyEnergies: List[int], currentEnergy: int) -> int:
        en_min = min(enemyEnergies)
        if currentEnergy < en_min:
            return 0
        return (sum(enemyEnergies) + currentEnergy) // en_min - 1

