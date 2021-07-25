const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

function solution(input) {
  const word = input[0];
  const wordLength = word.length;
  let answer = 0;

  for (let i = 0; i < wordLength; i++) {
    answer += findNumber(word[i]) + 1;
  }
  console.log(answer);
}

function findNumber(char) {
  if (char >= "A" && char <= "C") {
    return 2;
  }
  if (char >= "D" && char <= "F") {
    return 3;
  }
  if (char >= "G" && char <= "I") {
    return 4;
  }
  if (char >= "J" && char <= "L") {
    return 5;
  }
  if (char >= "M" && char <= "O") {
    return 6;
  }
  if (char >= "P" && char <= "S") {
    return 7;
  }
  if (char >= "T" && char <= "V") {
    return 8;
  }
  if (char >= "W" && char <= "Z") {
    return 9;
  }
}

solution(input);
