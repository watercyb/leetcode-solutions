/*
 * Problem: 1364. Number of Trusted Contacts of a Customer
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-trusted-contacts-of-a-customer/
 * Language: mysql
 * Date: 2026-04-16
 */

# Write your MySQL query statement below
with cnt as (select user_id, COUNT(contact_name) as total, SUM(case when contact_email in (select email from Customers) then 1 else 0 end) as cSum
from Contacts
group by user_id)
select a.invoice_id, b.customer_name, a.price, IFNULL(c.total,0) as contacts_cnt, IFNULL(c.cSum,0) as trusted_contacts_cnt
from Invoices as a
left join Customers as b
on a.user_id=b.customer_id
left join cnt as c
on a.user_id=c.user_id
order by invoice_id
