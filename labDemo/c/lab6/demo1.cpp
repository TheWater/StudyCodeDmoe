#include <iostream>
#include <stack>
using namespace std;
 
// (1). 设置工作栈中元素的结构体
struct Datatype
{
    int n;          // 当前输入数据n
    long fn;        // Factorial(n)的返回值
    long fn_1;      // 局部变量Factorial(n-1)
    int retAddr;    // 模仿返回地址，调用第i个递归函数的标示符为i(i=1,2,3,...,t)；t+1为栈底标示符，也是结束符
};
 
long Factorial(int N)
{
    // (3). 增加非递归入口
    // 初始化
    Datatype currArea, areaTemp;    // 当前栈中的元素，和一个临时元素
    currArea.n = N;                 // 当前元素的n值
    currArea.fn = 0;
    currArea.fn_1 = 0;
    currArea.retAddr = 2;           // 栈底"监视哨"，作为整个循环的结束标志
    long retResult = 0;             // 存储最终结果的变量
 
    // (1). 设置一个工作栈
    stack<Datatype> s;
    s.push(currArea);
 
// (2). 设置t+2个语句标号(t为递归函数内调用本身的次数，编号分别为0,1,...,t+1)
// 由于例子中函数只调用本身一次，所以t=1
label0:                             // 递归总入口
    areaTemp = s.top();             // 获取栈顶元素的值，判断元素的n值是否为1
    if (areaTemp.n == 1)            // 当前元素为1时，赋初值
    {
        s.pop();                    // 先弹出栈顶元素，赋予新值之后再入栈
        areaTemp.fn = 1;            // Factorial(1) = 1;
        areaTemp.retAddr = 1;       // 置返回地址为1，第一个递归调用函数结束
        s.push(areaTemp);           // 将新的结果存入栈
        goto label2;                // 转向递归调用总出口
    }
 
    // 依次循环将Factorial(n-1) ... Factorial(1)入栈
    currArea.n--;
    currArea.fn = 0;
    currArea.fn_1 = 0;
    currArea.retAddr = 1;
    s.push(currArea);
    goto label0;
// (4). 替换第i(i=1...t)个递归规则
label1:                             // 第一个递归函数的出口
    // 获取栈顶两个元素
    areaTemp = s.top();
    s.pop();
    currArea = s.top();
    s.pop();
    currArea.fn_1 = areaTemp.fn;    // 后一个元素Factorial(n-1)的值就是前一个元素Factorial(n)的值
    currArea.fn = currArea.n * currArea.fn_1;   // 得到当前的Factorial(n)=n*Factorial(n-1)值
    s.push(currArea);               // 再次将新元素的结果入栈
    goto label2;                    // 转向递归调用总出口，(5). 增加goto lebel t+1;
label2:                             // 递归调用总出口，(6). 标号为t+1的语句格式
    areaTemp = s.top();
    switch(areaTemp.retAddr)
    {
    case 1:
        goto label1;
        break;
    case 2:                         // 如果获得的是栈底元素，结束整个循环
        s.pop();                    // 退栈，清空栈
        retResult = areaTemp.fn;
        break;
    default:
        cerr << "error label number in stack!" << endl;
        break;
    }
 
    return retResult;
}
 
// 尾递归转非递归，用循环结构优化处理(最开始就教的这个步骤)
long Factorial2(int N)
{
    long result = 1;
    for (int i = 2; i <= N; ++i)
        result = result * i;
    return result;
}
 
int main()
{
    int number;
    cin >> number;
    cout << Factorial(number) << endl;
    cout << Factorial2(number) << endl;
    return 0;
}