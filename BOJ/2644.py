# https://www.acmicpc.net/problem/2644
# SILVER II

import sys
from collections import deque
input = sys.stdin.readline


def bfs(start):
    # bfs로 돌면서 촌수 계산
    q = deque()
    q.append(start)
    while q:
        cur = q.popleft()
        for x in arr[cur]:
            if visited[x] == 0:
                q.append(x)
                visited[x] = visited[cur] + 1


n = int(input())
a, b = map(int, input().split())
m = int(input())
arr = [[]*n for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, input().split())
    arr[x].append(y)
    arr[y].append(x)
visited = [0] * (n+1)
bfs(a)
# visited == 0이면 관계 없음
print(visited[b] if visited[b] > 0 else -1)
