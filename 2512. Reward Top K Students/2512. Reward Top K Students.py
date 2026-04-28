#
# Problem: 2512. Reward Top K Students
# Difficulty: Medium
# Link: https://leetcode.com/problems/reward-top-k-students/
# Language: python3
# Date: 2026-04-28


class Solution:
    def topStudents(
        self,
        positive_feedback: List[str],
        negative_feedback: List[str],
        report: List[str],
        student_id: List[int],
        k: int,
    ) -> List[int]:
        p_set = set(positive_feedback)
        n_set = set(negative_feedback)
        arr = []
        for i in range(len(report)):
            sm = 0
            for st in report[i].split(" "):
                if st in p_set:
                    sm += 3
                elif st in n_set:
                    sm -= 1
            arr.append([sm, student_id[i]])
        arr.sort(key=lambda x: (-x[0], x[1]))
        res = []
        for i in range(k):
            res.append(arr[i][1])
        return res

