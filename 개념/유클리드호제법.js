function solution(a, b) {
  let gcd = GCD(b, a % b);
  let lcd = gcd * (a / gcd) * (b / gcd);
  // lcd = a * b / gcd;
  console.log(gcd);
  console.log(lcd);
}

function GCD(a, b) {
  if (b === 0) return a;
  return GCD(b, a % b);
}

solution(24, 18);
solution(5, 10);
solution(13, 9);

// lcd 최소공배수
// gcd 최대공약수
