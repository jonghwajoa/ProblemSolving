function solution(arr) {
  let len = arr.length;
  let count = 0;
  let ans = [];

  for (let i = 1; i < 1 << arr[0].length; i++) {
    let set = new Set();
    for (let j = 0; j < len; j++) {
      let string = '';
      for (let k = 0; k < arr[0].length; k++) {
        if (i & (1 << k)) {
          string += arr[j][k];
        }
      }
      set.add(string);
    }
    if (set.size === len && possible(ans, i)) {
      ans.push(i);
    }
  }

  console.log(ans.length);
}

function possible(ans, x) {
  for (let i = 0; i < ans.length; i++) {
    if ((ans[i] & x) === ans[i]) {
      return false;
    }
  }
  return true;
}

solution([
  ['100', 'ryan', 'music', '2'],
  ['200', 'apeach', 'math', '2'],
  ['300', 'tube', 'computer', '3'],
  ['400', 'con', 'computer', '4'],
  ['500', 'muzi', 'music', '3'],
  ['600', 'apeach', 'music', '2']
]);
