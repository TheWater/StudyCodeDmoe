#include <iostream>
using namespace std;

// 本程序用递归算法求n的阶乘

int counter = 0;

int fac(int n)
{
  counter++; // 断点
  cout << "第" << counter << "次调用：n=" << n << endl;

  if (n == 0 || n == 1)
    return 1;
  else
    return n * fac(n - 1);
}

int main()
{
  cout << "结果：fac(5)=" << fac(5) << endl;
  return 0;
}