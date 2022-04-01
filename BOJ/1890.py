# https://www.acmicpc.net/problem/1890
# 점프
# SILVER II

# DFS로 풀어봤는데 시간초과 --> DP로 해결
import sys
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * N for _ in range(N)]
dp[0][0] = 1

for i in range(N):
    for j in range(N):
        # 마지막 칸은 0이니 break해줘야함
        if i == N-1 and j == N-1:
            print(dp[i][j])
            break
        temp = arr[i][j]
        if j + temp < N:
            dp[i][j+temp] += dp[i][j]
        if i + temp < N:
            dp[i+temp][j] += dp[i][j]
