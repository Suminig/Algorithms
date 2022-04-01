# https://www.acmicpc.net/problem/2178
# 미로 탐색
# SILVER I

import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(map(int, input().rstrip())) for _ in range(N)]
visited = [[0]*M for _ in range(N)]

# bfs 탐색
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
q = deque()
q.append([0, 0])
visited[0][0] = 1
while q:
    x, y = q.popleft()
    if x == N-1 and y == M-1:
        print(visited[-1][-1])
        break
    # 상하좌우 검색
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < N and 0 <= ny < M:
            if visited[nx][ny] == 0 and graph[nx][ny] == 1:
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx, ny))
