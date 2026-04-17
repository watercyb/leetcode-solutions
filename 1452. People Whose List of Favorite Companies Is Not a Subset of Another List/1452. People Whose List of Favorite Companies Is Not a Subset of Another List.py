#
# Problem: 1452. People Whose List of Favorite Companies Is Not a Subset of Another List
# Difficulty: Medium
# Link: https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
# Language: python3
# Date: 2026-04-17


class Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        sets = []
        for i in range(len(favoriteCompanies)):
            sets.append([set(favoriteCompanies[i]), i])
        sets.sort(key=lambda x: len(x[0]))
        res = []
        for i in range(len(sets)):
            seen = False
            for j in range(len(sets)):
                if sets[i][0] < sets[j][0]:
                    seen = True
                    break
            if not seen:
                res.append(sets[i][1])
        res.sort()
        return res

