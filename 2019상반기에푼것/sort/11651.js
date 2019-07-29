function solution(input) {
  input.sort((a, b) => {
    if (a[1] === b[1]) return a[0] - b[0];
    return a[1] - b[1];
  });

  console.log(input);
}

solution([[3, 4], [1, 1], [1, -1], [2, 2], [3, 3]]);
