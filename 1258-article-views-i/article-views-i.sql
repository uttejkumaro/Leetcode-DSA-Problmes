SELECT distinct author_id AS id
FROM Views
WHERE author_id = viewer_id
order by id asc;