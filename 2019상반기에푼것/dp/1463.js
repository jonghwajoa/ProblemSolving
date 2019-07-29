function solution(n) {
  let dp = new Array(n);
  dp[0] = 0;
  dp[1] = 0;

  for (let i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + 1;

    if (i % 2 === 0 && dp[i / 2] + 1 < dp[i]) {
      dp[i] = dp[i / 2] + 1;
    }

    if (i % 3 === 0 && dp[i / 3] + 1 < dp[i]) {
      dp[i] = dp[i / 3] + 1;
    }
  }

  console.log(dp[n]);
}

solution(2);
solution(10);
