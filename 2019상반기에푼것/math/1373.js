function solution(n) {
  let s = n.toString();
  const length = s.length;
  if (length % 3) {
    s = '0'.repeat(3 - (length % 3)) + s;
  }

  const repeat = s.length / 3;
  let ans = '';
  for (let i = 0; i < repeat; i++) {
    ans += s[i * 3] * 4 + s[i * 3 + 1] * 2 + s[i * 3 + 2] * 1;
  }
  console.log(ans);
}

solution(11001100);
