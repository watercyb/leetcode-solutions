#
# Problem: 1311. Get Watched Videos by Your Friends
# Difficulty: Medium
# Link: https://leetcode.com/problems/get-watched-videos-by-your-friends/
# Language: python3
# Date: 2026-04-16


class Solution:
    def watchedVideosByFriends(
        self,
        watchedVideos: List[List[str]],
        friends: List[List[int]],
        id: int,
        level: int,
    ) -> List[str]:
        dq = deque()
        seens = [False] * len(watchedVideos)
        dq.append(id)
        seens[id] = True
        while len(dq) > 0:
            if level == 0:
                li = []
                for idx in dq:
                    for st in watchedVideos[idx]:
                        li.append(st)
                freq = Counter(li)
                sorted_items = sorted(freq.items(), key=lambda x: (x[1], x[0]))
                res = []
                for pair in sorted_items:
                    res.append(pair[0])
                return res
            for _ in range(len(dq)):
                current = dq.popleft()
                for idx in friends[current]:
                    if not seens[idx]:
                        seens[idx] = True
                        dq.append(idx)
            level -= 1
        return []

