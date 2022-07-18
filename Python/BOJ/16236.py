# https://www.acmicpc.net/problem/16236
# 아기 상어
# GOLD III

import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
arr = []
sharkX, sharkY = 0, 0
# 상어 위치 9 발견하면 좌표 저장 후 0으로 초기화
for i in range(N):
    line = list(map(int, input().split()))
    for j in range(N):
        if line[j] == 9:
            sharkX, sharkY = i, j
            line[j] = 0
    arr.append(line)

dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
size, moved, eat = 2, 0, 0
# BFS로 자신보다 작은 물고기 탐색
while True:
    q = deque()
    q.append((sharkX, sharkY, 0))
    visited = [[False]*N for _ in range(N)]
    fish = []
    flag = 1e9
    while q:
        x, y, count = q.popleft()

        if count > flag:
            break
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if arr[nx][ny] > size or visited[nx][ny] == True:
                continue

            if arr[nx][ny] != 0 and arr[nx][ny] < size:
                fish.append((nx, ny, count + 1))
                flag = count
            visited[nx][ny] = True
            q.append((nx, ny, count + 1))

    # 자기보다 작은 물고기가 있으면 정렬 후 첫번째 물고기 먹기
    if fish:
        fish.sort()
        x, y, move = fish[0]
        moved += move
        eat += 1
        arr[x][y] = 0
        # 자기 사이즈만큼 먹었으면 사이즈+1
        if eat == size:
            size += 1
            eat = 0
        sharkX, sharkY = x, y
    else:
        break
print(moved)
