SELECT e.employee_id,
       e.name,
       COUNT(r.employee_id) AS reports_count,
       ROUND(AVG(r.age), 0) AS average_age
FROM Employees e
JOIN Employees r
  ON e.employee_id = r.reports_to
GROUP BY e.employee_id, e.name
order by e.employee_id ;
