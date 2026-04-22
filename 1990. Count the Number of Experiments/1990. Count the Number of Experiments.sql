/*
 * Problem: 1990. Count the Number of Experiments
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-the-number-of-experiments/
 * Language: mysql
 * Date: 2026-04-22
 */

# Write your MySQL query statement below
with devices as (select "Android" as device
union all
select "IOS"
union all
select "Web"),
exps as (select "Reading" as experiment
union all
select "Sports"
union all
select "Programming"),
p as (select a.device, b.experiment
from devices as a, exps as b)
select a.device as platform, a.experiment as experiment_name, COUNT(b.experiment_id) as num_experiments
from p as a
left join Experiments as b
on a.device=b.platform and a.experiment=b.experiment_name
group by platform, experiment_name
