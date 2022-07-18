# https://www.acmicpc.net/problem/2294
# 동전 2
# SILVER I

n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]
dp = [0]+[10001]*k

for coin in set(coins):
    for i in range(coin, k+1):
        # 현재 i값에서 coin값을 뺏을 때 coin 사용갯수에 지금 코인 갯수 하나를 더한 값과 이전 코인으로만 조합했을때 사용한 코인 갯수를 비교
        dp[i] = min(dp[i], dp[i-coin]+1)
print(dp)
if dp[k] == 10001:
    print(-1)
else:
    print(dp[k])
