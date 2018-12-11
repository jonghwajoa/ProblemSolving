function solution(repeat, testCase) {
  for (let i = 0; i < repeat; i++) {
    console.log(vps(testCase[i]));
  }
}

function vps(str) {
  let count = 0;
  for (let i = 0; i < str.length; i++) {
    if (str[i] === '(') count++;
    else count--;
    if (count < 0) return 'NO';
  }

  if (count === 0) return 'YES';
  return 'NO';
}

solution(6, [
  '(())())',
  '(((()())()',
  '(()())((()))',
  '((()()(()))(((())))()',
  '()()()()(()()())()',
  '(()((())()('
]);
