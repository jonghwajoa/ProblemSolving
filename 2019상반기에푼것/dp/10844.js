function solution(n) {
  const dp = new Array(n + 1);

  for (let i = 0; i <= n; i++) {
    dp[i] = new Array(10);
    dp[i].fill(0);
  }

  dp[1].fill(1);
  dp[1][0] = 0;

  for (let i = 2; i <= n; i++) {
    for (let j = 1; j <= 8; j++) {
      dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
      dp[i][j] %= 1000000000;
    }
    dp[i][0] = dp[i - 1][1];
    dp[i][9] = dp[i - 1][8];
  }

  console.log(dp[n].reduce((a, b) => (a + b) % 1000000000));
}

solution(1);
solution(2);
solution(100);
