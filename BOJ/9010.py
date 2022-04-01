# https://www.acmicpc.net/problem/9019
# DSLR
# GOLD IV

# Python제출 시 시간초과 -> pypy로제출
# BFS 풀이
import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    A, B = map(int, input().split())
    visited = [0]*10000
    q = deque()
    q.append((A, ""))
    visited[A] = 1
    while q:
        num, cmd = q.popleft()
        if num == B:
            print(cmd)
            break
        # D: 2n mod 10000
        dnum = (2*num) % 10000
        if visited[dnum] == 0:
            visited[dnum] = 1
            q.append((dnum, cmd+"D"))
        # S: n-1 (9999 if n is 0)
        snum = num - 1 if num > 0 else 9999
        if visited[snum] == 0:
            visited[snum] = 1
            q.append((snum, cmd+"S"))
        # L: left rotate
        # string 변환 후 다시 int로 변환하면 시간초과
        lnum = num % 1000 * 10 + num // 1000
        if visited[lnum] == 0:
            visited[lnum] = 1
            q.append((lnum, cmd+"L"))
        # R: right rotate
        rnum = num % 10 * 1000 + num // 10
        if visited[rnum] == 0:
            visited[rnum] = 1
            q.append((rnum, cmd+"R"))
