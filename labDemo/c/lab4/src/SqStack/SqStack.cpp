#include "SqStack.h"

//初始化空顺序栈
void InitStack(SqStack &S)
{
  S.top = -1;
}

//判栈空
bool StackEmpty(SqStack S)
{
  if (S.top == -1)
    return true;
  else
    return false;
}

//入栈
bool Push(SqStack &S, ElemType item)
{
  if (S.top == MaxSize - 1) {
    cout << "栈满" << endl;
    return false;
  }
  S.top++;
  S.data[S.top] = item;
  return true;
}

//出栈
bool Pop(SqStack &S, ElemType &item)
{
  if (S.top == -1) {
    cout << "栈空" << endl;
    return false;
  }
  item = S.data[S.top];
  S.top--;
  return true;
}

//取栈顶
bool GetTop(SqStack S, ElemType &item)
{
  if (S.top == -1) {
    cout << "栈空" << endl;
    return false;
  }
  item = S.data[S.top];
  return true;
}

void TraverseStack(SqStack S)
{
    while (!S.top== -1)
    {
      cout<<S.data[S.top]<<" ";
      S.top--;
    }
    
  
  
  
  
}