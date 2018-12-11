function solution(n, testCase) {
  const max = Math.max.apply(null, testCase);
  const dp = new Array(max + 1);
  dp.fill(0);
  dp[1] = 1;
  dp[2] = 2;
  dp[3] = 4;

  for (let i = 4; i <= max; i++) {
    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
  }

  for (let i = 0; i < n; i++) {
    console.log(dp[testCase[i]]);
  }
}

solution(3, [4, 7, 10]);
