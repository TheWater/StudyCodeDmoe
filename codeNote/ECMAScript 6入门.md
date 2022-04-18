# ECMAScript 6入门

## 01 变量的解构赋值

### 1 数组的解构赋值

基本用法：let [a,b,c] = [1,2,3]
				  let [ , , third]= ["foo", "bar", "baz"]  third//"baz"

模式匹配：

```javascript
let [x, y, ...z] = ['a'];
x // "a"
y // undefined
z // []
```

如果等号的右边不是数组（或者严格地说，不是可遍历的结构，参见《Iterator》一章），那么将会报错。

```javascript
// 报错
let [foo] = 1;
let [foo] = false;
let [foo] = NaN;
let [foo] = undefined;
let [foo] = null;
let [foo] = {};
```

默认值：

```javascript
let [foo = true] = [];
foo // true

let [x, y = 'b'] = ['a']; // x='a', y='b'
let [x, y = 'b'] = ['a', undefined]; // x='a', y='b'

let [x = 1] = [undefined];
x // 1
let [x = 1] = [null];
x // null
```

```javascript
let [x = 1, y = x] = [];     // x=1; y=1
let [x = 1, y = x] = [2];    // x=2; y=2
let [x = 1, y = x] = [1, 2]; // x=1; y=2
let [x = y, y = 1] = [];     // ReferenceError: y is not defined
```

### 2 对象的解构赋值

```javascript
let { foo, bar } = { foo: 'aaa', bar: 'bbb' };
foo // "aaa"
bar // "bbb"
```

```javascript
let { bar, foo } = { foo: 'aaa', bar: 'bbb' };
foo // "aaa"
bar // "bbb"

let { baz } = { foo: 'aaa', bar: 'bbb' };
baz // undefined
```

上面代码的第一个例子，等号左边的两个变量的次序，与等号右边两个同名属性的次序不一致，但是对取值完全没有影响。第二个例子的变量没有对应的同名属性，导致取不到值，最后等于`undefined`。

```javascript
let { foo: baz } = { foo: 'aaa', bar: 'bbb' };
baz // "aaa"

let obj = { first: 'hello', last: 'world' };
let { first: f, last: l } = obj;
f // 'hello'
l // 'world'
```

```javascript
const node = {
  loc: {
    start: {
      line: 1,
      column: 5
    }
  }
};

let { loc, loc: { start }, loc: { start: { line }} } = node;
line // 1
loc  // Object {start: Object}
start // Object {line: 1, column: 5}
```

### 3 函数参数的解构赋值

```javascript
function add([x, y]){
  return x + y;
}

add([1, 2]); // 3

[[1, 2], [3, 4]].map(([a, b]) => a + b);
// [ 3, 7 ]
```

默认值

```javascript
function move({x = 0, y = 0} = {}) {
  return [x, y];
}

move({x: 3, y: 8}); // [3, 8]
move({x: 3}); // [3, 0]
move({}); // [0, 0]
move(); // [0, 0]
```

```javascript
function move({x, y} = { x: 0, y: 0 }) {
  return [x, y];
}

move({x: 3, y: 8}); // [3, 8]
move({x: 3}); // [3, undefined]
move({}); // [undefined, undefined]
move(); // [0, 0]
```

## 02 使用Promise

[`Promise`](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Promise) 是一个对象，它代表了一个异步操作的最终完成或者失败

### 1 异步函数调用

~~~ javascript
// 成功的回调函数
function successCallback(result) {
  console.log("音频文件创建成功: " + result);
}

// 失败的回调函数
function failureCallback(error) {
  console.log("音频文件创建失败: " + error);
}

createAudioFileAsync(audioSettings, successCallback, failureCallback)

//重写为返回Promise的形式
const promise = createAudioFileAsyns(audioSetting);
promise.then(successCallback, failureCallback);
//或简写成
createAudioFileAsync(audioSettings).then(successCallback, failureCallback);

~~~

使用Promise时，会有以下约定：

* 本轮 **事件循环** 运行完成之前，回调函数是不会被调用的。
* 即使异步操作已经完成（成功或失败，在这之后通过**then()** 添加的回调函数也会被调用）
* 通过多次调用 **then()**  可以添加多个回调函数，它们会按照插入顺序进行执行。

Promise 很棒的一点就是**链式调用**（**chaining**）



## 03 async/await原理及实例解析

`async/await` 是 `ES7` 中用来处理异步回调的一种写法

**async 和 await 起了什么作用**

~~~javascript
async function testAsync() {
  return "hello async";
}
const result = testAsync();
console.log(result);
~~~

编译结果：
![image-20220310155246696](D:\大二下课程资料\笔记\ECMAScript 6入门.assets\image-20220310155246696.png)

