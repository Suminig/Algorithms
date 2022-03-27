# https://programmers.co.kr/learn/courses/30/lessons/42746
# LEVEL 2

def solution(numbers):
    arr = [str(x) for x in numbers]
    arr.sort(key=lambda x: x*3, reverse=True)
    return str(int("".join(arr)))
