function solution(food_times, k) {
  let copy = [];
  let total = 0;
  for (let i = 0; i < food_times.length; i++) {
    total += food_times[i];
    copy[i] = { val: food_times[i], index: i + 1 };
  }

  if (total <= k) return -1;

  copy.sort((a, b) => {
    if (a.val === b.val) a.index - b.index;
    return a.val - b.val;
  });

  let sum = 0;
  let sub = 0;

  for (let i = 0; i < copy.length; i++) {
    sub = (copy[i].val - sum) * (copy.length - i);
    if (k - sub >= 0) {
      sum = copy[i].val;
      k -= sub;
    } else {
      let temp = Math.floor(k / (copy.length - i));
      k -= temp * (copy.length - i);
      sum += temp;
      break;
    }
  }

  copy = copy.filter(item => item.val - sum > 0);
  copy.sort((a, b) => {
    return a.index - b.index;
  });

  return copy[k].index;
}

console.log(solution([3, 1, 2], 5));
