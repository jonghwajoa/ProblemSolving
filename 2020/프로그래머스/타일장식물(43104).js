const solution = (n) => {
  const factorial = [0, 1];

  let ans = 4;
  for (let i = 2; i <= n; i++) {
    factorial[i] = factorial[i - 1] + factorial[i - 2];
    ans += factorial[i] * 2;
  }

  return ans;
};
