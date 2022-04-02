# https://programmers.co.kr/learn/courses/30/lessons/77484
# 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
# LEVEL 1

def solution(lottos, win_nums):
    answer = []
    rank = [6, 6, 5, 4, 3, 2, 1]
    unknown = lottos.count(0)
    same = 0

    for lotto in lottos:
        if lotto in win_nums:
            same += 1

    # 최고 순위: 0의 갯수 + 맞은 번호의 개수
    answer.append(rank[unknown+same])
    # 최저 순위: 맞은 번호의 개수
    answer.append(rank[same])

    return answer
