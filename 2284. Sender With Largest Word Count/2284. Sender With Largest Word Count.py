#
# Problem: 2284. Sender With Largest Word Count
# Difficulty: Medium
# Link: https://leetcode.com/problems/sender-with-largest-word-count/
# Language: python3
# Date: 2026-04-25


class Solution:
    def largestWordCount(self, messages: List[str], senders: List[str]) -> str:
        mp = {}
        for i in range(len(messages)):
            sender = senders[i]
            mp[sender] = mp.get(sender, 0) + messages[i].count(" ") + 1
        res = ""
        max_count = 0
        for sender, count in mp.items():
            if count > max_count or (count == max_count and res < sender):
                res = sender
                max_count = count
        return res

