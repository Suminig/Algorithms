# https://www.acmicpc.net/problem/11725
# 트리의 부모 찾기
# SILVER II

import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
tree = [[] for _ in range(N+1)]

for _ in range(N-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

visited = [0] * (N+1)
q = deque([1])
visited[1] = 1

# BFS: visited가 0이라면 현재 탐색중인 node를 parent로 저장
while q:
    cur = q.popleft()
    for x in tree[cur]:
        if visited[x] == 0:
            visited[x] = cur
            q.append(x)

for parent in visited[2:]:
    print(parent)