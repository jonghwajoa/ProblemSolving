function solution(n, val) {
  const dp = new Array(n);
  dp.fill(0);
  dp[0] = val[0];

  for (let i = 1; i < n; i++) {
    dp[i] = val[i];
    if (dp[i - 1] + val[i] > dp[i]) {
      dp[i] = dp[i - 1] + val[i];
    }
  }

  
  console.log(Math.max.apply(null, dp));
}

solution(10, [10, -4, 3, 1, 5, 6, -35, 12, 21, -1]);
