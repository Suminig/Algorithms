ans = 0
def plus(n, x, y):
    global ans
    if n + x == y:
        ans += 1
    elif n + x < y:
        plus(n+x, 1, y)
        plus(n+x, 2, y)
        plus(n+x, 3, y)
    else:
        return 0
t = int(input())
for _ in range(t):
    n = int(input())
    plus(0,0,n)
    print(ans)
    ans = 0