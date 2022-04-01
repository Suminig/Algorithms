# https://www.acmicpc.net/problem/10026
# 적록색약
# GOLD V

# DFS 풀이
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N = int(input())
arr = [list(input().rstrip()) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
ans_normal, ans_blind = 0, 0
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]


def dfs(x, y):
    visited[x][y] = True
    color = arr[x][y]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < N:
            if visited[nx][ny] == False and arr[nx][ny] == color:
                dfs(nx, ny)


# 정상 카운트
for i in range(N):
    for j in range(N):
        if visited[i][j] == False:
            dfs(i, j)
            ans_normal += 1
# 색약으로 변환
for i in range(N):
    for j in range(N):
        if arr[i][j] == "G":
            arr[i][j] = "R"
# 색약 카운트 / visited 초기화
visited = [[False]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if visited[i][j] == False:
            dfs(i, j)
            ans_blind += 1

print(ans_normal, ans_blind)
