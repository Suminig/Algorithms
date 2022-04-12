# https://programmers.co.kr/learn/courses/30/lessons/81302
# 2021 카카오 채용연계형 인턴십
# LEVEL 2

from collections import deque

def bfs(place):
    people = []
    # 사람이 앉아 있는 위치 저장
    for i in range(5):
        for j in range(5):
            if place[i][j] == "P":
                people.append([i, j])
    
    # 매 응시자 위치에서부터 bfs탐색
    for person in people:
        q = deque()
        visited = [[0] * 5 for _ in range(5)]
        distance = [[0] * 5 for _ in range(5)]
        q.append(person)
        visited[person[0]][person[1]] = 1
            
        while q:
            x, y = q.popleft()
            # 상하좌우 탐색
            dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                    
                if 0 <= nx < 5 and 0 <= ny < 5 and visited[nx][ny] == 0:
                    # 빈 테이블일 경우 거리+1후 계속 탐색
                    if place[nx][ny] == "O":
                        q.append([nx, ny])
                        visited[nx][ny] = 1
                        distance[nx][ny] = distance[x][y] + 1

                    # X일 경우는 막혀 있으므로 그 방향으로 탐색 X
                    # 응시자를 만날 경우 현재 거리가 1이하이면(응시자 포함 거리 2이하) 거리두기가 지켜지지 않은 것이므로 0 리턴
                    if place[nx][ny] == "P" and distance[x][y] <= 1:
                        return 0

    # 모든 탐색을 거쳤다면 거리두기가 지켜졌으므로 1 리턴
    return 1

def solution(places):
    answer = []
    for place in places:
        answer.append(bfs(place))
        
    return answer