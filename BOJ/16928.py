# https://www.acmicpc.net/problem/16928
# 뱀과 사다리 게임
# GOLD V

# BFS를 이용한 풀이
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
ladder, snake = {}, {}
for _ in range(N):
    u, v = map(int, input().split())
    ladder[u] = v
for _ in range(M):
    u, v = map(int, input().split())
    snake[u] = v

cnt = [0] * 101
visited = [False] * 101

q = deque([1])
visited[1] = True
while q:
    cur = q.popleft()
    for i in range(1, 7):
        moved = cur + i
        if moved in ladder:
            moved = ladder[moved]
        if moved in snake:
            moved = snake[moved]
        if moved <= 100 and visited[moved] == False:
            q.append(moved)
            visited[moved] = True
            cnt[moved] = cnt[cur] + 1

print(cnt[100])
