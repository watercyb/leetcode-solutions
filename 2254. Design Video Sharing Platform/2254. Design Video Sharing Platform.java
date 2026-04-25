/*
 * Problem: 2254. Design Video Sharing Platform
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/design-video-sharing-platform/
 * Language: java
 * Date: 2026-04-25
 */

class VideoSharingPlatform {
    Video[] videos = new Video[100001];
    PriorityQueue<Integer> PQ = new PriorityQueue<>();
    int n = 0;

    public VideoSharingPlatform() {

    }

    public int upload(String video) {
        if (PQ.isEmpty()) {
            videos[n++] = new Video(video);
            return n - 1;
        } else {
            int tmp = PQ.poll();
            videos[tmp] = new Video(video);
            return tmp;
        }
    }

    public void remove(int videoId) {
        if (videos[videoId] != null) {
            videos[videoId] = null;
            PQ.offer(videoId);
        }
    }

    public String watch(int videoId, int startMinute, int endMinute) {
        if (videos[videoId] == null)
            return "-1";
        videos[videoId].watch++;
        return videos[videoId].video.substring(startMinute, Math.min(endMinute+1, videos[videoId].video.length()));
    }

    public void like(int videoId) {
        if (videos[videoId] != null)
            videos[videoId].like[0]++;
    }

    public void dislike(int videoId) {
        if (videos[videoId] != null)
            videos[videoId].like[1]++;
    }

    public int[] getLikesAndDislikes(int videoId) {
        if (videos[videoId] == null)
            return new int[] { -1 };
        return videos[videoId].like;
    }

    public int getViews(int videoId) {
        if (videos[videoId] == null)
            return -1;
        return videos[videoId].watch;
    }
}

class Video {
    String video;
    int watch = 0;
    int[] like = new int[2];

    public Video(String video) {
        this.video = video;
    }
}

/**
 * Your VideoSharingPlatform object will be instantiated and called as such:
 * VideoSharingPlatform obj = new VideoSharingPlatform();
 * int param_1 = obj.upload(video);
 * obj.remove(videoId);
 * String param_3 = obj.watch(videoId,startMinute,endMinute);
 * obj.like(videoId);
 * obj.dislike(videoId);
 * int[] param_6 = obj.getLikesAndDislikes(videoId);
 * int param_7 = obj.getViews(videoId);
 */
