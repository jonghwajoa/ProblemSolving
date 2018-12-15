function solution(n) {
  let s = n.toString();
  let result = '';
  for (let i = 0; i < s.length; i++) {
    let num = s[i];
    let ans = '';
    ans = (num % 2) + ans;
    num = Math.floor(num / 2);
    ans = (num % 2) + ans;
    num = Math.floor(num / 2);
    ans = (num % 2) + ans;
    num = Math.floor(num / 2);
    result += ans;
  }

  if (result[0] === '0') {
    result = result.slice(1);
  }
  if (result[0] === '0') {
    result = result.slice(1);
  }
  console.log(result);
}

solution(314);
solution(177);
