function solution(val) {
  let ans = 0;
  for (let i = 0; i < val.length; i++) {
    for (let j = i; j < val.length; j++) {
      if (i === j) continue;
      ans += gcd(val[i], val[j]);
    }
  }

  console.log(ans);
}

function gcd(a, b) {
  if (b === 0) return a;
  return gcd(b, a % b);
}

solution([10, 20, 30, 40]);
solution([7, 5, 12]);
solution([125, 15, 25]);
