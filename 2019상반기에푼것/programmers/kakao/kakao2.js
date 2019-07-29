function solution(N, stages) {
  let stageCount = new Array(N);
  let failPer = [];
  stageCount.fill(0);

  let usersNum = stages.length;
  for (let val of stages) {
    stageCount[val - 1]++;
  }

  for (let i = 0; i < N; i++) {
    if (usersNum === 0) {
      failPer.push({ failper: 0, stageNum: i + 1 });
    } else {
      failPer.push({ failper: stageCount[i] / usersNum, stageNum: i + 1 });
    }
    usersNum -= stageCount[i];
  }

  failPer.sort((a, b) => {
    if (a.failper === b.failper) {
      return a.stageNum - b.stageNum;
    }
    return b.failper - a.failper;
  });

  return failPer.map(item => {
    return item.stageNum;
  });
}

console.log(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]));
// console.log(solution(5, [6, 6, 6, 6, 6, 6]));
// console.log(solution(4, [4, 4, 4, 4, 4]));
// console.log(solution(5, [1, 1, 2, 1]));

// 2시 48분
