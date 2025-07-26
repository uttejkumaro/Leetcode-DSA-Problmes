SELECT e.employee_id 
FROM Employees e
LEFT JOIN Employees m
    ON m.employee_id = e.manager_id
WHERE e.salary < 30000 
  AND m.employee_id IS NULL and e.manager_id is not null
ORDER BY e.employee_id;
