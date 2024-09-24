# Write your MySQL query statement below
select unique_id,name
from Employees e  left join EmployeeUNI ep
on  e.id =ep.id;
# on-joins
#  where-condi
