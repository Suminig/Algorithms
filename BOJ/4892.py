# https://www.acmicpc.net/problem/4892
# BRONZE III

import sys
input = sys.stdin.readline
idx = 1

while True:
    n = int(input())
    ans = ". "
    if n == 0:
        break
    n1 = 3 * n
    if n1 % 2 == 0:
        ans += "even "
        n2 = n1 // 2
    else:
        ans += "odd "
        n2 = (n1+1) // 2
    n3 = 3 * n2
    n4 = n3 // 9
    print(str(idx)+ans + str(n4))
    idx += 1
