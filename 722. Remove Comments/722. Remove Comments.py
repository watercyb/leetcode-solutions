#
# Problem: 722. Remove Comments
# Difficulty: Medium
# Link: https://leetcode.com/problems/remove-comments/
# Language: python3
# Date: 2026-04-08


class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        res = []
        isInCommentBlock = False
        li = []
        for st in source:
            idx = 0
            while idx < len(st):
                if isInCommentBlock:
                    if st[idx] == "*" and idx < len(st) - 1 and st[idx + 1] == "/":
                        idx += 2
                        isInCommentBlock = False
                    else:
                        idx += 1
                elif st[idx] == "/" and idx < len(st) - 1 and st[idx + 1] == "/":
                    break
                elif st[idx] == "/" and idx < len(st) - 1 and st[idx + 1] == "*":
                    isInCommentBlock = True
                    idx += 2
                else:
                    li.append(st[idx])
                    idx += 1
            if not isInCommentBlock and len(li) > 0:
                res.append("".join(li))
                li = []

        return res

