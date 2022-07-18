# https://www.acmicpc.net/problem/1107
# 리모컨
# GOLD V

# 완전탐색
import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
if M:
    error = list(map(int, input().split()))
else:
    error = []
ans = abs(100-N)

# 큰 수에서 내려오는 경우가 있으므로 500,000이 아닌 1,000,000까지 봄
for num in range(1000001):
    for x in str(num):
        if int(x) in error:     # error에 있는 숫자는 만들 수 없음 --> break
            break
    else:
        # min(기존 ans, 버튼을 누른 횟수 + 해당 번호와 N까지의 차이)
        ans = min(ans, len(str(num))+abs(num-N))

print(ans)
