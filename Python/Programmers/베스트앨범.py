# https://programmers.co.kr/learn/courses/30/lessons/42579
# 해시
# LEVEL 3

def solution(genres, plays):
    answer = []
    total_play = {}  # 장르별 total play를 저장하는 딕셔너리
    genres_play = {}  # 장르별 play수를 저장하는 딕셔너리

    for i in range(len(genres)):
        # 딕셔너리안에 key가 존재하면 플러스, 아니면 초기화해준다
        if genres[i] in total_play:
            total_play[genres[i]] += plays[i]
        else:
            total_play[genres[i]] = plays[i]
        # 똑같이 딕셔너리안에 key가 존재하면 추가, 아니면 초기화해준다
        if genres[i] in genres_play:
            genres_play[genres[i]].append([plays[i], i])
        else:
            # [재생횟수, 인덱스]의 list형태로 추가한다
            genres_play[genres[i]] = [[plays[i], i]]

    # total_play 딕셔너리의 value를 내림차순으로 정렬 후 key 리스트를 만들어준다
    genre_rank = sorted(total_play, key=total_play.get, reverse=True)

    for x in genre_rank:
        # 재생횟수(내림차순), 인덱스(오름차순)으로 정렬해준다
        play_rank = sorted(genres_play[x], key=lambda x: (-x[0], x[1]))

        # 장르 내에 곡이 하나뿐일 경우 첫 번째만 추가, 아니면 앞의 2개만 추가한다
        # play_rank[i][1]에 저장된 index만 answer에 추가한다
        if len(play_rank) == 1:
            answer.append(play_rank[0][1])
        else:
            for i in range(2):
                answer.append(play_rank[i][1])
    return answer
