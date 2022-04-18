async function f(){
    return "Hello";
}
console.log(f())
f().then(value => {
    console.log(value)
},reason => {

})