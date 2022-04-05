# https://www.acmicpc.net/problem/12865
# 평범한 배낭
# GOLD V

import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = [[0, 0]] + [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * (K+1) for _ in range(N+1)]

# Knapsack Problem (배낭 문제)
for i in range(1, N+1):
    for j in range(1, K+1):
        w, v = arr[i]

        if j < w:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(v+dp[i-1][j-w], dp[i-1][j])

print(dp[-1][-1])