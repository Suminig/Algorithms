# https://www.acmicpc.net/problem/9461
# 파도반 수열
# SILVER III

T = int(input())
for _ in range(T):
    N = int(input())
    dp = [1, 1, 1]
    for i in range(3, N):
        dp.append(dp[i-2] + dp[i-3])
    print(dp[N-1])
