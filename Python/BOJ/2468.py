# https://www.acmicpc.net/problem/2468
# 안전 영역
# SILVER I

import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
arr = []
lowest, highest = 101, 0
ans = 0

# 높이 정보를 받으면서 제일 낮은 건물과 제일 높은 건물의 높이를 저장한다
for _ in range(N):
    temp = list(map(int, input().split()))
    lowest, highest = min(lowest, min(temp)), max(highest, max(temp))
    arr.append(temp)

# BFS로 안전한 지역 확인
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
def bfs(i, j, level, visited):
    q = deque([[i, j]])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if arr[nx][ny] > level and visited[nx][ny] == False:
                    visited[nx][ny] = True
                    q.append([nx, ny])

# 제일 낮은 건물 - 1 부터(아무 지역도 물에 잠기지 않는 경우) 제일 높은 건물까지 다 탐색한다
for level in range(lowest-1, highest):
    # visited 리스트는 높이별로 초기화 시킨다
    visited = [[False]*N for _ in range(N)]
    safe = 0
    for i in range(N):
        for j in range(N):
            if arr[i][j] > level and visited[i][j] == False:
                visited[i][j] = True
                bfs(i, j, level, visited)
                safe += 1
    # 탐색 후 안전지역 수의 최댓값으로 저장한다
    ans = max(ans, safe)

print(ans)