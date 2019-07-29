function solution(arr) {
  const name = [];
  const print = [];
  for (let val of arr) {
    let strArr = val.split(" ");
    if (strArr[0] === "Enter") {
      name[strArr[1]] = strArr[2];
    } else if (strArr[0] === "Change") {
      name[strArr[1]] = strArr[2];
    }
  }

  for (let val of arr) {
    let strArr = val.split(" ");
    if (strArr[0] === "Change") continue;
    else if (strArr[0] === "Enter") {
      print.push(`${name[strArr[1]]}님이 들어왔습니다.`);
    } else {
      print.push(`${name[strArr[1]]}님이 나갔습니다.`);
    }
  }

  return print;
}

solution([
  "Enter uid1234 Muzi",
  "Enter uid4567 Prodo",
  "Leave uid1234",
  "Enter uid1234 Prodo",
  "Change uid4567 Ryan"
]);
// 1번문제 16분컷
