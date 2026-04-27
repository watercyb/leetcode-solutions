#
# Problem: 2417. Closest Fair Integer
# Difficulty: Medium
# Link: https://leetcode.com/problems/closest-fair-integer/
# Language: python3
# Date: 2026-04-27


class Solution:
    def closestFair(self, n: int) -> int:
        st = str(n)
        if len(st) % 2 == 0:
            arr = []
            counts = [0, 0]
            for char in st:
                digit = ord(char) - ord("0")
                arr.append(digit)
                counts[digit % 2] += 1
            if counts[0] == counts[1]:
                return n

            def getNum() -> int:
                res = 0
                for num in arr:
                    res = res * 10 + num
                return res

            cnt = 0
            for i in range(len(arr) - 1, -1, -1):
                digit = arr[i]
                counts[digit % 2] -= 1
                while digit < 9:
                    a = digit % 2
                    b = 1 - a
                    if counts[a] == counts[b] + 1:
                        arr[i] = digit + 1
                        return getNum()
                    elif (
                        counts[a] > counts[b] + 1
                        and counts[a] - counts[b] - 1 <= cnt
                        and (cnt - counts[a] + counts[b] + 1) % 2 == 0
                    ):
                        arr[i] = digit + 1
                        diff = counts[a] - counts[b] - 1
                        cm = (cnt - diff) // 2
                        if a == 0:
                            for j in range(len(arr) - diff - cm, len(arr)):
                                arr[j] = 1
                        else:
                            for j in range(len(arr) - cm, len(arr)):
                                arr[j] = 1
                        return getNum()
                    elif (
                        counts[a] < counts[b] + 1
                        and counts[b] - counts[a] + 1 <= cnt
                        and (cnt - counts[b] + counts[a] - 1) % 2 == 0
                    ):
                        arr[i] = digit + 1
                        diff = counts[b] - counts[a] + 1
                        cm = (cnt - diff) // 2
                        if a == 1:
                            for j in range(len(arr) - diff - cm, len(arr)):
                                arr[j] = 1
                        else:
                            for j in range(len(arr) - cm, len(arr)):
                                arr[j] = 1
                        return getNum()
                    digit += 1
                cnt += 1
                arr[i] = 0
        if len(st) % 2 == 0:
            res = 1
            res *= 10 ** ((len(st) + 2) // 2)
            for i in range((len(st) + 2) // 2 - 1):
                res = res * 10 + 1
            return res
        else:
            res = 1
            res *= 10 ** ((len(st) + 1) // 2)
            for i in range((len(st) + 1) // 2 - 1):
                res = res * 10 + 1
            return res

