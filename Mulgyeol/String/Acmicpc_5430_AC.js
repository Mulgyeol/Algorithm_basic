const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

function solution(input) {
  let T = +input[0];
  let idx = 1;
  for (let t = 0; t < T; t++) {
    const p = input[idx++];
    const pLength = p.length;
    let num = Number(input[idx++]);
    let array = input[idx++];

    array = array
      .slice(1, array.length - 1)
      .split(",")
      .join("");

    let front = 0;
    let end = 0;
    let dir = true; // true는 앞
    let flag = true;

    for (let i = 0; i < pLength; i++) {
      if (p[i] === "R") {
        dir = !dir;
      } else {
        if (num !== 0) {
          dir ? front++ : end++;
          num--;
        } else {
          console.log("error");
          flag = false;
          break;
        }
      }
    }

    if (flag) {
      dir
        ? (array = array
            .slice(front, array.length - end)
            .split("")
            .join(","))
        : (array = array
            .slice(front, array.length - end)
            .split("")
            .reverse()
            .join(","));
      console.log("[" + array + "]");
    }
  }
}

solution(input);
