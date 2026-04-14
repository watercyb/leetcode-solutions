/*
 * Problem: 1166. Design File System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-file-system/
 * Language: java
 * Date: 2026-04-14
 */

class FileSystem {
    HashMap<String, Integer> HM = new HashMap<>();

    public FileSystem() {
        HM.put("", -1);
    }

    public boolean createPath(String path, int value) {
        int idx = path.length() - 1;
        String par = path.substring(0, path.lastIndexOf("/"));
        if (HM.containsKey(par) && !HM.containsKey(path)) {
            HM.put(path, value);
            return true;
        }
        return false;
    }

    public int get(String path) {
        return HM.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
