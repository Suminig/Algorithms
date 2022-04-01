# https://www.acmicpc.net/problem/6064
# SILVER 1

import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    M, N, x, y = map(int, input().split())
    ans = -1
    while x <= M*N:
        if x % N == y % N:
            ans = x
            break
        x += M
    print(ans)
