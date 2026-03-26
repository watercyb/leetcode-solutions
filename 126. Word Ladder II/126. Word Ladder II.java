/*
 * Problem: 126. Word Ladder II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/word-ladder-ii/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> HM = new HashMap<>();
        Queue<Integer> Qu = new LinkedList<>();
        List<Integer>[] Li = new ArrayList[wordList.size() + 1];
        for (int i = 0; i < wordList.size(); i++) {
            HM.put(wordList.get(i), i);
            Li[i] = new ArrayList<>();
        }
        Li[wordList.size()] = new ArrayList<>();
        if (!HM.containsKey(endWord))
            return new ArrayList<>();
        if (!HM.containsKey(beginWord)) {
            wordList.add(beginWord);
            Qu.add(wordList.size() - 1);
        } else {
            Qu.add(HM.get(beginWord));
            HM.remove(beginWord);
        }
        int ed = HM.get(endWord);
        while (!Qu.isEmpty()) {
            Queue<Integer> QuNext = new LinkedList<>();
            HashMap<String, Integer> HMTmp = new HashMap<>();
            for (Integer idx : Qu) {
                String thisStp = wordList.get(idx);
                for (int i = 0; i < thisStp.length(); i++) {
                    char[] chrs = thisStp.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        chrs[i] = j;
                        String newStr = new String(chrs);
                        if (HM.containsKey(newStr)) {
                            int thisIdx = HM.get(newStr);
                            HMTmp.put(newStr, thisIdx);
                            QuNext.add(thisIdx);
                            HM.remove(newStr);
                            Li[thisIdx].add(idx);
                        } else if (HMTmp.containsKey(newStr)) {
                            Li[HMTmp.get(newStr)].add(idx);
                        }
                    }
                }
            }
            if (!Li[ed].isEmpty())
                return DFS(Li, wordList, ed);
            Qu = QuNext;
        }
        return new ArrayList<>();
    }

    public List<List<String>> DFS(List<Integer>[] Li, List<String> wordList, int i) {
        List<List<String>> res = new ArrayList<>();
        if (Li[i].isEmpty()) {
            List<String> resList = new ArrayList<>();
            resList.add(wordList.get(i));
            res.add(resList);
            return res;
        }
        for (int in : Li[i]) {
            List<List<String>> resLists = DFS(Li, wordList, in);
            for (List<String> resList : resLists) {
                resList.add(wordList.get(i));
                res.add(resList);
            }
        }
        return res;
    }
}
