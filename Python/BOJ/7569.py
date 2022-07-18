# https://www.acmicpc.net/problem/7569
# 토마토 (3차원 배열)
# GOLD V

# 7576 토마토랑 똑같지만 3차원 배열 사용시 indexError 조심
import sys
from collections import deque
input = sys.stdin.readline

M, N, H = map(int, input().split())
q = deque()
arr = []

for i in range(H):
    temp = []
    for j in range(N):
        temp.append(list(map(int, input().split())))
        for k in range(M):
            if temp[j][k] == 1:
                q.append([i, j, k])
    arr.append(temp)

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]
while q:
    x, y, z = q.popleft()
    for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        nz = z + dz[i]
        if 0 <= nx < H and 0 <= ny < N and 0 <= nz < M and arr[nx][ny][nz] == 0:
            q.append([nx, ny, nz])
            arr[nx][ny][nz] = arr[x][y][z] + 1

ans = 0
for i in arr:
    for j in i:
        for k in j:
            if k == 0:
                print(-1)
                exit()
        ans = max(ans, max(j))

print(ans-1)
