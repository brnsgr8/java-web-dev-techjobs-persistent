## Part 1: Test it with SQL

id (int, PK),
employer (varchar), name(varchar), skills (varchar),

## Part 2: Test it with SQL
SELECT name FROM employer WHERE location = "St. Louis city";

## Part 3: Test it with SQL
DROP TABLE job;

## Part 4: Test it with SQL
SELECT name,decription, id
FROM skill
LEFT JOIN job_skills on skill.id = jobs_skills.skill_id
WHERE job_skills.jobs_id is not null
ORDER BY name ASC;