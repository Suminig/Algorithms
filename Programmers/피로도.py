# https://programmers.co.kr/learn/courses/30/lessons/87946
# 위클리 챌린지
# LEVEL 2

answer = 0
N = 0
visited = []

# DFS 재귀 방식으로 접근
def dfs(k, cnt, dungeons):
    global answer
    if cnt > answer:
        answer = cnt
    
    for i in range(N):
        if dungeons[i][0] <= k and visited[i] == 0:
            visited[i] = 1
            dfs(k-dungeons[i][1], cnt+1, dungeons)
            visited[i] = 0

def solution(k, dungeons):
    global N, visited
    N = len(dungeons)
    visited = [0] * N
    dfs(k, 0, dungeons)
    
    return answer