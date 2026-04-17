/*
 * Problem: 1500. Design a File Sharing System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-a-file-sharing-system/
 * Language: java
 * Date: 2026-04-17
 */

class FileSharing {
    HashSet<Integer>[] chunks;
    List<Integer>[] users = new List[10001];
    int minUserId = 1;
    PriorityQueue<Integer> PQ = new PriorityQueue<>();

    public FileSharing(int m) {
        chunks = new HashSet[m + 1];
    }

    public int join(List<Integer> ownedChunks) {
        int id = 0;
        if (PQ.isEmpty()) {
            id = minUserId++;
        } else {
            id = PQ.poll();
        }
        users[id] = ownedChunks;
        for (int chunkId : ownedChunks) {
            if (chunks[chunkId] == null)
                chunks[chunkId] = new HashSet<>();
            chunks[chunkId].add(id);
        }
        return id;
    }

    public void leave(int userID) {
        PQ.offer(userID);
        for (int chunkId : users[userID]) {
            chunks[chunkId].remove(userID);
        }
    }

    public List<Integer> request(int userID, int chunkID) {
        List<Integer> res = new ArrayList<>();
        if (chunks[chunkID] == null)
            return res;
        res.addAll(chunks[chunkID]);
        Collections.sort(res);
        if (res.size() > 0) {
            users[userID].add(chunkID);
            chunks[chunkID].add(userID);
        }
        return res;
    }
}

/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
 */
