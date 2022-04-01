# https://www.acmicpc.net/problem/11286
# SILVER I

import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N = int(input())
heap = []

for _ in range(N):
    x = int(input())
    if x == 0:
        if heap:
            num = heappop(heap)
            print(num[1])
        else:
            print(0)
    else:
        heappush(heap, [abs(x), x])
