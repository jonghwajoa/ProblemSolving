// function solution(n, val) {
//   const dp = new Array(n);
//   for (let i = 0; i < n; i++) {
//     dp[i] = new Array(3);
//     dp[i].fill(0);
//   }
//   // 0 : 0번연속
//   // 1 : 1번연속
//   // 2 : 2번연속
//   dp[0][0] = 0;
//   dp[0][1] = val[0];
//   dp[0][2] = val[0];

//   for (let i = 1; i < n; i++) {
//     dp[i][0] = Math.max.apply(null, [dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]]);
//     dp[i][1] = dp[i - 1][0] + val[i];
//     dp[i][2] = dp[i - 1][1] + val[i];
//   }

//   console.log(Math.max.apply(null, [dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]]));
// }

// solution(6, [6, 10, 13, 9, 8, 1]);

function solution(n, val) {
  const dp = new Array(n + 1);
  dp.fill(0);

  dp[1] = val[0];
  dp[2] = val[0] + val[1];

  for (let i = 3; i <= n; i++) {
    dp[i] = dp[i - 1];

    if (dp[i] < dp[i - 2] + val[i - 1]) {
      dp[i] = dp[i - 2] + val[i - 1];
    }

    if (dp[i] < dp[i - 3] + val[i - 2] + val[i - 1]) {
      dp[i] = dp[i - 3] + val[i - 2] + val[i - 1];
    }
  }

  console.log(dp);
}

solution(6, [6, 10, 13, 9, 8, 1]);
