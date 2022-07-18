# https://www.acmicpc.net/problem/2407
# 조합
# SILVER III

import sys
from math import factorial
input = sys.stdin.readline

n, m = map(int, input().split())

# Combination nCr = n!/(r!*(n-r)!)
print(factorial(n)//(factorial(m)*factorial(n-m)))