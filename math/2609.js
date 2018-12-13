function solution(a, b) {
  const max = Math.max(a, b);
  let gcd;
  let l = 0;

  for (let i = max; 0 < i; i--) {
    if (a % i === 0 && b % i === 0) {
      gcd = i;
      l = gcd * (a / i) * (b / i);
      break;
    }
  }

  console.log(gcd, l);
}

solution(24, 18);
solution(5, 10);
solution(13, 9);
