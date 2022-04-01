# https://www.acmicpc.net/problem/5014
# 스타트링크
# GOLD V

import sys
from collections import deque
input = sys.stdin.readline

F, S, G, U, D = map(int, input().split())
visited = [0] * (F+1)
q = deque()
q.append(S)
visited[S] = 1

while q:
    cur = q.popleft()
    if cur+U <= F and visited[cur+U] == 0:
        q.append(cur+U)
        visited[cur+U] = visited[cur] + 1
    if cur-D > 0 and visited[cur-D] == 0:
        q.append(cur-D)
        visited[cur-D] = visited[cur] + 1

if visited[G] > 0:
    print(visited[G]-1)
else:
    print("use the stairs")
