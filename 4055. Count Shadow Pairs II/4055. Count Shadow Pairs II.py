#
# Problem: 4055. Count Shadow Pairs II
# Difficulty: Hard
# Link: https://leetcode.com/problems/count-shadow-pairs-ii/
# Language: python3
# Date: 2026-09-14


class Solution:
    def shadowPairs(self, nums: list[int]) -> int:
        nums_sort = list(set(nums))
        nums_sort.sort()
        mp = {}
        for num in nums_sort:
            mp[num] = len(mp)
        self.res = 0
        self.n = len(mp) + 1
        self.bit = [] * self.n
        arr = []
        for i in range(len(nums)):
            arr.append([mp[nums[i]], i])
        self.sort(arr, 0, len(arr) - 1)
        return self.res

    def sort(self, arr: list[list[int]], l: int, r: int):
        if l == r:
            return
        mid = (l + r) // 2
        self.sort(arr, l, mid)
        self.sort(arr, mid + 1, r)
        temp = []
        left_idx = l
        right_idx = mid + 1
        mq_left = []
        mq_right = []
        left_min_max = [1000000001] * (mid - l + 1)

        for i in range(mid, l - 1, -1):
            while len(mq_left) > 0 and mq_left[-1][1] < arr[i][1]:
                mq_left.pop(-1)
            if len(mq_left) > 0:
                left_min_max[i - l] = mq_left[-1][0]
            mq_left.append(arr[i])

        bit_count = 0
        self.bit = [0] * self.n
        pq = []
        j = l

        for i in range(mid + 1, r + 1):
            while len(mq_right) > 0 and mq_right[-1][1] > arr[i][1]:
                mq_right.pop(-1)
            max_val = 0
            if len(mq_right) > 0:
                max_val = mq_right[-1][0]
            mq_right.append(arr[i])
            while j <= mid and arr[j][0] < arr[i][0]:
                self.insert(arr[j][0], 1)
                bit_count += 1
                heapq.heappush(pq, (left_min_max[j - l], arr[j][0]))
                j += 1
            while len(pq) > 0 and pq[0][0] < arr[i][0]:
                _, num = heapq.heappop(pq)
                self.insert(num, -1)
                bit_count -= 1
            cnt = self.get(max_val - 1)
            self.res += bit_count - cnt

        while left_idx <= mid and right_idx <= r:
            if arr[left_idx][0] < arr[right_idx][0]:
                temp.append(arr[left_idx])
                left_idx += 1
            else:
                temp.append(arr[right_idx])
                right_idx += 1
        while left_idx <= mid:
            temp.append(arr[left_idx])
            left_idx += 1
        while right_idx <= r:
            temp.append(arr[right_idx])
            right_idx += 1
        for pair in temp:
            arr[l] = pair
            l += 1

    def insert(self, i: int, num: int):
        i += 1
        while i < len(self.bit):
            self.bit[i] += num
            i += i & -i

    def get(self, i: int) -> int:
        i += 1
        res = 0
        while i > 0:
            res += self.bit[i]
            i -= i & -i
        return res

