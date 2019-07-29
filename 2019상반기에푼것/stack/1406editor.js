function solution(input, repeat, testCase) {
  const left = input.split('');
  const right = [];

  for (let i = 0; i < repeat; i++) {
    const word = testCase[i].split(',');
    if (word[0] === 'L') {
      if (left.length) right.push(left.pop());
    } else if (word[0] === 'D') {
      if (right.length) left.push(right.pop());
    } else if (word[0] === 'B') {
      if (left.length) left.pop();
    } else if (word[0] === 'P') {
      left.push(word[1]);
    }
  }

  while (left.length) right.push(left.pop());

  while (right.length) process.stdout.write(right.pop());
  console.log();
}

solution('abcd', 3, ['P,x', 'L', 'P,y']);
solution('abc', 9, ['L', 'L', 'L', 'L', 'L', 'P,x', 'L', 'B', 'P,y']);
