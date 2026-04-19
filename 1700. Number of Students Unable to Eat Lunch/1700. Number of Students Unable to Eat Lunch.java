/*
 * Problem: 1700. Number of Students Unable to Eat Lunch
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int j = 0;
        int l = students.length;
        while (l > 0) {
            int k = 0;
            for (int i = 0; i < l; i++) {
                if (students[i] != sandwiches[j]) {
                    students[k] = students[i];
                    k++;
                } else {
                    j++;
                }
            }
            if (l == k)
                return l;
            l = k;
        }
        return 0;
    }
}
