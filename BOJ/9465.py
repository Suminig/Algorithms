# https://www.acmicpc.net/problem/9465
# SILVER 1

T = int(input())
for _ in range(T):
    n = int(input())
    dp = [list(map(int, input().split())) for _ in range(2)]
    # 대각선에 있는 값 추가
    if n > 1:
        dp[0][1] += dp[1][0]
        dp[1][1] += dp[0][0]
        # 반대행 i-1과 i-2에서 큰 값 추가
        for i in range(2, n):
            dp[0][i] += max(dp[1][i-1], dp[1][i-2])
            dp[1][i] += max(dp[0][i-1], dp[0][i-2])
    # 각행 마지막 item중 더 큰 값 return
    print(max(dp[0][-1], dp[1][-1]))
