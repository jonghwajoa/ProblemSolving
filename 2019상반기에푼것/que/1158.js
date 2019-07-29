function solution(n1, n2) {
  let val = [];
  let output = [];
  for (let i = 0; i < n1; i++) {
    val[i] = i + 1;
  }

  for (let i = 0; i < n1; i++) {
    for (let j = 0; j < n2 - 1; j++) {
      val.push(val.shift());
    }
    output.push(val.shift());
  }
  process.stdout.write('<');
  process.stdout.write(output.join(', '));
  process.stdout.write('>');
}

solution(7, 3);