**async返回一个Promise对象**，如果在函数中return一个直接量，async 会把这个直接量通过Promise.resolve()封装成 Promise 对象

使用箭头函数：

~~~javascript
let hello = async()=>{return "hello"};
~~~

要实际使用Promise完成时的返回的值，我们可以使用.then()块

~~~javascript
hello().then((value) => console.log(value))
// 简写
hello().then(console.log)
~~~

 **await 只在异步函数里面才起作用**。它可以放在任何异步的，基于 promise 的函数之前。它会暂停代码在该行上，直到 promise 完成，然后返回结果值。在暂停的同时，其他正在等待执行的代码就有机会执行了。

~~~javascript
async function hello() {
  return greeting = await Promise.resolve("Hello");
};

hello().then(alert);
~~~



## 04 Promise对象

> ECMAscript 6 原生提供了 Promise 对象。
>
> Promise 对象代表了未来将要发生的事件，用来传递异步操作的消息。

**Promise对象具有两个特点：**

1. **对象的状态不受外界影响。**Promise对象代表一个异步操作，具有三种状态：

   * pending：初始状态，不是成功或失败状态
   * fulfilled：操作成功
   * rejected：操作失败

2. **一旦状态改变，就不会再变。**
   状态改变只有两种可能，从pending到fulfilled或从pending到rejected。只要发生，状态就凝固了，不会再变，会一直保持这个结果。

   

### 1 Promise的创建

使用new来调用Promise构造器进行实例化

