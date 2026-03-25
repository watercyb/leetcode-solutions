#
# Problem: 3735. Lexicographically Smallest String After Reverse II
# Difficulty: Hard
# Link: https://leetcode.com/problems/lexicographically-smallest-string-after-reverse-ii/
# Language: python3
# Date: 2026-03-25


class Solution:
    def lexSmallest(self, s: str) -> str:
        chrs = list(s)
        n = len(chrs)

        self.mod = 1_000_000_007
        self.prefixes = [0] * n
        self.suffixes = [0] * n
        self.suffixe_revs = [0] * n
        self.bases = [0] * n

        h = 0
        h_rev = 0
        base = 1

        for i in range(n):
            self.bases[i] = base
            h = (h * 26 + (ord(chrs[i]) - ord("a"))) % self.mod
            self.prefixes[i] = h
            base = base * 26 % self.mod

        h = 0
        for i in range(n - 1, -1, -1):
            val = ord(chrs[i]) - ord("a")
            h = (h * 26 + val) % self.mod
            h_rev = (h_rev + val * self.bases[n - 1 - i]) % self.mod
            self.suffixes[i] = h
            self.suffixe_revs[i] = h_rev

        max_type = 0
        max_idx = n - 1

        for i in range(n - 1):
            if self.compare(chrs, max_type, max_idx, 0, i):
                max_idx = i

        for i in range(n - 2, 0, -1):
            if self.compare(chrs, max_type, max_idx, 1, i):
                max_type = 1
                max_idx = i

        if max_type == 0:
            return s[:max_idx] + s[max_idx:][::-1]
        else:
            return s[: max_idx + 1][::-1] + s[max_idx + 1 :]

    def getH(self, type_, i, length):
        if type_ == 0:
            if length <= i:
                return self.prefixes[length - 1]

            res = (
                0
                if i == 0
                else (self.prefixes[i - 1] * self.bases[length - i]) % self.mod
            )
            res = (res + self.suffixes[len(self.suffixes) - (length - i)]) % self.mod
            return res
        else:
            if length <= i + 1:
                res = (
                    self.suffixes[i + 1 - length]
                    - self.suffixes[i + 1] * self.bases[length]
                ) % self.mod
                return res

            res = (
                self.suffixes[0] - self.suffixes[i + 1] * self.bases[i + 1]
            ) % self.mod
            res = (
                res * self.bases[len(self.suffixes) - 1 - i] + self.suffixe_revs[i + 1]
            ) % self.mod
            return res

    def compare(self, chrs, type1, i, type2, j):
        n = len(chrs)
        l, r = 1, n + 1

        while l < r:
            mid = (l + r) // 2
            h1 = self.getH(type1, i, mid)
            h2 = self.getH(type2, j, mid)

            if h1 != h2:
                r = mid
            else:
                l = mid + 1

        if l == n + 1:
            return False

        return self.getChr(chrs, type2, j, l) < self.getChr(chrs, type1, i, l)

    def getChr(self, chrs, type_, i, length):
        n = len(chrs)

        if type_ == 0:
            if length <= i:
                return chrs[length - 1]
            return chrs[n - (length - i)]
        else:
            if length <= i + 1:
                return chrs[i + 1 - length]
            return chrs[length - 1]

