function solution(n) {
  const dp = new Array(n + 1);
  dp[0] = 0;

  for (let i = 1; i <= n; i++) {
    dp[i] = i;
    for (let j = 1; j * j <= i; j++) {
      if (dp[i - j * j] + 1 < dp[i]) {
        dp[i] = dp[i - j * j] + 1;
      }
    }
  }

  console.log(dp);
}

solution(7);
