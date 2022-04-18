#include"D:\CODE\springDemo\StudyCodeDmoe\labDemo\c\lab5\LinkQueue\LinkQueue.cpp"
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
main()
{

}