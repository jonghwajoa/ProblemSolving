let isVisit;
let testCase;
let count = 0;
solution = val => {
  testCase = val;
  testCase.unshift(0);

  isVisit = new Array(val.length + 1);
  isVisit.fill(false);

  for (let i = 1; i < val.length; i++) {
    if (!isVisit[i]) {
      isVisit[i] = true;
      if (testCase[i] === i) {
        count++;
      } else {
        dfs(val[i], i, 1);
      }
    }
  }
  console.log(val.length - count - 1);
};

dfs = (idx, start, step) => {
  if (isVisit[idx]) return;
  isVisit[idx] = true;
  step++;

  if (idx === testCase[idx]) {
    count++;
    return;
  } else if (start === testCase[idx]) {
    count += step;
    return;
  }
  dfs(testCase[idx], start, step);
};

solution([3, 1, 3, 7, 3, 4, 6]);
