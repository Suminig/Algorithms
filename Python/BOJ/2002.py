# https://www.acmicpc.net/problem/2002
# 추월
# Silver I

n = int(input())
enter = []
out = []
ans = 0
for _ in range(n):
    enter.append(input())
for _ in range(n):
    out.append(input())

for i in range(n):
    if out[i] == enter[i]:
        pass
    else:
        temp = enter.pop(enter.index(out[i]))
        enter.insert(i, temp)
        ans += 1
print(ans)
