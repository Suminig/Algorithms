# https://programmers.co.kr/learn/courses/30/lessons/12927?language=python3
# LEVEL 3

from heapq import heappush, heappop


def solution(n, works):
    answer = 0
    heap = []
    for work in works:
        heappush(heap, -work)
    for _ in range(n):
        # 0보다 큰 아이템에 대해서만 수행
        if heap[0] < 0:
            temp = -heappop(heap)
            temp -= 1
            heappush(heap, -temp)
    for _ in range(len(heap)):
        answer += ((-1*heappop(heap)) ** 2)
    return answer
