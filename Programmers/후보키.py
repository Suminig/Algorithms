# https://programmers.co.kr/learn/courses/30/lessons/42890
# 2019 KAKAO BLIND RECRUITMENT
# LEVEL 2

from itertools import combinations

def solution(relation):
    row = len(relation)
    col = len(relation[0])
    
    # 가능한 모든 조합 구하기
    combs = []
    for i in range(1, col+1):
        combs.extend(combinations([x for x in range(col)], i))
    
    # 유일성 만족하는 조합만 따로 저장
    unique = []
    for comb in combs:
        temp = [tuple([item[x] for x in comb]) for item in relation]
        if len(set(temp)) == row:
            unique.append(comb)
            
    # 최소성 만족하는 조합만 남기기
    minimal = set(unique)
    for i in range(len(unique)):
        for j in range(i+1, len(unique)):
            # 현재 조합과 다음 조합의 합집합이 현재 조합이랑 똑같다면 최소성 만족 못함
            if len(set(unique[i])) == len(set(unique[i])&set(unique[j])):
                minimal.discard(unique[j])
    
    return len(minimal)