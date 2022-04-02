# https://programmers.co.kr/learn/courses/30/lessons/92334
# 2022 KAKAO BLIND RECRUITMENT
# Level 1

def solution(id_list, report, k):
    answer = [0] * len(id_list)
    # 신고당한 횟수
    reported = {x: 0 for x in id_list}

    # set(report)로 중복신고 방지
    for r in set(report):
        a, b = r.split()
        reported[b] += 1

    for r in set(report):
        a, b = r.split()
        if reported[b] >= k:
            answer[id_list.index(a)] += 1

    return answer
