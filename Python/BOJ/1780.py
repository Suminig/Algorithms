# https://www.acmicpc.net/problem/1780
# 종이의 개수
# SILVER II

# 분할정복+재귀 문제
import sys
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
minus, zero, plus = 0, 0, 0


def paper(x, y, n):
    global minus, zero, plus
    cur = arr[x][y]

    for i in range(x, x+n):
        for j in range(y, y+n):
            if arr[i][j] != cur:
                paper(x, y, n//3)
                paper(x, y+n//3, n//3)
                paper(x, y+n//3*2, n//3)
                paper(x+n//3, y, n//3)
                paper(x+n//3, y+n//3, n//3)
                paper(x+n//3, y+n//3*2, n//3)
                paper(x+n//3*2, y, n//3)
                paper(x+n//3*2, y+n//3, n//3)
                paper(x+n//3*2, y+n//3*2, n//3)
                return
    if cur == -1:
        minus += 1
    elif cur == 0:
        zero += 1
    else:
        plus += 1


paper(0, 0, N)
print(minus)
print(zero)
print(plus)
