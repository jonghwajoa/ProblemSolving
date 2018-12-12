function solution(n, testCase) {
  const dp = new Array(n);
  dp.fill(1);

  for (let i = 1; i < n; i++) {
    let max = 0;
    for (let j = i - 1; j >= 0; j--) {
      if (testCase[i] > testCase[j]) {
        max = Math.max(max, dp[j]);
      }
    }
    dp[i] = max + 1;
  }
  console.log(Math.max.apply(null, dp));
}

solution(6, [10, 20, 10, 30, 20, 50]);
solution(6, [30, 20, 10, 20, 30, 40]);
