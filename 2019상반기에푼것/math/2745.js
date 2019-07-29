function solution(val, b) {
  let ans = 0;
  for (let i = val.length - 1; 0 <= i; i--) {
    let num = val[i].charCodeAt();
    if ('0'.charCodeAt() <= num && num <= '9'.charCodeAt()) {
      num -= '0'.charCodeAt();
    } else {
      num = num - 'A'.charCodeAt() + 10;
    }
    ans += num * Math.pow(b, val.length - i - 1);
  }

  console.log(ans);
}

solution('ZZZZZ', 36);
solution('9876543210', 36);
