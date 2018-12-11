function solution(low, val) {
  const dp = new Array(2);
  const ans = new Array(low);
  for (let i = 0; i < 2; i++) {
    dp[i] = new Array(low);
  }
  dp[0][0] = val[0][0];
  dp[1][0] = val[1][0];

  ans[0] = Math.max(dp[0][0], dp[1][0]);

  for (let i = 1; i < low; i++) {
    if (i === 1) {
      dp[0][i] = dp[1][i - 1] + val[0][i];
      dp[1][i] = dp[0][i - 1] + val[1][i];
    } else {
      const max = Math.max(dp[0][i - 2], dp[1][i - 2]);
      dp[0][i] = Math.max(dp[1][i - 1], max) + val[0][i];
      dp[1][i] = Math.max(dp[0][i - 1], max) + val[1][i];
    }
    ans[i] = Math.max(dp[0][i], dp[1][i]);
  }
  console.log(ans);
}

solution(5, [[50, 10, 100, 20, 40], [30, 50, 70, 10, 60]]);
solution(7, [[10, 30, 10, 50, 100, 20, 40], [20, 40, 30, 50, 60, 20, 80]]);
