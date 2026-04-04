/*
 * Problem: 588. Design In-Memory File System
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/design-in-memory-file-system/
 * Language: java
 * Date: 2026-04-04
 */

class FileSystem {
    Dir root = new Dir(false);

    public FileSystem() {

    }

    public List<String> ls(String path) {
        String[] strs = path.split("/");
        Dir dir = root;
        for (int i = 1; i < strs.length; i++) {
            dir = dir.dirs.get(strs[i]);
            if (dir == null)
                return null;
        }
        List<String> res = new ArrayList<>();
        if (dir.isFile) {
            res.add(strs[strs.length - 1]);
        } else {
            res.addAll(dir.dirs.keySet());
        }
        return res;
    }

    public void mkdir(String path) {
        String[] strs = path.split("/");
        Dir dir = root;
        for (int i = 1; i < strs.length; i++) {
            if (!dir.dirs.containsKey(strs[i]))
                dir.dirs.put(strs[i], new Dir(false));
            dir = dir.dirs.get(strs[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] strs = filePath.split("/");
        Dir dir = root;
        for (int i = 1; i < strs.length - 1; i++) {
            dir = dir.dirs.get(strs[i]);
        }
        if (!dir.dirs.containsKey(strs[strs.length - 1]))
            dir.dirs.put(strs[strs.length - 1], new Dir(true));
        dir.dirs.get(strs[strs.length - 1]).SB.append(content);
    }

    public String readContentFromFile(String filePath) {
        String[] strs = filePath.split("/");
        Dir dir = root;
        for (int i = 1; i < strs.length - 1; i++) {
            dir = dir.dirs.get(strs[i]);
        }
        return dir.dirs.get(strs[strs.length - 1]).SB.toString();
    }
}

class Dir {
    boolean isFile;
    StringBuilder SB = new StringBuilder();
    TreeMap<String, Dir> dirs = new TreeMap<>();

    public Dir(boolean isFile) {
        this.isFile = isFile;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
