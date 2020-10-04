L = int(input())
S = input()
ACC = 1
MOD = 1234567891
ans = 0
for c in S:
    v = ord(c) - 96
    ans = (ans + (v * ACC)) % MOD
    ACC *= 31

print(ans)
    