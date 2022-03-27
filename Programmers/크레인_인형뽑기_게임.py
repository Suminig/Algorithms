# https://programmers.co.kr/learn/courses/30/lessons/64061
# LEVEL 1

def solution(board, moves):
    stack = []
    answer = 0
    for move in moves:
        # move는 1부터 시작하니 1을 빼준다
        move = move - 1
        for i in range(len(board)):
            if board[i][move] > 0:
                stack.append(board[i][move])
                board[i][move] = 0
                if len(stack) > 1 and stack[len(stack)-1] == stack[len(stack)-2]:
                    answer += 2
                    stack.pop()
                    stack.pop()
                # 연산이 끝난 후 더 이상 loop을 돌 필요가 없으니 멈춰준다
                break
    return answer
