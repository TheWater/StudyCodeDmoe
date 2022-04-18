setTimeout(() => {
    console.log(1);
}, 200);
console.log(2);
setTimeout(() => {
    console.log(3);
}, 10);
console.log(4);
console.log(5);
setTimeout(() => {
    console.log(6);
}, 8);
setTimeout(() => {
    console.log(8);
}, 15);
console.log(7);
for (let i = 0; i < 900000000; i++) {
    // 此循环大概200ms
}
console.log(9);


// 2 4 5 7 9 6 3 8 1







//2 4 5 7 9   6 3 8 1
