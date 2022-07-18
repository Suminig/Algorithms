# https://www.acmicpc.net/problem/1541
# 잃어버린 괄호
# SILVER II

# 그리디
import sys
input = sys.stdin.readline

# 마이너스 부호 기준으로 식 나누기
arr = input().rstrip().split("-")
ans = 0

# 첫번째 마이너스가 나오기 전까지는 다 플러스
for x in arr[0].split("+"):
    ans += int(x)

# 이후 모든 식은 마이너스
for x in arr[1:]:
    for y in x.split("+"):
        ans -= int(y)

print(ans)
