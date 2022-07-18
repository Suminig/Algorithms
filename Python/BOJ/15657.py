# https://www.acmicpc.net/problem/15657
# N과 M (8)
# SILVER III

# DFS 풀이
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
path = []


def dfs(cnt):
    if cnt == M:
        print(" ".join([str(x) for x in path]))
        return

    for i in range(N):
        if cnt == 0 or path[-1] <= arr[i]:
            path.append(arr[i])
            dfs(cnt+1)
            path.pop()


dfs(0)
