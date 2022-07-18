# https://www.acmicpc.net/problem/1309
# 동물원
# SILVER I

# DP 문제 
import sys
input = sys.stdin.readline

N = int(input())
dp = [0, 3, 7]

if N == 1:
    print(dp[1])
else:
    for i in range(3, N+1):
        dp.append((dp[i-1]*2+dp[i-2])%9901)

    print(dp[-1])