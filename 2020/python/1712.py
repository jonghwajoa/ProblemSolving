fixedCost,variableCost,price  = map(int, input().split(' '))

if(price <= variableCost):
  print(-1)
else:
  margin = price - variableCost 
  ans = fixedCost // margin + 1
  print(ans) 