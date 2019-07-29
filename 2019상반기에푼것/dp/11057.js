function solution(n) {
  const dp = new Array(n + 1);
  for (let i = 0; i <= n; i++) {
    dp[i] = new Array(10);
    dp[i].fill(0);
  }
  dp[1].fill(1);

  for (let i = 2; i <= n; i++) {
    for (let j = 0; j <= 9; j++) {
      for (let k = 0; k <= j; k++) {
        dp[i][j] += dp[i - 1][k];
        dp[i][j] %= 10007;
      }
    }
  }

  console.log(dp[n].reduce((a, b) => (a + b) % 10007));
}

solution(1);
solution(2);
solution(3);
