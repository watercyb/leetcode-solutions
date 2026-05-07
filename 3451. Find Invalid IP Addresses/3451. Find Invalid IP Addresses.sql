/*
 * Problem: 3451. Find Invalid IP Addresses
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-invalid-ip-addresses/
 * Language: mysql
 * Date: 2026-05-07
 */

# Write your MySQL query statement below
select ip, COUNT(*) as invalid_count
from logs
where not ip REGEXP '^([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))\\.([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))\\.([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))\\.([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))$'
group by ip
order by invalid_count desc, ip desc
