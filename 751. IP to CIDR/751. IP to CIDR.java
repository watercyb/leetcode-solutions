/*
 * Problem: 751. IP to CIDR
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/ip-to-cidr/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<List<Long>> nodes = new ArrayList<>();
        String[] strs = ip.split("\\.");
        long ipNum = (Long.valueOf(strs[0]) << 24) + (Long.valueOf(strs[1]) << 16) + (Long.valueOf(strs[2]) << 8)
                + Long.valueOf(strs[3]);

        long limit = ipNum + n;
        List<String> res = new ArrayList<>();
        while (ipNum < limit) {
            long lowest = ipNum & -ipNum;
            if (lowest == 0)
                lowest = 1 << 30;
            while (ipNum + lowest > limit) {
                lowest >>= 1;
            }
            res.add(getIp(ipNum, (int) (Math.log(lowest) / Math.log(2))));
            ipNum += lowest;
        }
        return res;
    }

    public String getIp(long ipNum, int n) {
        StringBuilder SB = new StringBuilder();
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = (int) (ipNum % 256);
            ipNum /= 256;
        }
        SB.append(nums[3]).append('.').append(nums[2]).append('.').append(nums[1]).append('.').append(nums[0])
                .append('/')
                .append(String.valueOf(32 - n));
        return SB.toString();
    }
}
