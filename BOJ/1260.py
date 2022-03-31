# https://www.acmicpc.net/problem/1260
# SILVER III

import sys
from collections import deque
input = sys.stdin.readline

N, M, V = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)


# bfs: deque을 이용해서 하나씩 popleft(), visited = False일 경우 추가
def bfs(graph, u):
    path = []
    visited = [False] * (N+1)
    q = deque(sorted(graph[u]))
    path.append(u)
    visited[u] = True
    while q:
        cur = q.popleft()
        if visited[cur] == False:
            visited[cur] = True
            path.append(cur)
            q.extend(sorted(graph[cur]))
    return path


visited = [False] * (N+1)
path = []


# dfs: recursion을 이용해 하나씩 방문
def dfs(graph, u):
    global path
    visited[u] = True
    path.append(u)
    q = sorted(graph[u])
    for x in q:
        if visited[x] == False:
            dfs(graph, x)
    return


dfs(graph, V)
print(" ".join([str(x) for x in path]))
_bfs = bfs(graph, V)
print(" ".join([str(x) for x in _bfs]))
