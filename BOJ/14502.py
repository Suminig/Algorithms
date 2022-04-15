# https://www.acmicpc.net/problem/14502
# 연구소
# GOLD V

# bfs + 재귀 / Python 시간초과 -> Pypy3로 제출
import sys
import copy
from collections import deque
input = sys.stdin.readline

ans = 0
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

# bfs로 바이러스가 퍼져나가게 한 후 0의 갯수를 센다
def bfs():
    global ans
    q = deque()
    # 현재 arr 깊은 복사
    temp = copy.deepcopy(arr)
    for i in range(N):
        for j in range(M):
            if temp[i][j] == 2:
                q.append([i, j])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and temp[nx][ny] == 0:
                temp[nx][ny] = 2
                q.append([nx, ny])

    cnt = 0
    for t in temp:
        cnt += t.count(0)

    # 최댓값으로 치환
    ans = max(ans, cnt)

# 재귀로 벽을 하나씩 만든다 / 벽 3개가 만들어지면 bfs실행
def make_wall(wall):
    if wall == 3:
        bfs()
        return
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 0:
                arr[i][j] = 1
                make_wall(wall+1)
                arr[i][j] = 0

make_wall(0)
print(ans)