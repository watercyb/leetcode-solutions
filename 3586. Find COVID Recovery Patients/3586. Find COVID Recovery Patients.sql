/*
 * Problem: 3586. Find COVID Recovery Patients
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-covid-recovery-patients/
 * Language: mysql
 * Date: 2026-05-08
 */

# Write your MySQL query statement below
with p as (
    select patient_id, MIN(test_date) as p
    from covid_tests
    where result='Positive'
    group by patient_id
),
diff as (
    select a.patient_id, MIN(DATEDIFF(a.test_date,b.p)) as diff
    from covid_tests as a, p as b
    where a.result='Negative' and a.patient_id=b.patient_id and a.test_date>b.p
    group by patient_id
)
select a.*, b.diff as recovery_time
from patients as a, diff as b
where a.patient_id=b.patient_id
order by recovery_time, patient_name
