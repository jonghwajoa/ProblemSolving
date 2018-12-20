let complex;
let apart;
const point_x = [1, -1, 0, 0];
const point_y = [0, 0, 1, -1];
let N;
function solution(repeat, input) {
  complex = new Array(repeat);
  apart = input;
  N = repeat;
  let count = 0;
  for (let i = 0; i < repeat; i++) {
    complex[i] = new Array(repeat);
    complex[i].fill(0);
  }

  for (let i = 0; i < repeat; i++) {
    for (let j = 0; j < repeat; j++) {
      if (complex[i][j] === 0 && apart[i][j] === 1) {
        dfs(i, j, ++count);
      }
    }
  }

  let ans = new Array(count);
  ans.fill(0);
  for (let i = 0; i < repeat; i++) {
    for (let j = 0; j < repeat; j++) {
      if (complex[i][j] != 0) {
        ans[complex[i][j] - 1]++;
      }
    }
  }

  console.log(count);
  ans.sort().forEach(e => {
    console.log(e);
  });
}

function dfs(x, y, group) {
  complex[x][y] = group;
  for (let i = 0; i < N; i++) {
    let dx = x + point_x[i];
    let dy = y + point_y[i];

    if (0 <= dx && 0 <= dy && dx < N && dy <= N) {
      if (complex[dx][dy] === 0 && apart[dx][dy] === 1) {
        dfs(dx, dy, group);
      }
    }
  }
}

solution(7, [
  [0, 1, 1, 0, 1, 0, 0],
  [0, 1, 1, 0, 1, 0, 1],
  [1, 1, 1, 0, 1, 0, 1],
  [0, 0, 0, 0, 1, 1, 1],
  [0, 1, 0, 0, 0, 0, 0],
  [0, 1, 1, 1, 1, 1, 0],
  [0, 1, 1, 1, 0, 0, 0]
]);
