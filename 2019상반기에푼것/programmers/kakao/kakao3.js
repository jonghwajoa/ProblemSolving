function possi(array, now) {
  for (let i = 0; i < array.length; i++) {
    if ((array[i] & now) === array[i]) return false;
  }
  return true;
}

function solution(arr) {
  let n = arr.length;
  let m = arr[0].length;
  let result = [];

  for (let i = 1; i < 1 << m; i++) {
    let set = new Set();
    for (let j = 0; j < n; j++) {
      let now = "";
      for (let k = 0; k < m; k++) {
        if (i & (1 << k)) {
          now += arr[j][k];
        }
      }
      set.add(now);
    }

    if (set.size === n && possi(result, i)) {
      result.push(i);
    }
  }
  console.log(result.length);
}

solution([
  ["100", "ryan", "music", "2"],
  ["200", "apeach", "math", "2"],
  ["300", "tube", "computer", "3"],
  ["400", "con", "computer", "4"],
  ["500", "muzi", "music", "3"],
  ["600", "apeach", "music", "2"]
]);
