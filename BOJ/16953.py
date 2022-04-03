# https://www.acmicpc.net/problem/16953
# A → B
# SILVER I

# BFS 풀이
import sys
from collections import deque
input = sys.stdin.readline

A, B = map(int, input().split())
depth = 1e9  # 최댓값으로 초기화

q = deque([(A, 0)])
while q:
    cur, level = q.popleft()
    if cur == B:
        # 현재 최솟값과 새로 들어오는 값중 더 작은 값으로 갱신
        depth = min(depth, level)
    if cur < B:
        # B보다 크면 더 고려할 필요가 없으므로 B보다 작은 값만 큐에 추가
        q.append([cur*2, level+1])
        q.append([int(str(cur)+"1"), level+1])

if depth == 1e9:
    # 변화 없으면 -1
    print(-1)
else:
    # 변화 있으면 최솟값+1
    print(depth+1)
