# https://programmers.co.kr/learn/courses/30/lessons/1844
# 찾아라 프로그래밍 마에스터
# LEVEL 2

from collections import deque

def solution(maps):
    dx, dy = [1,-1,0,0], [0,0,1,-1]
    visited = [[-1] * len(maps[0]) for _ in range(len(maps))]
    q = deque([[0,0]])
    visited[0][0] = 1
    
    # BFS로 하나씩 탐색
    while q:
        x, y = q.popleft()
        
        # 상하좌우 탐색
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            # 맵 범위안에 있는지 확인
            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]):
                # 한번도 방문하지 않았고 벽이 없는지 확인
                if visited[nx][ny] == -1 and maps[nx][ny] == 1:
                    q.append([nx, ny])
                    visited[nx][ny] = visited[x][y] + 1
                    
    return visited[-1][-1]