/*
 * Problem: 3720. Lexicographically Smallest Permutation Greater Than Target
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/?envType=daily-question&envId=2026-08-27
 * Language: java
 * Date: 2026-08-27
 */

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        char[] chrs = target.toCharArray();
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        char[] res = new char[chrs.length];
        for (int i = 0; i < chrs.length; i++) {
            if (counts[chrs[i]] > 0) {
                counts[chrs[i]]--;
                res[i] = chrs[i];
            } else {
                for (int j = chrs[i] + 1; j <= 'z'; j++) {
                    if (counts[j] == 0)
                        continue;
                    counts[j]--;
                    res[i] = (char) j;
                    for (int k = i + 1; k < chrs.length; k++) {
                        for (int l = 'a'; l <= 'z'; l++) {
                            if (counts[l] > 0) {
                                counts[l]--;
                                res[k] = (char) l;
                                break;
                            }
                        }
                    }
                    return new String(res);
                }
                for (int j = i - 1; j >= 0; j--) {
                    counts[res[j]]++;
                    for (int k = chrs[j] + 1; k <= 'z'; k++) {
                        if (counts[k] > 0) {
                            counts[k]--;
                            res[j] = (char) k;
                            for (int l = j + 1; l < chrs.length; l++) {
                                for (int m = 'a'; m <= 'z'; m++) {
                                    if (counts[m] > 0) {
                                        counts[m]--;
                                        res[l] = (char) m;
                                        break;
                                    }
                                }
                            }
                            return new String(res);
                        }
                    }
                }
                return "";
            }
        }
        for (int j = chrs.length - 1; j >= 0; j--) {
            counts[res[j]]++;
            for (int k = chrs[j] + 1; k <= 'z'; k++) {
                if (counts[k] > 0) {
                    counts[k]--;
                    res[j] = (char) k;
                    for (int l = j + 1; l < chrs.length; l++) {
                        for (int m = 'a'; m <= 'z'; m++) {
                            if (counts[m] > 0) {
                                counts[m]--;
                                res[l] = (char) m;
                                break;
                            }
                        }
                    }
                    return new String(res);
                }
            }
        }
        return "";
    }
}
