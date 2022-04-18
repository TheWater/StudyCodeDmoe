#include"D:\CODE\springDemo\StudyCodeDmoe\labDemo\c\lab4\src\LinkStack\LinkStack.cpp"
main(){

  ElemType result;
  //链式存储结构实现实验
  LinkNode *my_stack2;
  InitStack(my_stack2);

  for (int i = 1; i <= 10; i++)
    Push(my_stack2, i); //数据入栈，断点③

  TraverseStack(my_stack2);

  while (!StackEmpty(my_stack2))
    Pop(my_stack2, result); //数据出栈，断点④

  Destroy(my_stack2);


  return 0;
}