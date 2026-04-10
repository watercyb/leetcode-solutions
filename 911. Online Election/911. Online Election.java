/*
 * Problem: 911. Online Election
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/online-election/
 * Language: java
 * Date: 2026-04-10
 */

class TopVotedCandidate {
    int[] maxVoteIdx;
    int[] time;

    public TopVotedCandidate(int[] persons, int[] times) {
        int[][] pairs = new int[persons.length][2];
        int max = 0;
        for (int i = 0; i < persons.length; i++) {
            pairs[i][0] = persons[i];
            max = Math.max(persons[i], max);
            pairs[i][1] = times[i];
        }
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int[] counts = new int[max + 1];
        int maxVote = 1;
        int maxIdx = pairs[0][0];
        int prv = pairs[0][1];
        counts[pairs[0][0]]++;
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][1] != prv) {
                list.add(new int[] { prv, maxIdx });
                prv = pairs[i][1];
            }
            counts[pairs[i][0]]++;
            if (counts[pairs[i][0]] >= maxVote) {
                maxVote = counts[pairs[i][0]];
                maxIdx = pairs[i][0];
            }
        }
        list.add(new int[] { prv, maxIdx });
        maxVoteIdx = new int[list.size()];
        time = new int[maxVoteIdx.length];
        for (int i = 0; i < maxVoteIdx.length; i++) {
            int[] pair = list.get(i);
            maxVoteIdx[i] = pair[1];
            time[i] = pair[0];
        }
    }

    public int q(int t) {
        return maxVoteIdx[binarySearch(t)];
    }

    public int binarySearch(int t) {
        int l = 0;
        int r = time.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (time[mid] > t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
