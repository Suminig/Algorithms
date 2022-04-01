# https://www.acmicpc.net/problem/14500
# 테트로미노
# GOLD V

# DFS+재귀를 이용한 풀이 (dfs로 3칸안에 모든 모양이 만들어짐)
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def dfs(x, y, cnt, sum):
    global ans
    if ans >= sum + max_val*(3-cnt):
        return
    if cnt == 3:
        ans = max(ans, sum)
        return
    else:
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0:
                # ㅗ,ㅜ,ㅏ,ㅓ를 만들기 위해 2번째 칸에서 다시 현재 위치에서 dfs를 실행
                if cnt == 1:
                    visited[nx][ny] = 1
                    dfs(x, y, cnt+1, sum+arr[nx][ny])
                    visited[nx][ny] = 0
                visited[nx][ny] = 1
                dfs(nx, ny, cnt+1, sum+arr[nx][ny])
                visited[nx][ny] = 0


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
ans = 0
max_val = max(map(max, arr))


for i in range(N):
    for j in range(M):
        visited[i][j] = 1
        dfs(i, j, 0, arr[i][j])
        visited[i][j] = 0

print(ans)
