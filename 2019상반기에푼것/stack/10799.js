function solution(input) {
  console.log(input);
  const stack = [];
  let count = 0;
  for (let i = 0; i < input.length; i++) {
    if (input[i] === '(') stack.push(i);
    else {
      let pop = stack.pop();
      if (i - pop === 1) count += stack.length;
      else count++;
    }
  }
  console.log(count);
}

solution('()(((()())(())()))(())');
solution('(((()(()()))(())()))(()())');
