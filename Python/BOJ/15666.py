# https://www.acmicpc.net/problem/15666
# N과 M (12)
# SILVER II

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = sorted(list(map(int, input().split())))
comb = []
check = {}

# 백트래킹
def dfs(level):
    if level == M:
        temp = " ".join(map(str, comb))
        if temp not in check:
            print(temp)
            check[temp] = 1
        return

    for i in range(N):
        if level == 0 or comb[-1] <= arr[i]:
            comb.append(arr[i])
            dfs(level+1)
            comb.pop()

dfs(0)