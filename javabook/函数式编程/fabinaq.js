function fibRec(n, a1 = 1, a2 = 1) {
  if (n <= 1) {return a1};
  return fibRec(n-1, a2, a1 + a2);
}

var x = fibRec(4);
console.log(x);
