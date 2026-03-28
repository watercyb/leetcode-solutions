/*
 * Problem: 244. Shortest Word Distance II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-word-distance-ii/
 * Language: java
 * Date: 2026-03-28
 */

class WordDistance {
    HashMap<String, List<Integer>> HM = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            if (!HM.containsKey(wordsDict[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                HM.put(wordsDict[i], list);
            } else {
                HM.get(wordsDict[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = HM.get(word1);
        List<Integer> list2 = HM.get(word2);
        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            int a = list1.get(i);
            int b = list2.get(j);
            if (a < b) {
                res = Math.min(b - a, res);
                i++;
            } else {
                res = Math.min(a - b, res);
                j++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
