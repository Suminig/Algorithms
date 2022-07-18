# https://www.acmicpc.net/problem/1057
# 토너먼트
# SILVER III

import sys
input = sys.stdin.readline

N, Kim, Lim = map(int, input().split())
round = 0

while Kim != Lim:
    Kim = (Kim+1) // 2
    Lim = (Lim+1) // 2
    round += 1
        
print(round)