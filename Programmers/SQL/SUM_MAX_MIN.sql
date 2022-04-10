-- https://programmers.co.kr/learn/courses/30/parts/17043
-- SUM, MAX, MIN (통계 함수)

-- 최댓값 구하기 (LEVEL 1)
-- MAX() 사용
SELECT MAX(DATETIME) FROM ANIMAL_INS;

-- 최솟값 구하기 (LEVEL 2)
-- MIN() 사용
SELECT MIN(DATETIME) FROM ANIMAL_INS;

-- 동물 수 구하기 (LEVEL 2)
-- COUNT() 사용
SELECT COUNT(*) FROM ANIMAL_INS;

-- 중복 제거하기 (LEVEL 2)
-- DISTINCT + COUNT() 사용
SELECT COUNT(DISTINCT NAME) FROM ANIMAL_INS WHERE NAME IS NOT NULL;