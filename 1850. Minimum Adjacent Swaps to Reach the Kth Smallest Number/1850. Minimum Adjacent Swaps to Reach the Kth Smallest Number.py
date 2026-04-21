#
# Problem: 1850. Minimum Adjacent Swaps to Reach the Kth Smallest Number
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/
# Language: python3
# Date: 2026-04-21


class Solution:
    def getMinSwaps(self, num: str, k: int) -> int:
        arr = [ord(c) - ord("0") for c in num]
        arr_ori = arr[:]

        for _ in range(k):
            next_permutation(arr)

        pos = [[] for _ in range(10)]
        for i in range(len(arr) - 1, -1, -1):
            pos[arr[i]].append(i)

        res = 0
        for i in range(len(arr)):
            if arr_ori[i] != arr[i]:
                for j in range(i + 1, len(arr)):
                    if arr_ori[j] == arr[i]:
                        for l in range(j, i, -1):
                            arr_ori[l] = arr_ori[l - 1]
                        arr_ori[i] = arr[i]
                        res += j - i
                        break
        return res


def swap(arr: list, i: int, j: int) -> None:
    arr[i], arr[j] = arr[j], arr[i]


def next_permutation(arr: list) -> None:
    idx = len(arr) - 2
    while arr[idx] >= arr[idx + 1]:
        idx -= 1
    idx1 = len(arr) - 1
    while arr[idx1] <= arr[idx]:
        idx1 -= 1
    swap(arr, idx, idx1)
    arr[idx + 1 :] = reversed(arr[idx + 1 :])

