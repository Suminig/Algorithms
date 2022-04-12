# https://www.acmicpc.net/problem/1753
# 최단경로
# GOLD V

import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

V, E = map(int, input().split())
K = int(input())
arr = [INF] * (V+1)
heap = []
graph = [[] for _ in range(V+1)]

# 힙을 이용한 다익스트라 알고리즘 
def Dijkstra(start):
    arr[start] = 0
    heapq.heappush(heap, (0, start))

    while heap:
        weight, node = heapq.heappop(heap)

        # 현재 가중치보다 더 크면 무시
        if arr[node] < weight:
            continue

        for new_weight, new_node in graph[node]:
            # 다음 노드의 가중치 = 현재 노드까지의 가중치 + 현재 노드에서 다음 노드까지의 가중치
            temp = weight + new_weight
            # 현재 기록된 가중치보다 작으면 바꿔주기
            if temp < arr[new_node]:
                arr[new_node] = temp
                heapq.heappush(heap, (temp, new_node))

for _ in range(E):
    u, v, w = map(int, input().split())
    # 가중치 크기로 정렬 할것이기 때문에 튜플 순서를 [w, v]로 한다
    graph[u].append([w, v])

Dijkstra(K)
for i in range(1, V + 1):
    print("INF" if arr[i] == INF else arr[i])