#
# Problem: 638. Shopping Offers
# Difficulty: Medium
# Link: https://leetcode.com/problems/shopping-offers/
# Language: python3
# Date: 2026-04-06


class Solution:
    def shoppingOffers(
        self, price: List[int], special: List[List[int]], needs: List[int]
    ) -> int:
        mp = {0: 0}
        res = 10000000000
        for i in range(len(special)):
            list = []
            for k, v in mp.items():
                arr = [0] * len(needs)
                idx = len(needs) - 1
                while k > 0:
                    arr[idx] = k % 11
                    k //= 11
                    idx -= 1
                num = 1
                while True:
                    enough = True
                    over = False
                    for j in range(len(arr)):
                        if special[i][j] + arr[j] == needs[j]:
                            arr[j] = needs[j]
                        elif special[i][j] + arr[j] > needs[j]:
                            over = True
                            break
                        else:
                            arr[j] += special[i][j] * num
                            enough = False
                    if over:
                        break
                    v += special[i][-1]
                    if v >= res:
                        break
                    if enough:
                        res = min(v, res)
                    else:
                        kNext = 0
                        for j in range(len(arr)):
                            kNext = kNext * 11 + arr[j]
                        list.append([kNext, v])
            for pair in list:
                mp[pair[0]] = min(mp.get(pair[0], 10000000), pair[1])
        for k, v in mp.items():
            for i in range(len(needs) - 1, -1, -1):
                count = k % 11
                k //= 11
                if count < needs[i]:
                    v += (needs[i] - count) * price[i]
            res = min(v, res)
        return res

