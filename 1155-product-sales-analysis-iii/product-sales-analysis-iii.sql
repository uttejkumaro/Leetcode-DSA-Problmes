# Write your MySQL query statement below
select s.product_id,first_year,s.quantity,s.price 
from Sales s 
join (
    select product_id,min(year)as first_year
    from Sales
    group by product_id
) first_sale 
on first_sale.first_year=s.year and s.product_id=first_sale.product_id;