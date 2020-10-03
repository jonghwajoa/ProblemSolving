mx = [-2,-1,1,2,2,1,-1,-2]
my = [1,2,2,1,-1,-2,-2,-1]

T = int(input())

def solve():
  W = int(input())
  curX, curY = map(int, (input().split()))
  destX, destY = map(int, (input().split()))
  isVisit = [[False for x in range(W)] for y in range(W) ]

  q = []
  q.append([ curX, curY ,0 ])
  isVisit[curY][curX] = True
  while(q):
    cur = q.pop(0)
    if cur[0] == destX and cur[1] == destY:
      print(cur[2])
      break
    for v in range(0,8,1):
      nx = mx[v] + cur[0]
      ny = my[v] + cur[1]
      if 0 <= nx and 0 <= ny and nx < W and ny < W:
        if not isVisit[ny][nx]:
          isVisit[ny][nx] = True
          q.append([nx,ny, cur[2] + 1])

for v in range(T):
  solve()