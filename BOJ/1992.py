# https://www.acmicpc.net/problem/1992
# 쿼드트리
# SILVER I

import sys
input = sys.stdin.readline

N = int(input())
arr = [list(input().rstrip()) for _ in range(N)]
ans = ""


def quad_tree(x, y, n):  # 분할정복 (재귀)
    global ans
    # 첫 번째 칸에 있는 색을 기준으로 잡는다
    color = arr[x][y]

    for i in range(x, x+n):
        for j in range(y, y+n):
            # 하나라도 다른게 있다면 면 나누기
            if arr[i][j] != color:
                ans += "("
                quad_tree(x, y, n//2)  # 1분면
                quad_tree(x, y+n//2, n//2)  # 2분면
                quad_tree(x+n//2, y, n//2)  # 3분면
                quad_tree(x+n//2, y+n//2, n//2)  # 4분면
                ans += ")"
                return
    # 재귀에 들어가지 않고 for문을 나왔으니 모두 같은 색
    ans += str(color)


quad_tree(0, 0, N)
print(ans)
