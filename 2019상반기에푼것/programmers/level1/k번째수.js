function solution(array, commands) {
  let ans = [];
  for (let i = 0; i < commands.length; i++) {
    const newArray = array.slice(commands[i][0] - 1, commands[i][1]);
    newArray.sort((a, b) => a - b);
    ans.push(newArray[commands[i][2] - 1]);
  }

  return ans;
}

solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]);
