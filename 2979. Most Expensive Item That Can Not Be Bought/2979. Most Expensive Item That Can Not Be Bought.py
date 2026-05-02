#
# Problem: 2979. Most Expensive Item That Can Not Be Bought
# Difficulty: Medium
# Link: https://leetcode.com/problems/most-expensive-item-that-can-not-be-bought/
# Language: python3
# Date: 2026-05-02


class Solution:
    def mostExpensiveItem(self, primeOne: int, primeTwo: int) -> int:
        return primeOne * primeTwo - primeOne - primeTwo

