function solution(n, p) {
  const map = new Map();

  let temp = n;
  let count = 0;
  map.set(n, count++);
  while (true) {
    let sum = 0;
    while (temp != 0) {
      sum += Math.pow(temp % 10, p);
      temp = Math.floor(temp / 10);
    }

    if (map.has(sum)) {
      console.log(map.get(sum));
      return;
    }

    map.set(sum, count++);
    temp = sum;
  }
}

solution(57, 2);
solution(9999, 5);
solution(4, 2);
