N, M = map(int, input().split())

isVisit = [False for i in range(N)]
arr = [0 for i in range(M)]

def dfs(depth):
  if(M <= depth): 
    print(*arr,sep=' ')
    return
  for n in range(N):
    if not isVisit[n]:
      isVisit[n] = True
      arr[depth] = n+1
      dfs(depth+1)
      isVisit[n] = False

dfs(0)
  