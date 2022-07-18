# https://www.acmicpc.net/problem/1932
# 정수 삼각형
# SILVER I

# DP - 위에 두개 중 더 큰값 더해 나가기 
import sys
input = sys.stdin.readline

n = int(input())
arr = []
for i in range(1, n+1):
    temp = list(map(int, input().split()))
    arr.append(temp+[0]*(n-i))

for i in range(1, n):
    for j in range(n):
        if j == 0:
            arr[i][j] += arr[i-1][j]
        else:
            arr[i][j] = max(arr[i][j]+arr[i-1][j], arr[i][j]+arr[i-1][j-1])
            
print(max(arr[-1]))
