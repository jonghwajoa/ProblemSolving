function solution(param) {
  let match = [];
  match.length = 10;
  match.fill(0, 0, 10);

  let strParam = param.toString();
  for (let e of strParam) {
    match[e] += 1;
  }

  match[6] += match[9];
  match[6] = Math.ceil(match[6] / 2);
  match[9] = 0;

  let ans = 0;
  match.forEach(e => {
    if (ans < e) {
      ans = e;
    }
  });
  console.log(ans);
}

solution(999966);
solution(123456789);
solution(112345678999);
solution(213213213);
