import sys
from collections import deque

N = int(sys.stdin.readline())

que = deque()
for i in range(N):
    inputData = sys.stdin.readline().split()
    command = inputData[0]
    if command == "push":
        que.append(inputData[1])
    elif command == "front":
        sys.stdout.write(str(que[0] if que else -1) + "\n")
    elif command == "back":
        sys.stdout.write(str(que[-1] if que else -1) + "\n")
    elif command == "size":
        sys.stdout.write(str(len(que)) + "\n")
    elif command == "empty":
        sys.stdout.write(str(1 if not que else 0) + "\n")
    elif command == "pop":
        sys.stdout.write(str(que.popleft() if que else -1) + "\n")
