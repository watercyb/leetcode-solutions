/*
 * Problem: 759. Employee Free Time
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/employee-free-time/?envType=weekly-question&envId=2026-05-01
 * Language: java
 * Date: 2026-05-01
 */

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> PQ = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (List<Interval> list : schedule) {
            for (Interval interval : list) {
                PQ.offer(interval);
            }
        }
        List<Interval> res = new ArrayList<>();
        int last = PQ.poll().end;
        while (!PQ.isEmpty()) {
            Interval tmp = PQ.poll();
            if (tmp.start > last)
                res.add(new Interval(last, tmp.start));
            last = Math.max(tmp.end, last);
        }
        return res;
    }
}
