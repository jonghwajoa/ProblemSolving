function solution(val) {
  console.log((val[0] + val[1]) % val[2]);
  console.log((val[0] % val[2]) + (val[1] % val[2]));
  console.log((val[0] * val[1]) % val[2]);
  console.log(((val[0] % val[2]) * val[1]) % val[2]);
}

solution([5, 8, 4]);
