function solution(n, val) {
  const dp = new Array(n);

  for (let i = 0; i < n; i++) {
    dp[i] = new Array(3);
    dp[i].fill(0);
  }

  dp[0][1] = val[0];
  dp[1][1] = val[1];
  dp[1][2] = val[0] + val[1];

  for (let i = 2; i < n; i++) {
    dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + val[i];
    dp[i][2] = dp[i - 1][1] + val[i];
  }

  console.log(Math.max(dp[n - 1][1], dp[n - 1][2]));
}

solution(6, [10, 20, 15, 25, 10, 20]);
