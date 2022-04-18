#include"D:\CODE\springDemo\StudyCodeDmoe\labDemo\c\lab4\src\SqStack\SqStack.cpp"

main()
{
  ElemType result;

  //顺序存储结构实现实验 
  SqStack my_stack1;
  InitStack(my_stack1);

  for (int i = 1; i <= 10; i++)
    Push(my_stack1, i); //数据入栈，断点①

  TraverseStack(my_stack1);

  while (!StackEmpty(my_stack1))
    Pop(my_stack1, result); //数据出栈，断点②


}