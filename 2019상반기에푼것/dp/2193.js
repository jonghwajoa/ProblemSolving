function solution(n) {
  const dp = new Array(n + 1);
  for (let i = 0; i <= n; i++) {
    dp[i] = new Array(2);
    dp[i].fill(0);
  }

  dp[1][0] = 0;
  dp[1][1] = 1;

  for (let i = 2; i <= n; i++) {
    dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
    dp[i][1] = dp[i - 1][0];
  }

  console.log(dp[n][0] + dp[n][1]);
}

solution(3);
solution(5);
solution(90);
