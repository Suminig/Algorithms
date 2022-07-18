# https://www.acmicpc.net/problem/1149
# RGB거리
# SILVER I

import sys
input = sys.stdin.readline

N = int(input())
dp = [list(map(int, input().split())) for _ in range(N)]

# DP: (0번 제외) 1부터 끝집까지 전 집에서 다른 색상 중 최솟값 더하기
for i in range(1, N):
    # R
    dp[i][0] += min(dp[i-1][1], dp[i-1][2])
    # G
    dp[i][1] += min(dp[i-1][0], dp[i-1][2])
    # B
    dp[i][2] += min(dp[i-1][0], dp[i-1][1])

print(min(dp[-1]))
