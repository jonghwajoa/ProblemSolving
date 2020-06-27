const solution = (n) => {
  const arr = [4, 1, 2, 4];
  const ans = [];

  while (n > 0) {
    const m = n % 3;
    ans.push(arr[m]);
    if (m == 0) {
      n -= 1;
    }
    n = Math.floor(n / 3);
  }

  return ans.reverse().join('');
};
