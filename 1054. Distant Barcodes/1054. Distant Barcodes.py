#
# Problem: 1054. Distant Barcodes
# Difficulty: Medium
# Link: https://leetcode.com/problems/distant-barcodes/
# Language: python3
# Date: 2026-04-11


class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        freq = Counter(barcodes)
        idx = 0
        for num, count in sorted(freq.items(), key=lambda x: -x[1]):
            for _ in range(count):
                barcodes[idx] = num
                idx += 2
                if idx >= len(barcodes):
                    idx = 1
        return barcodes

