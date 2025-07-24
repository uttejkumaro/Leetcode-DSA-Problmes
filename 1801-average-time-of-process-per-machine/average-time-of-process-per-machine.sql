# Write your MySQL query statement below
select machine_id,
round(avg(et-st),3) as processing_time
from(
    select a.machine_id,
    a.process_id,
    max(case when a.activity_type ='start' then a.timestamp end )as st,
    max(case when a.activity_type ='end' then a.timestamp  end ) as et
from Activity a
group by a.machine_id,a.process_id
) aliasName
group by machine_id;