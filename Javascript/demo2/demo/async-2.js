async function f(){
    //return "Hello";
    await new Promise(resolve => {
        setTimeout(function (){
            console.log('Hello')
        },2000)
    })
}
f();