function solution(a, b) {
  let lcd = GCD(b, a % b);
  console.log((a * b) / lcd);
}

function GCD(a, b) {
  if (b === 0) return a;
  return GCD(b, a % b);
}

solution(1, 45000);
solution(6, 10);
solution(13, 17);
