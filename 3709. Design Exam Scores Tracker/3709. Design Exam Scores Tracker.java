/*
 * Problem: 3709. Design Exam Scores Tracker
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-exam-scores-tracker/
 * Language: java
 * Date: 2026-05-10
 */

class ExamTracker {
    int[] times = new int[100001];
    int idx = 1;
    long[] sums = new long[100001];

    public ExamTracker() {

    }

    public void record(int time, int score) {
        times[idx] = time;
        sums[idx] = sums[idx - 1] + score;
        idx++;
    }

    public long totalScore(int startTime, int endTime) {
        return sums[binarySearch(endTime)] - sums[binarySearch(startTime - 1)];
    }

    public int binarySearch(int t) {
        int l = 0;
        int r = idx;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (times[mid] > t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */
