buf=Buffer.alloc(26)
console.log(buf);
for (let i = 0; i < 26; i++) {
  buf[i]=i+97
}
console.log(buf);
console.log(buf.toString('ascii'));
console.log(buf.toString('ascii',0,5));
console.log(buf.toString('utf8',0,5));
console.log(buf.toString('hex',0,5));
console.log(buf.toString(undefined,0,5));