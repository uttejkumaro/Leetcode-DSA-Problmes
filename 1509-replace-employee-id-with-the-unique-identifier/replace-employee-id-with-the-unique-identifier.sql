# Write your MySQL query statement below
select e1.unique_id,e.name
from EMployees e left outer join EMployeeUNI e1 on e1.id=e.id