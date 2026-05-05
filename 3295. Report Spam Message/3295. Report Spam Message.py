#
# Problem: 3295. Report Spam Message
# Difficulty: Medium
# Link: https://leetcode.com/problems/report-spam-message/
# Language: python3
# Date: 2026-05-05


class Solution:
    def reportSpam(self, message: List[str], bannedWords: List[str]) -> bool:
        ban = set(bannedWords)
        count = 0
        for st in message:
            if st in ban:
                count += 1
                if count == 2:
                    return True
        return False

