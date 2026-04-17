#
# Problem: 1418. Display Table of Food Orders in a Restaurant
# Difficulty: Medium
# Link: https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
# Language: python3
# Date: 2026-04-17


class Solution:
    def displayTable(self, orders: List[List[str]]) -> List[List[str]]:
        tables = [None] * 501
        st = set()
        cnt = 0
        for order in orders:
            idx = int(order[1])
            food = order[2]
            if tables[idx] is None:
                tables[idx] = [food]
                cnt += 1
            else:
                tables[idx].append(food)
            st.add(food)
        li = list(st)
        li.sort()
        mp = {}
        for i in range(len(li)):
            mp[li[i]] = i + 1
        res = [[0] * (len(li) + 1) for _ in range(cnt + 1)]
        res[0][0] = "Table"
        for i in range(1, len(li) + 1):
            res[0][i] = li[i - 1]
        idx = 1
        for i in range(len(tables)):
            if tables[i] is None:
                continue
            res[idx][0] = str(i)
            for food in tables[i]:
                res[idx][mp[food]] += 1
            idx += 1
        for i in range(1, len(res)):
            for j in range(1, len(li) + 1):
                res[i][j] = str(res[i][j])
        return res

