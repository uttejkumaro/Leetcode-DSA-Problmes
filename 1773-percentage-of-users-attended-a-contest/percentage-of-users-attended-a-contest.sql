# Write your MySQL query statement below
select r.contest_id,
    round(
        count(r.user_id) *100 /
        (select count(user_id) from Users )
    ,2) as percentage
from register r
group by r.contest_id
ORDER BY percentage DESC, contest_id ASC;