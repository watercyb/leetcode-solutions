#
# Problem: 1024. Video Stitching
# Difficulty: Medium
# Link: https://leetcode.com/problems/video-stitching/
# Language: python3
# Date: 2026-04-11


class Solution:
    def videoStitching(self, clips: List[List[int]], time: int) -> int:
        ranges = [0] * (time + 1)
        for clip in clips:
            if clip[0] > time:
                continue
            if clip[1] > time:
                clip[1] = time
            ranges[clip[0]] = max(ranges[clip[0]], clip[1])
        lim = 0
        step = 0
        idx = 0
        while lim < time:
            if idx > lim:
                return -1
            lim_next = 0
            while idx <= lim:
                lim_next = max(lim_next, ranges[idx])
                idx += 1
            step += 1
            lim = lim_next
        return step

