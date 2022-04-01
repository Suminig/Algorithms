# https://www.acmicpc.net/problem/2667
# 단지번호붙이기
# SILVER I

n = int(input())
arr = [list(input()) for _ in range(n)]
ans = []

# 상하좌우 좌표 값 변경
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def dfs(x, y):
    if x < 0 or x >= n or y < 0 or y >= n:
        return False

    if arr[x][y] == "1":
        global cnt
        cnt += 1
        arr[x][y] = 0
        for i in range(4):
            new_x = x + dx[i]
            new_y = y + dy[i]
            dfs(new_x, new_y)
        return True

    return False


cnt = 0
for i in range(n):
    for j in range(n):
        if dfs(i, j):
            ans.append(cnt)
            cnt = 0

print(len(ans))
for a in sorted(ans):
    print(a)
