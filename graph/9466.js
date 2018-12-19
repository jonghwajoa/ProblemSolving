let isVisit;
let testCase;
solution = val => {
  testCase = val;
  testCase.unshift(0);
  
  isVisit = new Array(val.length + 1);
  isVisit.fill(false);
  
};

//   let count = 0;
//   for (let i = 1; i <= isVisit.length; i++) {
//     if (!isVisit[i]) {
//       dfs(i, isVisit, val);
//     }
//     // if (!isVisit[i]) {
//     //   if (!dfs(i, 0, isVisit, val)) count++;
//     // }
//   }
//   console.log(count);
// };

// dfs = (idx, start, isVisit, val) => {
//   console.log(idx);
//   isVisit[idx] = true;
//   let next = val[idx];

//   if (isVisit[next]) return false;
//   if (idx === start) return true;
//   return dfs(val[idx], start, isVisit, val);
// };

solution([3, 1, 3, 7, 3, 4, 6]);

// let arr;
// let isVisit;
// let count = 0;
// solution = param => {
//   arr = param;
//   isVisit = new Array(arr.length);

//   for (let i = 1; i < arr.length; i++) {
//     if (!isVisit[i]) {
//       isVisit[i] = true;
//       if (i === arr[i]) {
//         count++;
//         continue;
//       }
//       dfs(arr[i], i, 1);
//     }
//   }
//   return arr.length - count - 1;
// };

// dfs = (n, start, step) => {
//   if (isVisit[n]) return;
//   isVisit[n] = true;

//   step++;
//   if (arr[n] === n) {
//     count++;
//     return;
//   } else if (arr[n] === start) {
//     count += step;
//     return;
//   }
//   dfs(arr[n], start, step);
// };

// console.log(solution([0, 3, 1, 3, 7, 3, 4, 6]));
//console.log(solution([0, 1, 2, 3, 4, 5, 6, 7, 8]));
