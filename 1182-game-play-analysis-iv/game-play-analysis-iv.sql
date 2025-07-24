SELECT 
    ROUND(
        (SELECT COUNT(DISTINCT e1.player_id)
         FROM Activity e1
         JOIN (
             SELECT player_id, MIN(event_date) AS first_login
             FROM Activity
             GROUP BY player_id
         ) b
         ON e1.player_id = b.player_id 
         AND DATEDIFF(e1.event_date, b.first_login) = 1)
        /
        (SELECT COUNT(DISTINCT player_id) FROM Activity),
        2
    ) AS fraction;
