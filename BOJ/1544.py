# https://www.acmicpc.net/problem/1544
# 사이클 단어
# SILVER IV

import sys
input = sys.stdin.readline

N = int(input())
words = []
for _ in range(N):
    word = input().rstrip()
    # 비어있다면 바로 추가
    if not words:
        words.append(word)
    else:
        # 단어 회전시켜가며 이미 단어 리스트에 있는지 확인
        for j in range(len(word)):
            word = word[1:]+word[0]
            # 있다면 같은 단어이니 중지
            if word in words:
                break
        else:
            # 없다면 단어 리스트에 추가
            words.append(word)

print(len(words))