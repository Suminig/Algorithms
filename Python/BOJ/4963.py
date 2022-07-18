# https://www.acmicpc.net/problem/4963
# 섬의 개수
# SILVER II

# BFS 풀이
import sys
from collections import deque
input = sys.stdin.readline

while True:
    w, h = map(int, input().split())
    if w == h == 0:
        break
    arr = [list(map(int, input().split())) for _ in range(h)]
    visited = [[False] * w for _ in range(h)]
    ans = 0

    dx, dy = [-1, -1, -1, 0, 0, 1, 1, 1], [-1, 0, 1, -1, 1, -1, 0, 1]
    def bfs(i, j):
        q = deque([[i, j]])
        while q:
            x, y = q.popleft()
            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < h and 0 <= ny < w:
                    if arr[nx][ny] == 1 and visited[nx][ny] == False:
                        visited[nx][ny] = True
                        q.append([nx, ny])

    for i in range(h):
        for j in range(w):
            if arr[i][j] == 1 and visited[i][j] == False:
                visited[i][j] = True
                bfs(i, j)
                ans += 1

    print(ans)