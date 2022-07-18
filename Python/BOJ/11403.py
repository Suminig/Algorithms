# https://www.acmicpc.net/problem/11403
# 경로 찾기
# SILVER I

# BFS 풀이
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N)]
for i in range(N):
    line = list(map(int, input().split()))
    for j in range(N):
        if line[j] == 1:
            graph[i].append(j)

for i in range(N):
    visited = [0] * N
    q = deque()
    if graph[i]:
        q.append(i)
    while q:
        cur = q.popleft()
        for x in graph[cur]:
            if visited[x] == 0:
                visited[x] = 1
                q.append(x)
    print(" ".join([str(x) for x in visited]))
