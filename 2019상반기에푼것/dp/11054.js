function solution(n, val) {
  const dp = new Array(n);
  const dp2 = new Array(n);

  dp.fill(1);
  dp2.fill(1);

  for (let i = 1; i < n; i++) {
    for (let j = 0; j < i; j++) {
      if (val[j] < val[i] && dp[i] < dp[j] + 1) {
        dp[i] = dp[j] + 1;
      }
    }
  }

  for (let i = n - 1; i >= 0; i--) {
    for (let j = i - 1; j >= 0; j--) {
      if (val[i] < val[j] && dp2[i] < dp2[j] + 1) {
        dp2[i] = dp2[j] + 1;
      }
    }
  }

  let ans = 0;
  for (let i = 0; i < n; i++) {
    if (ans < dp[i] + dp2[n - i - 1] - 1) {
      ans = dp[i] + dp2[n - i - 1] - 1;
    }
  }

  console.log(dp);
  console.log(dp2.reverse());
  console.log(ans);
}

solution(10, [1, 5, 2, 1, 4, 3, 4, 5, 2, 1]);
