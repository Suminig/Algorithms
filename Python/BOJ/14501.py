# https://www.acmicpc.net/problem/14501
# 퇴사
# Silver III

import sys
sys.setrecursionlimit(10**6)
n = int(sys.stdin.readline())
t = []
p = []
arr = []

for i in range(n):
    ti, pi = sys.stdin.readline().rstrip().split()
    t.append(int(ti))
    p.append(int(pi))


def dfs(day, earn):
    if day >= n:
        arr.append(earn)
        return
    # 현재 day + 소요 day가 n보다 크면 상담을 하지 않는 조건을 붙여준다
    if (day+t[day]) <= n:
        # 현재 day에서 상담을 진행하는 경우
        dfs(day+t[day], earn+p[day])
    # 현재 day에서 상담을 진행하지 않는 경우
    dfs(day+1, earn)


dfs(0, 0)
print(max(arr))
