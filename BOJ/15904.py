# https://www.acmicpc.net/problem/15904
# UCPC는 무엇의 약자일까?
# SILVER V

import sys
input = sys.stdin.readline

UCPC = ["U", "C", "P", "C"]
line = input().rstrip()
check = 0

for x in UCPC:
    if x in line:
        check += 1
        # 문자열 슬라이스
        line = line[line.index(x)+1:]
    else:
        # UCPC중 하나라도 없으면 바로 break
        print("I hate UCPC")
        break
# 4개 다 있으면 통과
if check == 4:
    print("I love UCPC")
