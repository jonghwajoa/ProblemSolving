function solution(n, val) {
  const dp = new Array(n);
  dp.fill(1);

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < i; j++) {
      if (val[i] < val[j] && dp[i] < dp[j] + 1) {
        dp[i] = dp[j] + 1;
      }
    }
  }

  console.log(dp);
}

solution(6, [10, 30, 10, 20, 20, 10]);
