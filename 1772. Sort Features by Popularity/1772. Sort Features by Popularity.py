#
# Problem: 1772. Sort Features by Popularity
# Difficulty: Medium
# Link: https://leetcode.com/problems/sort-features-by-popularity/
# Language: python3
# Date: 2026-04-20


class Solution:
    def sortFeatures(self, features: List[str], responses: List[str]) -> List[str]:
        arr = []
        mp = {}
        for i in range(len(features)):
            arr.append([features[i], 0, i])
            mp[features[i]] = i
        for response in responses:
            st_st = set()
            strs = response.split(" ")
            for st in strs:
                if st not in st_st:
                    st_st.add(st)
                    if st in mp:
                        arr[mp[st]][1] += 1
        arr.sort(key=lambda x: (-x[1], x[2]))
        res = []
        for row in arr:
            res.append(row[0])
        return res

