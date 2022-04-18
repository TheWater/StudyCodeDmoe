#include "D:\CODE\springDemo\StudyCodeDmoe\labDemo\c\lab5\src\LinkQueue.cpp"
#include "D:\CODE\springDemo\StudyCodeDmoe\labDemo\c\lab5\src\SqQueue.cpp"

#include "D:\CODE\springDemo\StudyCodeDmoe\labDemo\c\lab5\src\SqStack.cpp"
#include "D:\CODE\springDemo\StudyCodeDmoe\labDemo\c\lab5\src\LinkStack.cpp"

#include <string.h>

void Reverse(LinkQueue Q)
{
  ElemType t;
  LinkStNode *S;
  InitStack(S);
  while (!QueueEmpty(Q)) {
    DeQueue(Q, t);
    Push(S, t);
  }
  while (!StackEmpty(S)) {
    Pop(S, t);
    EnQueue(Q, t);
  }
}

bool Palindrome_Test(char *str)
{
  ElemType ts,tq;
  LinkStNode *S;
  LinkStNode *S1;
  LinkQueue Q;
  InitQueue(Q);
  InitStack(S);
  InitStack(S1);
  
  for (int i = 0; str[i]!='\0'; i++)
  {
    Push(S,str[i]);
    EnQueue(Q,str[i]);
  }
  while (!StackEmpty(S)) {
    Pop(S,ts);
    DeQueue(Q, tq);
    if(ts != tq) return false;
  }
  return true;
}


int main()
{

  //第三题：判断回文
  char str[20];
  cout << "输入一个字符串：";
  cin >> str;
  if (Palindrome_Test(str))
    cout << str << "是回文" << endl;
  else
    cout << str << "不是回文" << endl;
  return 0;

}
