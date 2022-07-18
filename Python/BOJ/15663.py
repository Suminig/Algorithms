# https://www.acmicpc.net/problem/15663
# N과 M (9)
# SILVER II

import sys
from itertools import permutations
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
perms = list(permutations(arr, M))

# 중복 제외, 순서대로
for perm in sorted(set(perms)):
    print(" ".join([str(x) for x in perm]))
