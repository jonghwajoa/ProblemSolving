function solution(val) {
  for (let i = 1; i <= val.length; i++) {
    val[i - 1][2] = i;
  }

  val.sort((a, b) => {
    if (a[0] === b[0]) return a[2] - b[2];
    return a[0] - b[0];
  });

  val.forEach(item => {
    console.log(`${item[0]} ${item[1]}`);
  });
}

solution([[21, 'Junkyu'], [21, 'Dohyun'], [20, 'Sunyoung']]);
