/*
 * Problem: 2227. Encrypt and Decrypt Strings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/encrypt-and-decrypt-strings/
 * Language: java
 * Date: 2026-04-25
 */

class Encrypter {
    String[] encryptList = new String['z' + 1];
    HashMap<String, Integer> HM = new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; i++) {
            encryptList[keys[i]] = values[i];
        }
        for (String word : dictionary) {
            String str = encrypt(word);
            HM.put(str, HM.getOrDefault(str, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        char[] chrs = new char[word1.length() * 2];
        for (int i = 0; i < word1.length(); i++) {
            String str = encryptList[word1.charAt(i)];
            if (str == null)
                return "@";
            chrs[2 * i] = str.charAt(0);
            chrs[2 * i + 1] = str.charAt(1);
        }
        return new String(chrs);
    }

    public int decrypt(String word2) {
        return HM.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
