function solution(n, val) {
  const dp = new Array(n);

  for (let i = 0; i < n; i++) {
    dp[i] = val[i];
    for (let j = 0; j < i; j++) {
      if (val[i] > val[j] && dp[i] < dp[j] + val[i]) {
        dp[i] = dp[j] + val[i];
      }
    }
  }

  console.log(dp);
}

solution(10, [1, 100, 2, 50, 60, 3, 5, 6, 7, 8]);