~~~javascript
var promise = new Promise(function(resolve, reject) {    // 异步处理    // 处理结束后、调用resolve 或 reject });
    
    //resolve解析 reject拒绝两个参数的回调，一切正常则resolve,否则reject
    
// 实例
var myFirstPromise = new Promise(function(resolve, reject){
    //当异步代码执行成功时，我们才会调用resolve(...), 当异步代码失败时就会调用reject(...)
    //在本例中，我们使用setTimeout(...)来模拟异步代码，实际编码时可能是XHR请求或是HTML5的一些API方法.
    setTimeout(function(){
        resolve("成功!"); //代码正常执行！
    }, 250);
});
 
myFirstPromise.then(function(successMessage){
    //successMessage的值是上面调用resolve(...)方法传入的值.
    //successMessage参数不一定非要是字符串类型，这里只是举个例子
    document.write("Yay! " + successMessage);
});
    
 myFristPromise.then(onFulfilled,onRejected);
 myFristPromise.then(onFulfilled).catch(onRejected)
~~~

对于已经实例化过的 promise 对象可以调用 promise.then() 方法，传递 resolve 和 reject 方法作为回调。
promise.then() 是 promise 最为常用的方法。

### 2 Promise的实例

**Promise Ajax**

~~~javascript
function ajax(URL) {
    return new Promise(function (resolve, reject) {
        var req = new XMLHttpRequest(); 
        req.open('GET', URL, true);
        req.onload = function () {
        if (req.status === 200) { 
                resolve(req.responseText);
            } else {
                reject(new Error(req.statusText));
            } 
        };
        req.onerror = function () {
            reject(new Error(req.statusText));
        };
        req.send(); 
    });
}
var URL = "/try/ajax/testpromise.php"; 
ajax(URL).then(function onFulfilled(value){
    document.write('内容是：' + value); 
}).catch(function onRejected(error){
    document.write('错误：' + error); 
});
~~~

Promise的resovle方法除了正常的值还可以是一个Promise实例

~~~javascript
var p1 = new Promise(function(resolve, reject){
  // ... some code
});
 
var p2 = new Promise(function(resolve, reject){
  // ... some code
  resolve(p1);
})

//上面代码中，p1 和 p2 都是 Promise 的实例，但是 p2 的 resolve 方法将 p1 作为参数，这时 p1 的状态就会传递给 p2。如果调用的时候，p1 的状态是 pending，那么 p2 的回调函数就会等待 p1 的状态改变；如果 p1 的状态已经是 fulfilled 或者 rejected，那么 p2 的回调函数将会立刻执行。
~~~

### 4 Promise.prototype.then方法：链式操作

Promise.prototype.then 方法返回的是一个新的 Promise 对象，因此可以采用链式写法

~~~javascript
getJSON("/posts.json").then(function(json) {
  return json.post;
}).then(function(post) {
  // proceed
});
// 上面的代码使用 then 方法，依次指定了两个回调函数。第一个回调函数完成以后，会将返回结果作为参数，传入第二个回调函数。
// 如果前一个回调函数返回的是Promise对象，这时后一个回调函数就会等待该Promise对象有了运行结果，才会进一步调用。

~~~

### 5 Promise.prototype.catch方法：捕捉错误

Promise.prototype.catch 方法是 Promise.prototype.then(null, rejection) 的别名，用于指定发生错误时的回调函数。

~~~javascript
getJSON("/posts.json").then(function(posts) {
  // some code
}).catch(function(error) {
  // 处理前一个回调函数运行时发生的错误
  console.log('发生错误！', error);
});

// Promise 对象的错误具有"冒泡"性质，会一直向后传递，直到被捕获为止。也就是说，错误总是会被下一个 catch 语句捕获。
~~~

### 6 Promise.all方法，Promise.race方法

~~~javascript
var p = Promise.all([p1,p2,p3]);
~~~

上面代码中，Promise.all 方法接受一个数组作为参数，p1、p2、p3 都是 Promise 对象的实例。（Promise.all 方法的参数不一定是数组，但是必须具有 iterator 接口，且返回的每个成员都是 Promise 实例。

P的状态：

1. 只有p1，p2，p3都维fuilled时，p才为fuilled。此时的返回值组成一个数组，传递给p的回调函数
2. 只要其中一个被rejected，p就为rejected。此时第一个被rejected的实例的返回值，传递给p的回调函数

实例：

~~~javascript
// 生成一个Promise对象的数组
var promises = [2, 3, 5, 7, 11, 13].map(function(id){
  return getJSON("/post/" + id + ".json");
});
 
Promise.all(promises).then(function(posts) {
  // ...  
}).catch(function(reason){
  // ...
});
// Promise.race 方法同样是将多个 Promise 实例，包装成一个新的 Promise 实例。
var p = Promise.race([p1,p2,p3]);
~~~

## 05 Callback回调函数

> 1. 函数可以作为一个参数在传递到另一个函数中。
>
> 2. JS是异步编程语言。

实例一：

~~~javascript
var fs = require("fs");
var c

function f(x) {
    console.log(x)
}

function writeFile() {
    fs.writeFile('input.txt', '我是通过fs.writeFile 写入文件的内容', function (err) {
        if (!err) {
            console.log("文件写入完毕!")
            c = 1
        }
    });
}

c = 0
writeFile()
f(c)
// 打印结果：0

~~~

**正常逻辑：**

> 1. 首先c = 0
> 2. 然后调用writeFile()函数
> 3. 然后调用f(c),打印c的值

**分析：**

> 因为writeFile()是一个比较耗时的IO操作，JS碰到并不会原地等待直到函数执行完毕，而是直接执行下一行代码。而此时，writeFile()内部的c=1并没执行，所以最后打印结果为0
>
> 解决：只要把f(c)放进writeFile()里面就行了，但是f()就焊死在里面了。这时候就需要**关键字callback**

修改后实例一：

~~~javascript
var fs = require("fs");

function f(x) {
    console.log(x)
}

function writeFile(callback) { //关键字callback，表示这个参数不是一个普通变量，而是一个函数
    fs.writeFile('input.txt', '我是通过fs.writeFile 写入文件的内容', function (err) {
        if (!err) {
            console.log("文件写入完毕!")
            c = 1
            callback(c) // 因为我们传进来的函数名是f()，所以此行相当于调用一次f(c)
        }
    });
}
var c = 0
writeFile(f) // 函数f作为一个实参传进writeFile函数
~~~

**在大多数编程语言中，函数的形参总是由外往内向函数体传递参数，但在JS里如果形参是关键字"callback"则完全相反，它表示函数体在完成某种操作后由内向外调用某个外部函数。**

匿名函数

~~~javascript
var fs = require("fs");

function writeFile(callback) { 
    fs.writeFile('input.txt', '我是通过fs.writeFile 写入文件的内容', function (err) {
        if (!err) {
            console.log("文件写入完毕!")
            c = 1
            callback(c) 
        }
    });
}
var c = 0
writeFile(function (x) {
    console.log(x)
})
~~~

## 06 Node的核心板块

### nodemon

> **nodemon**用来监视node.js应用程序中的任何更改并自动重启服务,非常适合用在开发环境中。
>
> **nodemon**将监视启动目录中的文件，如果有任何文件更改，nodemon将自动重新启动node应用程序。

```
npm install -g nodemon
```

退出 ctrl+c

### Node中的模块-第三方模块

（1）npm install module_name -S即 **npm install --save** 写入dependencies 用于生产环境

（2）npm install module_name -D 即 **npm install --save--dev** 写入devDependencies 仅用于开发环境

（3）**npm install module_name -g** 全局安装(不进入项目目录)

（4）**npm install module_name** 本地安装(安装包放在 ./node_modules 下)
