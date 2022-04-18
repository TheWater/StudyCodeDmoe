

const querystring = require('querystring');
const o=querystring.parse('foo-bar&abc=xyz&abc=123','&','=')
console.log(o.foo);

let obj={name:'wang',pass:'123',sex:"0"}; 
let s=querystring.stringify(obj);
console.log(s);

let string='w%3D%E4%BD%A0%E5%A5%BD%26foo%3Dbar';
let string2='W=你好&foo=bar';
let res=querystring.unescape(string);
let res2=querystring.escape(string2);