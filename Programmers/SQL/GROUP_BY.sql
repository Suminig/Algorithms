-- https://programmers.co.kr/learn/courses/30/parts/17044
-- GROUP BY

-- 고양이와 개는 몇 마리 있을까 (LEVEL 2)
-- GROUP BY + COUNT() 사용
SELECT ANIMAL_TYPE, COUNT(ANIMAL_ID) AS count FROM ANIMAL_INS GROUP BY ANIMAL_TYPE ORDER BY ANIMAL_TYPE;


-- 동명 동물 수 찾기 (LEVEL 2)
-- GROUP BY + HAVING 집계함수 사용
SELECT NAME, COUNT(ANIMAL_ID) 
FROM ANIMAL_INS 
WHERE NAME IS NOT NULL GROUP BY NAME HAVING COUNT(ANIMAL_ID) > 1 ORDER BY NAME;


-- 입양 시각 구하기(1) (LEVEL 2)
-- GROUP BY + HAVING CONDITION 사용
SELECT HOUR(DATETIME) AS HOUR, COUNT(ANIMAL_ID) AS COUNT 
FROM ANIMAL_OUTS 
GROUP BY HOUR HAVING HOUR >= 9 AND HOUR < 20 ORDER BY HOUR;


-- 입양 시각 구하기(2) (LEVEL 4)
/* 0부터 23까지 1씩 추가하면서 조회하는 모든 결괏값을 합쳐서 TIME이라는 테이블을 만들어준다. 
그리고 TIME이라는 테이블과 AINMAL_OUTS테이블을 JOIN 해서 겹친 테이블을 그룹화한다면 0시부터 23시까지 각 시간대별로 조회하면 된다. 
*/
WITH RECURSIVE TIME AS (SELECT 0 AS h UNION ALL SELECT h+1 FROM TIME WHERE h < 23)
SELECT h AS HOUR, COUNT(ANIMAL_ID) AS COUNT 
FROM TIME LEFT JOIN ANIMAL_OUTS ON HOUR(DATETIME) = TIME.h GROUP BY HOUR ORDER BY HOUR;