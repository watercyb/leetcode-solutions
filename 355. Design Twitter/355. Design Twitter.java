/*
 * Problem: 355. Design Twitter
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-twitter/
 * Language: java
 * Date: 2026-04-03
 */

class Twitter {
    HashSet<Integer>[] followers = new HashSet[501];
    int[] times = new int[10001];
    List<Integer>[] posts = new ArrayList[501];
    int n = 1;

    public Twitter() {
        for (int i = 0; i < posts.length; i++) {
            followers[i] = new HashSet<>();
            posts[i] = new ArrayList<>();
        }
    }

    public void postTweet(int userId, int tweetId) {
        posts[userId].add(tweetId);
        times[tweetId] = n++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Node> PQ = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int i = posts[userId].size() - 1; i >= 0; i--) {
            int idx = posts[userId].get(i);
            PQ.offer(new Node(idx, times[idx]));
        }
        for (int followeeId : followers[userId]) {
            for (int i = posts[followeeId].size() - 1; i >= 0; i--) {
                int idx = posts[followeeId].get(i);
                PQ.offer(new Node(idx, times[idx]));
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10 && !PQ.isEmpty(); i++) {
            res.add(PQ.poll().tweetId);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followers[followerId].add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followers[followerId].remove(followeeId);
    }
}

class Node {
    int tweetId;
    int time;

    public Node(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
