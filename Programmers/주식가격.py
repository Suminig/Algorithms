# https://programmers.co.kr/learn/courses/30/lessons/42584
# LEVEL 2

def solution(prices):
    answer = []
    for i in range(len(prices)):
        for j in range(i+1, len(prices)):
            if prices[i] > prices[j]:
                answer.append(j-i)
                break
        else:
            answer.append(len(prices)-i-1)
    return answer
