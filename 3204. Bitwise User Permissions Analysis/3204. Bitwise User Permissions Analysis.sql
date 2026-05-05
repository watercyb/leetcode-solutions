/*
 * Problem: 3204. Bitwise User Permissions Analysis
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bitwise-user-permissions-analysis/
 * Language: mysql
 * Date: 2026-05-05
 */

# Write your MySQL query statement below
select BIT_AND(permissions) as common_perms, BIT_OR(permissions) as any_perms
from user_permissions
